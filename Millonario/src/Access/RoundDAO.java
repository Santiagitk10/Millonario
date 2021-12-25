/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Access;

import Model.RoundModel;
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
public class RoundDAO {
    private Connection conn = null;
    
    
    public ArrayList<RoundModel> getPrizeByRoundId(int round){
        ArrayList<RoundModel> prizes = new ArrayList();
        
        try{

            conn = ConnectDB.getConnection();
           
            String sql = "select * from round where round_id=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, round);
            ResultSet result = statement.executeQuery();
            
            while(result.next()){
                RoundModel prize = new RoundModel(result.getInt(1), result.getInt(2));
                prizes.add(prize);
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
        
        return prizes;
    }
}
