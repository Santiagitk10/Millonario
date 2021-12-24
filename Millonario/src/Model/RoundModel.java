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
public class RoundModel {
    
    private int roundId;
    private int roundPrize;

    public RoundModel(int roundId, int roundPrize) {
        this.roundId = roundId;
        this.roundPrize = roundPrize;
    }

    public int getRoundId() {
        return roundId;
    }

    public void setRoundId(int roundId) {
        this.roundId = roundId;
    }

    public int getRoundPrize() {
        return roundPrize;
    }

    public void setRoundPrize(int roundPrize) {
        this.roundPrize = roundPrize;
    }
    
    
    
}
