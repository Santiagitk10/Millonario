/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Access;

import Model.QuestionModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import utils.ConnectDB;

/**
 *
 * @author SANTIAGO SIERRA
 */
public class QuestionDAO {
    private Connection conn = null;
    
    
    public ArrayList<QuestionModel> getQuestionsByCategoryId(int clearedRound){
        ArrayList<QuestionModel> questions = new ArrayList();
        
        try{

            conn = ConnectDB.getConnection();
           
            String sql = "select * from question where category_id_fk=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, clearedRound+1);
            ResultSet result = statement.executeQuery();
            
            while(result.next()){
                QuestionModel question = new QuestionModel(result.getInt(1), result.getString(2),result.getInt(3));
                questions.add(question);
            }
            
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Código: " + ex.getErrorCode() + "\nError : " + ex.getMessage());
        } finally {
            try{
                conn.close();
            } catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Código: " + ex.getErrorCode() + "\nError : " + ex.getMessage());
            }
        }
        
        return questions;
    }
}
