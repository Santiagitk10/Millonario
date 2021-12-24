/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package millonario;

import Access.LogDAO;
import Access.QuestionDAO;
import Controller.Controller;
import Model.LogModel;
import Model.QuestionModel;
import View.MillMainFrame;

/**
 *
 * @author SANTIAGO SIERRA
 */
public class Millonario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MillMainFrame millMainFrame = new MillMainFrame();
        LogModel logMod = new LogModel();
        LogDAO logDAO = new LogDAO();
        QuestionModel qMod = new QuestionModel();
        QuestionDAO qDAO = new QuestionDAO();
        
        Controller cont = new Controller(millMainFrame, logMod,logDAO, qMod, qDAO);
        cont.initialize();
    }
    
}
