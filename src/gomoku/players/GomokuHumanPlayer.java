package gomoku.players;

import tictactoe.UserInteract;
import tictactoe.TicTacToeLogic;
import gomoku.GomokuLogic;
import gomoku.GomokuPlayer;

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