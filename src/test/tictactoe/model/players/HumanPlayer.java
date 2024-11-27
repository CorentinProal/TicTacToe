package tictactoe.model.players;

import tictactoe.model.TicTacToeLogic;
import tictactoe.controller.UserInteract;

public class HumanPlayer extends Player {
    public HumanPlayer(String representation) {
        super(representation);
    }

    @Override
    public int[] getMove(TicTacToeLogic logic) {
        return UserInteract.getPlayerMove();
    }
} 