package Player;

import Game.TicTacToeLogic;
import Game.UserInteract;

public class HumanPlayer extends Player {
    public HumanPlayer(String representation) {
        super(representation);
    }

    @Override
    public int[] getMove(TicTacToeLogic logic) {
        return UserInteract.obtenirCoupJoueur();
    }
} 