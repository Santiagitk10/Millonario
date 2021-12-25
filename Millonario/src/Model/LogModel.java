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
public class LogModel {
    
    private int logId;
    private int accumPrize;
    private int finalRoundFk;
    private long playerIdFk;
    private String playerName;

    public LogModel() {
        
    }
    

    public LogModel(int logId, int accumPrize, int finalRoundFk, long playerIdFk) {
        this.logId = logId;
        this.accumPrize = accumPrize;
        this.finalRoundFk = finalRoundFk;
        this.playerIdFk = playerIdFk;
    }
    
    public LogModel(int logId, int accumPrize, int finalRoundFk, String playerName) {
        this.logId = logId;
        this.accumPrize = accumPrize;
        this.finalRoundFk = finalRoundFk;
        this.playerName = playerName;
    }

    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public int getAccumPrize() {
        return accumPrize;
    }

    public void setAccumPrize(int accumPrize) {
        this.accumPrize = accumPrize;
    }

    public int getFinalRoundFk() {
        return finalRoundFk;
    }

    public void setFinalRoundFk(int finalRoundFk) {
        this.finalRoundFk = finalRoundFk;
    }

    public long getPlayerIdFk() {
        return playerIdFk;
    }

    public void setPlayerIdFk(long playerIdFk) {
        this.playerIdFk = playerIdFk;
    }
    
    public Object[] toArray(){
        Object[] data = {logId,accumPrize,finalRoundFk,playerName};
        return data;
    }
    
}
