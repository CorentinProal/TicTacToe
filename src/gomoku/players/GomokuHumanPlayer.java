package gomoku.players;

import gomoku.GomokuUserInteract;
import tictactoe.TicTacToeLogic;
import gomoku.GomokuLogic;

public class GomokuHumanPlayer extends GomokuPlayer {
    public GomokuHumanPlayer(String representation) {
        super(representation);
    }

    @Override
    public int[] getMove(GomokuLogic logic) {
        return GomokuUserInteract.obtenirCoupJoueur();
    }

    @Override
    public int[] getMove(TicTacToeLogic logic) {
        return new int[0];
    }
} 