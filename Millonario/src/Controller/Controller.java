/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Access.AnswerDAO;
import Access.LogDAO;
import Access.PlayerDAO;
import Access.QuestionDAO;
import Access.RoundDAO;
import Model.AnswerModel;
import Model.LogModel;
import Model.PlayerModel;
import Model.QuestionModel;
import Model.RoundModel;
import View.MillMainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SANTIAGO SIERRA
 */
public class Controller implements ActionListener {
    
    
    private MillMainFrame millMainFrame;
    private LogModel logMod;
    private LogDAO logDAO;
    private QuestionModel qMod;
    private QuestionDAO qDAO;
    private AnswerModel answMod;
    private AnswerDAO answDAO;
    private RoundModel roundMod;
    private RoundDAO roundDAO;
    private PlayerModel playerMod;
    private PlayerDAO playerDAO;
    ArrayList<PlayerModel> players;
    private JComboBox JCBoxPlayerIDs;
    
    
    private int clearedRounds = 0;
    private int accumPrize = 0;
    private int nextPrize = 1000;
    private String currentCorrectAnswer = "";
    
    

    public Controller(MillMainFrame millMainFrame, LogModel logMod, LogDAO logDAO,  QuestionModel qMod, QuestionDAO qDAO, AnswerModel answMod, AnswerDAO answDAO, RoundModel roundMod, RoundDAO roundDAO, PlayerModel playerMod, PlayerDAO playerDAO) {
        this.millMainFrame = millMainFrame;
        this.logMod = logMod;
        this.logDAO = logDAO;
        this.qMod = qMod;
        this.qDAO = qDAO;
        this.answMod = answMod;
        this.answDAO = answDAO;
        this.roundMod = roundMod;
        this.roundDAO = roundDAO;
        this.playerMod = playerMod;
        this.playerDAO = playerDAO;
    }
    
   
    
    public void initialize(){
        
        showScore();
        millMainFrame.setTitle("Millonario");
        millMainFrame.setLocationRelativeTo(null);
        millMainFrame.setVisible(true);
        millMainFrame.jButtonQuit.setVisible(false);
        setTableResults(logDAO.getAllLogs(),millMainFrame.JTableLog);
        
        players = new ArrayList(playerDAO.getAllPlayers());
        players.add(0, new PlayerModel(0,"Jugadores"));
        JCBoxPlayerIDs = new JComboBox();
        JCBoxPlayerIDs.setModel(new DefaultComboBoxModel<>(players.toArray(new PlayerModel[players.size()])));
        JCBoxPlayerIDs.setSelectedIndex(0);
        JCBoxPlayerIDs.setBounds(270, 190, 160, 30);
        millMainFrame.veteralPanel.add(JCBoxPlayerIDs);
        
        millMainFrame.jButtonStart.addActionListener(this);
        millMainFrame.JButtonOpA.addActionListener(this);
        millMainFrame.JButtonOpB.addActionListener(this);
        millMainFrame.JButtonOpC.addActionListener(this);
        millMainFrame.JButtonOpD.addActionListener(this);
        millMainFrame.jButtonNewbie.addActionListener(this);
        millMainFrame.jButtonRegisterNewbie.addActionListener(this);
        millMainFrame.jButtonVeteran.addActionListener(this);
        millMainFrame.jButtonRegisterVeteran.addActionListener(this);
        millMainFrame.jButtonQuit.addActionListener(this);
        millMainFrame.jButtonNoRegister.addActionListener(this);
        millMainFrame.jButtonNoRegisterNewbie.addActionListener(this);
        millMainFrame.jButtonNoRegisterVeteran.addActionListener(this);
        millMainFrame.jButtonBackNewbie.addActionListener(this);
        millMainFrame.jButtonBackVeteran.addActionListener(this);
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
       
        if(e.getSource() == millMainFrame.jButtonStart){
            millMainFrame.questionPanel.removeAll();
            millMainFrame.questionPanel.revalidate(); 
            millMainFrame.questionPanel.repaint(); 
            millMainFrame.questionPanel.add(millMainFrame.qSelectPanel);
            millMainFrame.questionPanel.revalidate();
            millMainFrame.questionPanel.repaint();
            millMainFrame.jButtonStart.setVisible(false);
            millMainFrame.jButtonQuit.setVisible(true);
            setQuestion(qDAO.getQuestionsByCategoryId(clearedRounds), this.millMainFrame);
        }
        
        if(e.getSource() == millMainFrame.JButtonOpA){
            checkAnswer(millMainFrame.JButtonOpA);
        }
        
        if(e.getSource() == millMainFrame.JButtonOpB){
            checkAnswer(millMainFrame.JButtonOpB);
        }
        
        if(e.getSource() == millMainFrame.JButtonOpC){
            checkAnswer(millMainFrame.JButtonOpC);
        }
        
        if(e.getSource() == millMainFrame.JButtonOpD){
            checkAnswer(millMainFrame.JButtonOpD);
        }
        
        if(e.getSource() == millMainFrame.jButtonNewbie){
            millMainFrame.questionPanel.removeAll();
            millMainFrame.questionPanel.revalidate(); 
            millMainFrame.questionPanel.repaint(); 
            millMainFrame.questionPanel.add(millMainFrame.newbiePanel);
            millMainFrame.questionPanel.revalidate();
            millMainFrame.questionPanel.repaint();
        }
        
        if(e.getSource() == millMainFrame.jButtonVeteran){
            resetComboBox();
            millMainFrame.questionPanel.removeAll();
            millMainFrame.questionPanel.revalidate(); 
            millMainFrame.questionPanel.repaint(); 
            millMainFrame.questionPanel.add(millMainFrame.veteralPanel);
            millMainFrame.questionPanel.revalidate();
            millMainFrame.questionPanel.repaint();
        }
        
        
        
        if(e.getSource() == millMainFrame.jButtonRegisterNewbie){
            if(!millMainFrame.jTextPlayerID.equals("") && !millMainFrame.jTextPlayerName.equals("")){
                long currentPlayerId = Long.parseLong(millMainFrame.jTextPlayerID.getText());
                playerMod.setPlayerId(currentPlayerId);
                playerMod.setPlayerName(millMainFrame.jTextPlayerName.getText());
                int rowsAffected = playerDAO.insertPlayer(playerMod);
                if(rowsAffected>0){
                    logMod.setAccumPrize(accumPrize);
                    logMod.setFinalRoundFk(clearedRounds);
                    logMod.setPlayerIdFk(currentPlayerId);
                    logDAO.insertLog(logMod);
                    resetGame();
                } else {
                     JOptionPane.showMessageDialog(null,"No ha sido posible registrar la partida");
                     millMainFrame.questionPanel.removeAll();
                     millMainFrame.questionPanel.revalidate(); 
                     millMainFrame.questionPanel.repaint(); 
                     millMainFrame.questionPanel.add(millMainFrame.registrationPanel);
                     millMainFrame.questionPanel.revalidate();
                     millMainFrame.questionPanel.repaint();
                }
                millMainFrame.jTextPlayerID.setText("");
                millMainFrame.jTextPlayerName.setText("");
                
            } else {
                JOptionPane.showMessageDialog(null,"Todos los campos deben ser diligenciados");
            }
        }
        
        if(e.getSource() == millMainFrame.jButtonRegisterVeteran){

            if(!JCBoxPlayerIDs.getSelectedItem().toString().equals("0")){
                long currentPlayerId = Long.parseLong(JCBoxPlayerIDs.getSelectedItem().toString());
                logMod.setAccumPrize(accumPrize);
                logMod.setFinalRoundFk(clearedRounds);
                logMod.setPlayerIdFk(currentPlayerId);
                logDAO.insertLog(logMod);
                resetGame();
                JCBoxPlayerIDs.setSelectedIndex(0);
                
            } else {
                JOptionPane.showMessageDialog(null,"Seleccione un ID de Jugador");
            }
        }
        
        
        if(e.getSource() == millMainFrame.jButtonQuit){
            int response = JOptionPane.showConfirmDialog(millMainFrame.jButtonQuit, "Está seguro que desea Abandonar?\n Se irá de la competencia con el acumulado actual", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(response == JOptionPane.YES_OPTION ){
               nextPrize = 0;
               showScore();
               JOptionPane.showMessageDialog(null,"Te has retirado\n"
                       + "Acumulado: " +accumPrize );
               millMainFrame.questionPanel.removeAll();
               millMainFrame.questionPanel.revalidate(); 
               millMainFrame.questionPanel.repaint(); 
               millMainFrame.questionPanel.add(millMainFrame.registrationPanel);
               millMainFrame.questionPanel.revalidate();
               millMainFrame.questionPanel.repaint();
               millMainFrame.jButtonQuit.setVisible(false);
            }
        }
        
        if(e.getSource() == millMainFrame.jButtonNoRegister || e.getSource() == millMainFrame.jButtonNoRegisterNewbie || e.getSource() == millMainFrame.jButtonNoRegisterVeteran ){
            resetGame();
        }
        
        
        if(e.getSource() == millMainFrame.jButtonBackNewbie || e.getSource() == millMainFrame.jButtonBackVeteran){
            millMainFrame.jTextPlayerID.setText("");
            millMainFrame.jTextPlayerName.setText("");
            JCBoxPlayerIDs.setSelectedIndex(0);
            millMainFrame.questionPanel.removeAll();
            millMainFrame.questionPanel.revalidate(); 
            millMainFrame.questionPanel.repaint(); 
            millMainFrame.questionPanel.add(millMainFrame.registrationPanel);
            millMainFrame.questionPanel.revalidate();
            millMainFrame.questionPanel.repaint();
            millMainFrame.jButtonQuit.setVisible(false);
            
        }
        
        
        
    }
    
    
    public void setTableResults(ArrayList<LogModel> logModels, JTable table){
            table.removeAll();
            DefaultTableModel tableModel = new DefaultTableModel();
            String[] headers = {"Registro","Premio","Ronda Alcanzada","Nombre Jugador"};
            tableModel.setColumnIdentifiers(headers);
            table.setModel(tableModel);
            for(int i=0; i<logModels.size(); i++){
                tableModel.addRow(logModels.get(i).toArray());
            }
    }
    
    
    public void setQuestion(ArrayList<QuestionModel> questionModels, MillMainFrame millMainFrame){
        Random ran = new Random();
        int randomNum = ran.nextInt(5);
        millMainFrame.jLabelSelectedQuestion.setText(questionModels.get(randomNum).getQuestion());
        
        ArrayList<AnswerModel> answers = new ArrayList();
        answers = answDAO.getAnswersByQuestionId(questionModels.get(randomNum).getQuestionId());
        millMainFrame.JButtonOpA.setText(answers.get(0).getAnswer());
        millMainFrame.JButtonOpB.setText(answers.get(1).getAnswer());
        millMainFrame.JButtonOpC.setText(answers.get(2).getAnswer());
        millMainFrame.JButtonOpD.setText(answers.get(3).getAnswer());
        
        for(int i = 0;i<answers.size();i++){
            if(answers.get(i).getAnswerStatus().equals("correct")){
                currentCorrectAnswer = answers.get(i).getAnswer();
            }
        }
       
        
    }

    
    public void checkAnswer(JButton button){
        if(button.getText().equals(currentCorrectAnswer)){
           JOptionPane.showMessageDialog(null,"Correcto!");
           clearedRounds++;
           accumPrize+= roundDAO.getPrizeByRoundId(clearedRounds).get(0).getRoundPrize();
           if(clearedRounds<5){
               nextPrize = roundDAO.getPrizeByRoundId(clearedRounds+1).get(0).getRoundPrize();
           }
           showScore();
           if(clearedRounds<5){
              setQuestion(qDAO.getQuestionsByCategoryId(clearedRounds), this.millMainFrame);
           }
           
           if(accumPrize == 139000){
               nextPrize = 0;
               showScore();
               JOptionPane.showMessageDialog(null,"Felicidades Ahora eres Millonari@!\n"
                       + "Acumulado: " +accumPrize );
               millMainFrame.questionPanel.removeAll();
               millMainFrame.questionPanel.revalidate(); 
               millMainFrame.questionPanel.repaint(); 
               millMainFrame.questionPanel.add(millMainFrame.registrationPanel);
               millMainFrame.questionPanel.revalidate();
               millMainFrame.questionPanel.repaint();
               millMainFrame.jButtonQuit.setVisible(false);
           }
        } else {
            nextPrize = 0;
            accumPrize = 0;
            showScore();
            JOptionPane.showMessageDialog(null,"Perdiste!\n"
                       + "Acumulado: " +accumPrize );
            millMainFrame.questionPanel.removeAll();
            millMainFrame.questionPanel.revalidate(); 
            millMainFrame.questionPanel.repaint(); 
            millMainFrame.questionPanel.add(millMainFrame.registrationPanel);
            millMainFrame.questionPanel.revalidate();
            millMainFrame.questionPanel.repaint();
            millMainFrame.jButtonQuit.setVisible(false);
        }
    }
    
    public void showScore(){
        millMainFrame.jLabelNextPrize.setText(Integer.toString(nextPrize));
        millMainFrame.jLabelAccumPrize.setText(Integer.toString(accumPrize));
        millMainFrame.jLabelClearedRound.setText(Integer.toString(clearedRounds));
    }
    
    public void resetGame(){
        clearedRounds = 0;
        accumPrize = 0;
        nextPrize = 1000;
        currentCorrectAnswer = "";
        showScore();
        setTableResults(logDAO.getAllLogs(),millMainFrame.JTableLog);
        millMainFrame.questionPanel.removeAll();
        millMainFrame.questionPanel.revalidate(); 
        millMainFrame.questionPanel.repaint(); 
        millMainFrame.questionPanel.add(millMainFrame.logPanel);
        millMainFrame.questionPanel.revalidate();
        millMainFrame.questionPanel.repaint();
        millMainFrame.jButtonStart.setVisible(true);
    }
    
    public void resetComboBox(){
        players = new ArrayList(playerDAO.getAllPlayers());
        players.add(0, new PlayerModel(0,"Jugadores"));
        JCBoxPlayerIDs.setModel(new DefaultComboBoxModel<>(players.toArray(new PlayerModel[players.size()])));
    }
    
    
}
