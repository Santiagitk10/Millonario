/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author SANTIAGO SIERRA
 */
public class PlayerModel {
    
    private long playerId;
    private String playerName;

    public PlayerModel() {
    }
  

    public PlayerModel(long playerId, String playerName) {
        this.playerId = playerId;
        this.playerName = playerName;
    }

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    
    @Override
    public String toString(){
        String playerId = Long.toString(this.getPlayerId());
        return playerId;
    }
    
}
