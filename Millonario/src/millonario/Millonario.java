/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package millonario;

import Access.AnswerDAO;
import Access.LogDAO;
import Access.PlayerDAO;
import Access.QuestionDAO;
import Access.RoundDAO;
import Controller.Controller;
import Model.AnswerModel;
import Model.LogModel;
import Model.PlayerModel;
import Model.QuestionModel;
import Model.RoundModel;
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
        AnswerModel answMod = new AnswerModel();
        AnswerDAO answDAO = new AnswerDAO();
        RoundModel roundMod = new RoundModel();
        RoundDAO roundDAO = new RoundDAO();
        PlayerModel playerMod = new PlayerModel();
        PlayerDAO playerDAO = new PlayerDAO();
        
        Controller cont = new Controller(millMainFrame, logMod,logDAO, qMod, qDAO, answMod, answDAO, roundMod, roundDAO, playerMod, playerDAO);
        cont.initialize();
    }
    
}
