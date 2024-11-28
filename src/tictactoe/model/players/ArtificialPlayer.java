package tictactoe.model.players;

import tictactoe.view.TicTacToeView;
import tictactoe.model.TicTacToeLogic;

import java.util.Random;

public class ArtificialPlayer extends Player {
    private final Random random;

    public ArtificialPlayer(String representation) {
        super(representation);
        this.random = new Random();
    }

    @Override
    public int[] getMove(Object logic) {
        return new int[0];
    }

    @Override
    public int[] getMove(TicTacToeLogic logic) {
        TicTacToeView.afficherCoupOrdinateur();
        int[] move = new int[2];
        do {
            move[0] = random.nextInt(3);
            move[1] = random.nextInt(3);
        } while (!logic.isValidMove(move));
        
        return move;
    }
}