/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Access.LogDAO;
import Access.QuestionDAO;
import Model.LogModel;
import Model.QuestionModel;
import View.MillMainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JLabel;
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
    
    private int clearedRounds = 0;
    private int accumPrize = 0;
    private int nextPrize = 1000;
    
    

    public Controller(MillMainFrame millMainFrame, LogModel logMod, LogDAO logDAO,  QuestionModel qMod, QuestionDAO qDAO) {
        this.millMainFrame = millMainFrame;
        this.logMod = logMod;
        this.logDAO = logDAO;
        this.qMod = qMod;
        this.qDAO = qDAO;
    }
    
   
    
    public void initialize(){
        
        millMainFrame.jLabelNextPrize.setText(Integer.toString(nextPrize));
        millMainFrame.jLabelAccumPrize.setText(Integer.toString(accumPrize));
        millMainFrame.jLabelClearedRound.setText(Integer.toString(clearedRounds));
        millMainFrame.setTitle("Millonario");
        millMainFrame.setLocationRelativeTo(null);
        millMainFrame.setVisible(true);
        setTableResults(logDAO.getAllLogs(),millMainFrame.JTableLog);
        
        millMainFrame.jButtonStart.addActionListener(this);
        
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
            setQuestion(qDAO.getQuestionsByCategoryId(clearedRounds),millMainFrame.jLabelSelectedQuestion);
        }
        
    }
    
    
    public void setTableResults(ArrayList<LogModel> logModels, JTable table){
            table.removeAll();
            DefaultTableModel tableModel = new DefaultTableModel();
            String[] headers = {"Registro","Premio","Ronda Alcanzada","ID Jugador"};
            tableModel.setColumnIdentifiers(headers);
            table.setModel(tableModel);
            for(int i=0; i<logModels.size(); i++){
                tableModel.addRow(logModels.get(i).toArray());
            }
    }
    
    public void setQuestion(ArrayList<QuestionModel> questionModels,JLabel label){
        //En en random number usar el video en bookmarks y hacer loop hasta que no sea cero
        //Testear con salidas
//        label.setText(string);
    }

    
    
}
