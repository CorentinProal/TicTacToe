package gomoku.players;

import tictactoe.TicTacToeLogic;
import gomoku.GomokuLogic;

import java.util.Random;

public class GomokuArtificialPlayer extends GomokuPlayer {
    private Random random;

    public GomokuArtificialPlayer(String representation) {
        super(representation);
        this.random = new Random();
    }

    @Override
    public int[] getMove(GomokuLogic logic) {
        int[] move = new int[2];
        do {
            move[0] = random.nextInt(15);
            move[1] = random.nextInt(15);
        } while (!logic.isValidMove(move));
        
        return move;
    }

    @Override
    public int[] getMove(TicTacToeLogic logic) {
        return new int[0];
    }
}