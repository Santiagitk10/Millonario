/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Access;

import Model.PlayerModel;
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
public class PlayerDAO {
    private Connection conn = null;
    
    
    public int insertPlayer(PlayerModel player) {
        
        int rowsInserted = 0;
        
        try{

            conn = ConnectDB.getConnection();

            
            String sql = "insert into player(player_id, player_name) values (?,?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1,player.getPlayerId());
            statement.setString(2,player.getPlayerName());
            
            
            rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0){
                JOptionPane.showMessageDialog(null,"El registro del jugador fue agregado exitosamente");
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
        
        return rowsInserted;
    }
    
    
    public ArrayList<PlayerModel> getAllPlayers(){
        ArrayList<PlayerModel> players = new ArrayList();
        
        try{

            conn = ConnectDB.getConnection();
           
            String sql = "SELECT * FROM player ORDER BY player_id;";
                            
                           
                            
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            while(result.next()){
                PlayerModel player = new PlayerModel(result.getInt(1), result.getString(2));
                players.add(player);
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
        
        return players;
    }
    
   
}
