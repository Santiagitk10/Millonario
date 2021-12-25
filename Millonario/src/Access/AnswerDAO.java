/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Access;

import Model.AnswerModel;
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
public class AnswerDAO {
    private Connection conn = null;
    
    
    public ArrayList<AnswerModel> getAnswersByQuestionId(int questionId){
        ArrayList<AnswerModel> answers = new ArrayList();
        
        try{

            conn = ConnectDB.getConnection();
           
            String sql = "select * from answer where question_id_fk=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, questionId);
            ResultSet result = statement.executeQuery();
            
            while(result.next()){
                AnswerModel answer = new AnswerModel(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4));
                answers.add(answer);
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
        
        return answers;
    }
}
