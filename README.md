# Millonario!

## Introducción

Este es un programa desarrollado en Java bajo el paradigma de programación orientado a objetos (POO) que simula un concurso de preguntas y respuestas. Se utilizó la arquitectura Modelo Vista Controlador (MVC) haciendo persistencia de datos en el motor de bases de datos MySql y cuenta con una interfáz grafica lograda con swing.

## Configuración

Para ejecutar este proyecto seguir los siguientes pasos:

- Clonar el repositorio
- Abrir el repositorio en el IDE (De preferencia Netbeans)
- Crear la base de datos en MySql  (En la imagen abajo se utiliza MySQL Workbench) tan solo con copiar TODO el contenio del file "DBCreation.sql" que se encuentra en esta ubicación dentro del proyecto:  Millonario\src\utils

  ![image](https://user-images.githubusercontent.com/93751091/147413306-4f8fa096-daa7-410f-8046-5983f87e116a.png)

  ![image](https://user-images.githubusercontent.com/93751091/147413379-1f7a35dd-5e91-471d-ab56-97591e3c126f.png)


- La clase "ConnectDB" en el paquete "utils" utiliza un archivo .json para hacer la lectura de los datos y luego hacer la inyección de los mismos para la conección a la base de datos. Solo debes abrir el archivo "db_credentials.json" y reemplazar la información con la de tu base de datos así:

   ![image](https://user-images.githubusercontent.com/93751091/147413614-7617ffb8-8959-4855-80c5-3baee0d4e555.png)

- Ejecutar el programa

## Flujo de Ejecución y Features

La siguiente información sobre el juego es obtenida haciendo lectura a la base de datos

![image](https://user-images.githubusercontent.com/93751091/147413902-b34973cd-c102-4cd5-a8e8-334bf4c27428.png)

1. Se muestra el próximo premio a conseguir según la ronda
2. Se muestran las rondas conquistadas
3. Se muestra el acumulado hasta el momento
4. Se muestra una tabla con los resultados históricos ranqueados por premio obtenido  y mostrando la ronda alcanzada
5. Botón que da inicio al juego

![image](https://user-images.githubusercontent.com/93751091/147414097-6feb1302-f9ff-480b-9b6d-605726d560c2.png)

1. Se trae una pregunta al azar según la ronda desde la base de datos al igual que sus posibles respuestas según el ID de la pregunta
2. El jugador siempre tiene la posibilidad de abandonar el juego con el puntaje actual

![image](https://user-images.githubusercontent.com/93751091/147414161-6aa72ff8-b55b-4a89-aa4b-d49147c4f532.png)

![image](https://user-images.githubusercontent.com/93751091/147414193-94886c6e-74d9-45e4-9ddd-1af1bf2086c9.png)

1. Se la respuesta es correcta se actualiza la información del juego
2. Se trae la siguiente pregunta en orden de dificultad de la base de datos de forma aleatoria


Si el jugador no abandona, el juego termina cuando:

![image](https://user-images.githubusercontent.com/93751091/147414317-4124df46-de9e-4d0b-b679-6eeb3f987ec7.png)

1. El jugador ha contestado con éxito todas las preguntas

![image](https://user-images.githubusercontent.com/93751091/147414386-901ce9bf-d5d0-47ad-b464-9675088f5f64.png)

2. Falla alguna pregunta

![image](https://user-images.githubusercontent.com/93751091/147414402-25f61529-ed04-4eca-b593-56c5321582ed.png)

Al final se registra el jugador para luego hacer el registro de la partida

![image](https://user-images.githubusercontent.com/93751091/147414434-76b951a8-4213-4bef-a2ea-3dc22ddcb70a.png)

Si el jugador ya se ha registrado anteriormente puede hacer el registro mediante un combobox que trae los IDs de los jugadores de la base de datos

![image](https://user-images.githubusercontent.com/93751091/147414463-525993bf-4212-441f-adbc-a66dd5b2a247.png)

Si es la primera vez en el juego el jugador puede regitrar todos los datos 

![image](https://user-images.githubusercontent.com/93751091/147414485-44718c91-6617-4f55-b686-89ed7f164519.png)


Luego de hacer el registro del jugador se crea un registro para la partida, se resetea el juego y se muestra de nuevo el ranking de Partidas Pasadas

En este punto se puede empezar un juego nuevo sin necesidad de volver a ejecutar el programa


## Modelo Relacional Base de Datos

En el repositorio también se puede encontrar el modelo relacional de la base de datos

![image](https://user-images.githubusercontent.com/93751091/147414784-6c7c95fc-a0ef-4d5c-bd92-da725b35119b.png)

