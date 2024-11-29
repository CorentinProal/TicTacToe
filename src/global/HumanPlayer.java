package global;

import tictactoe.UserInteract;
import global.Board;

public class HumanPlayer extends Player {
    public HumanPlayer(String representation) {
        super(representation);
    }


    @Override
    public int[] getMove(Board board) {
        return UserInteract.obtenirCoupJoueur();
    }
} 