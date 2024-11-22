package Board;

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

    public Cell[][] getBoard() {
        return board;
    }

    public abstract boolean isValidMove(int[] move);
    public abstract boolean isOver();
} 