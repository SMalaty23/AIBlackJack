package players;

import game.HandRanks;
import game.Player;

public class SamersPlayer extends Player {
    public SamersPlayer(String name) {
        super(name);
    }
    @Override
    protected void takePlayerTurn() {
        if(getGameState().isActiveBet()) {
            if(getGameState().getNumRoundStage() == 0) {
                //i know there is a bet pre flop
            }
        }

    }

    @Override
    protected boolean shouldFold() {
        if(getGameState().getTableBet() > getBank() * 0.3 && evaluatePlayerHand().getValue() == HandRanks.HIGH_CARD.getValue()) {
            if(getGameState().getNumRoundStage() == 3 && getGameState().getTableBet() > getBank()* 0.3)
            return true;
        }
        return false;
    }


    @Override
    protected boolean shouldCheck() {
        if(!getGameState().isActiveBet() && evaluatePlayerHand().getValue() >= HandRanks.HIGH_CARD.getValue()) {
            return true;
        }
        return false;
    }

    @Override
    protected boolean shouldCall() {
        return false;
    }

    @Override
    protected boolean shouldRaise() {
        boolean hasDecentHand = evaluatePlayerHand().getValue() >= HandRanks.TWO_PAIR.getValue();
        return false;
    }

    @Override
    protected boolean shouldAllIn() {
        return evaluatePlayerHand().getValue() >= HandRanks.FULL_HOUSE.getValue();
    }
}
