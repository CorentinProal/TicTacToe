package tictactoe.model;

public abstract class BoardGame {
    protected Cell[][] board;
    protected final int size;

    public BoardGame(int size) {
        this.size = size;
        this.board = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Cell();
            }
        }
    }

    public boolean exist(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }

    public Cell[][] getBoard() {
        return board;
    }

    public abstract boolean isValidMove(int[] move);
    public abstract boolean isOver();
} 