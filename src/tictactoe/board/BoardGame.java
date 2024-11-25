package tictactoe.board;

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
        if (row < 0 || row >= size || col < 0 || col >= size) {
            return false;
        }
        return true;
    }

    /**
     * Vérifie si une case à la position (row, col)
     * existe dans une matrice de taille donnée.
     *
     * @param row Indice de la ligne.
     *
     * @param col Indice de la colonne.
     *
     * @return false si les indices sont hors des
     * limites de la matrice (0 à size - 1), true sinon.
     */

    public Cell[][] getBoard() {
        return board;
    }

    public abstract boolean isValidMove(int[] move);
    public abstract boolean isOver();
} 