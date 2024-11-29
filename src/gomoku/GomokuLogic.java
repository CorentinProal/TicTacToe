package gomoku;

import global.Board;
import global.CellState;

public class GomokuLogic {
    private final Board board;
    private boolean isOver;

    public GomokuLogic(Board board) {
        this.board = board;
        isOver = false;
    }

    public void setOwner(int[] move, CellState symbol) {
        board.getCell(move[0], move[1]).setState(symbol);
    }

    public boolean isValidMove(int[] move) {
        boolean valid = move[0] >= 0 && move[0] < board.getSize() &&
                move[1] >= 0 && move[1] < board.getSize() &&
                board.getCell(move[0], move[1]).isEmpty();
        if (!valid) {
            System.out.println("Débogage : le coup [" + move[0] + ", " + move[1] + "] est invalide.");
        }
        return valid;
    }

    public boolean isDraw() {
        return board.isFull();
    }

    public boolean isOver(int row, int col, CellState state) {
        int winnerRange = board.getWinnerRange();

        // Vérifier la ligne
        if (checkDirection(row, col, state, 0, 1, winnerRange)) return true; // Horizontal
        // Vérifier la colonne
        if (checkDirection(row, col, state, 1, 0, winnerRange)) return true; // Vertical
        // Vérifier diagonale principale
        if (checkDirection(row, col, state, 1, 1, winnerRange)) return true; // Diagonale principale
        // Vérifier diagonale secondaire
        if (checkDirection(row, col, state, 1, -1, winnerRange)) return true; // Diagonale secondaire

        return false;
    }

    private boolean checkDirection(int row, int col, CellState state, int dRow, int dCol, int winnerRange) {
        int count = 1;
        for (int i = 1; i < winnerRange; i++) {
            int newRow = row + i * dRow;
            int newCol = col + i * dCol;
            if (newRow < 0 || newRow >= board.getSize() || newCol < 0 || newCol >= board.getSize() ||
                    !board.getCell(newRow, newCol).getState().equals(state)) {
                break;
            }
            count++;
        }
        for (int i = 1; i < winnerRange; i++) {
            int newRow = row - i * dRow;
            int newCol = col - i * dCol;
            if (newRow < 0 || newRow >= board.getSize() || newCol < 0 || newCol >= board.getSize() ||
                    !board.getCell(newRow, newCol).getState().equals(state)) {
                break;
            }
            count++;
        }
        return count >= winnerRange;
    }

    public Board getBoard() {
        return board;
    }

    public boolean isGameOver() {
        return isOver;
    }

    public void setGameOver(boolean isOver) {
        this.isOver = isOver;
    }
}