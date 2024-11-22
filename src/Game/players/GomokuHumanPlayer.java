package Game.players;

import Game.UserInteract;
import GameLogic.GomokuLogic;
import GameLogic.TicTacToeLogic;

public class GomokuHumanPlayer extends GomokuPlayer {
    public GomokuHumanPlayer(String representation) {
        super(representation);
    }

    @Override
    public int[] getMove(GomokuLogic logic) {
        return UserInteract.obtenirCoupJoueur();
    }

    @Override
    public int[] getMove(TicTacToeLogic logic) {
        return new int[0];
    }
} 