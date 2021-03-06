/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Access;

import Model.LogModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import utils.ConnectDB;

/**
 *
 * @author SANTIAGO SIERRA
 */
public class LogDAO {
    private Connection conn = null;
    
    
    public void insertLog(LogModel log) {
        
        try{

            conn = ConnectDB.getConnection();

            
            String sql = "insert into log(accum_prize, final_round_fk, player_id_fk) values (?,?,?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, log.getAccumPrize());
            statement.setInt(2, log.getFinalRoundFk());
            statement.setLong(3, log.getPlayerIdFk());
            
            
            
            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0){
                JOptionPane.showMessageDialog(null,"El registro de la partida fue agregado exitosamente");
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
    }
    
    
    public ArrayList<LogModel> getAllLogs(){
        ArrayList<LogModel> logs = new ArrayList();
        
        try{

            conn = ConnectDB.getConnection();
           
            String sql = "SELECT log.log_id, log.accum_prize, log.final_round_fk, player.player_name\n"
                       + "FROM log\n"
                       + "JOIN player ON player.player_id=log.player_id_fk\n"
                       + "ORDER BY log.accum_prize DESC;";
                            
                           
                            
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            while(result.next()){
                LogModel log = new LogModel(result.getInt(1), result.getInt(2),result.getInt(3),result.getString(4));
                logs.add(log);
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
        
        return logs;
    }
}
