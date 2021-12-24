/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  SANTIAGO SIERRA
 * Created: 24/12/2021
 */

CREATE SCHEMA millonario;

USE millonario;

CREATE TABLE round (
    round_id int NOT NULL,
    round_prize int NOT NULL,
    primary key (round_id)
);

CREATE TABLE player (
    player_id bigint unsigned NOT NULL,
    Player_name varchar(30) NOT NULL,
    primary key (player_id)
);

CREATE TABLE category (
    category_id int auto_increment,
    category_name varchar(15) NOT NULL,
    round_id_fk int NOT NULL,
    primary key (category_id),
    foreign key(round_id_fk) references round(round_id)
);

CREATE TABLE question (
    question_id int auto_increment,
    question varchar(100) NOT NULL,
    category_id_fk int NOT NULL,
    primary key (question_id),
    foreign key(category_id_fk) references category(category_id)
);

CREATE TABLE answer (
    answer_id int auto_increment,
    answer_status varchar(10) NOT NULL,
    answer varchar(50) NOT NULL,
    question_id_fk int NOT NULL,
    primary key (answer_id),
    foreign key(question_id_fk) references question(question_id)
);

CREATE TABLE log (
    log_id int auto_increment,
    accum_prize int NOT NULL,
    final_round_fk int NOT NULL,
    player_id_fk bigint unsigned NOT NULL,
    primary key (log_id),
    foreign key(final_round_fk) references round(round_id),
    foreign key(player_id_fk) references player(player_id)
);

INSERT INTO round (round_id,round_prize) values
(1,1000),
(2,3000),
(3,10000),
(4,25000),
(5,100000);


INSERT INTO category (category_name,round_id_fk) values
('Deportes',1),
('Películas',2),
('Historia',3),
('Geografía',4),
('Química',5);


INSERT INTO question (question,category_id_fk) values
('¿Quién es el máximo goleador del FC Barcelona?',1),
('¿Cómo se llama el estadio del Bayern de Munich?',1),
('¿Qué país ha ganado más Eurocopas seguidas?',1),
('¿Si juegas a la NFL ¿qué deporte practicas?',1),
('¿Qué marca de raqueta usa Roger Federer?',1),
('¿Cuál es la película más taquilllera de la historia?',2),
('¿Quién dirigió la trilogía original de la saga Star Wars?',2),
('¿Quién dirigió la película Origen en el 2010?',2),
('¿Qué actor interpretó a Jack Dawson en la película Titanic?',2),
('¿Quién se llevó el Óscar a mejor actor por la película Forest Gump?',2),
('¿En que año descubrió Colón América?',3),
('¿En que guerra participó Juana de Arco?',3),
('¿Cuál era la capital del Imperio Inca?',3),
('¿Quién fue el primer emperador romano?',3),
('¿En que país nació Adolf Hitler?',3),
('El gran desierto de Gobi se ubica en...',4),
('¿Cuál de estos países no tiene acceso al Mar Mediterráneo?',4),
('¿Cuál es el rió más largo del mundo?',4),
('¿Qué país es el segundo más grande del mundo en términos de población?',4),
('¿Cuál de estos países es bañado únicamente por un océano?',4),
('¿Cuál es el elemento químico con menor peso atómico?',5),
('¿Cómo se llama la temperatura a la que una sustancia pasa de líquido a gas?',5),
('¿Cuál es el símbolo químico de la Plata?',5),
('¿Cómo se llaman los átomos que poseen carga positiva?',5),
('¿Cómo se llama la capa más externa de un átomo?',5);


INSERT INTO answer (answer_status,answer,question_id_fk) values
('correct','Lionel Messi',1),
('incorrect','David Ospina',1),
('incorrect','Cristiano Ronaldo',1),
('incorrect','David Beckam',1),
('incorrect','Atanasio Girardot',2),
('incorrect','Santiago Bernabeu',2),
('incorrect','Bayern Camp',2),
('correct','Allianz Arena',2),
('correct','España',3),
('incorrect','Brasil',3),
('incorrect','Argentina',3),
('incorrect','Alemania',3),
('incorrect','Baloncesto',4),
('correct','Fútbol americano',4),
('incorrect','Béisbol ',4),
('incorrect','Patinaje',4),
('incorrect','Babolat',5),
('incorrect','Prince',5),
('incorrect','Head',5),
('correct','Wilson',5),
('incorrect','The Wolf of Wallstreet',6),
('incorrect','Titanic',6),
('correct','Avengers: Endgame',6),
('incorrect','Spiderman',6),
('incorrect','Robert de Niro',7),
('correct','George Lucas',7),
('incorrect','Chritopher Nolan',7),
('incorrect','Steven Spielberg',7),
('incorrect','George Lucas',8),
('correct','Chritopher Nolan',8),
('incorrect','Quentin Trantino',8),
('incorrect','Martin Scorsese',8),
('correct','Leonardo DiCaprio.',9),
('incorrect','Pierce Brosnan',9),
('incorrect','Brat Pitt',9),
('incorrect','Hugh Jackman',9),
('correct','Tom Hanks',10),
('incorrect','Tom Cruise',10),
('incorrect','Johnny Depp',10),
('incorrect','Denzel Washington',10),
('incorrect','1502',11),
('incorrect','1496',11),
('correct','1492',11),
('incorrect','1488',11),
('incorrect','Primera Cruzada',12),
('incorrect','Guerras Napoleónicas',12),
('correct','La guerra de los 100 años',12),
('incorrect','La guerra de los 30 años',12),
('correct','Cuzco',13),
('incorrect','Quito',13),
('incorrect','Machu Picchu',13),
('incorrect','Lima',13),
('correct','Cesar Augusto',14),
('incorrect','Julio Cesar',14),
('incorrect','Nerón',14),
('incorrect','Calígula',14),
('incorrect','Suiza',15),
('incorrect','Alemania',15),
('incorrect','Polonia',15),
('correct','Austria',15),
('incorrect','América Central',16),
('correct','Asia',16),
('incorrect','África',16),
('incorrect','Sudamérica',16),
('correct','Serbia',17),
('incorrect','Eslovenia',17),
('incorrect','Chipre',17),
('incorrect','Egipto',17),
('correct','Nilo',18),
('incorrect','Amazonas',18),
('incorrect','Río Amarillo',18),
('incorrect','Yangtsé',18),
('incorrect','China',19),
('incorrect','Rusia',19),
('correct','India',19),
('incorrect','Indonesia',19),
('incorrect','Canadá',20),
('incorrect','Rusia',20),
('incorrect','México',20),
('correct','Gran Bretaña',20),
('incorrect','Fósforo',21),
('incorrect','Plutonio',21),
('incorrect','Aluminio',21),
('correct','El hidrógeno',21),
('correct','Punto de Ebullición',22),
('incorrect','Punto de Refracción',22),
('incorrect','Punto de Calefacción',22),
('incorrect','Punto de Fusión',22),
('correct','Ag',23),
('incorrect','Pt',23),
('incorrect','Ta',23),
('incorrect','At',23),
('incorrect','Protones',24),
('correct','Cationes',24),
('incorrect','Electrones',24),
('incorrect','Aniones',24),
('incorrect','Capa de Von Neuman',25),
('correct','Capa de valencia',25),
('incorrect','Capa Turing',25),
('incorrect','Cata electrolita',25);