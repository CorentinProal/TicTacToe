package Game.players;

import Game.UserInteract;
import GameLogic.TicTacToeLogic;

public class HumanPlayer extends Player {
    public HumanPlayer(String representation) {
        super(representation);
    }

    @Override
    public int[] getMove(Object logic) {
        return new int[0];
    }

    @Override
    public int[] getMove(TicTacToeLogic logic) {
        return UserInteract.obtenirCoupJoueur();
    }
} 