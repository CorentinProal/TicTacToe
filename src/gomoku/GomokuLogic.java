package gomoku;

import global.Board;
import gomoku.players.GomokuPlayer;
import global.CellState;
import tictactoe.model.players.Player;

public class GomokuLogic {
    private GomokuPlayer currentPlayer;
    private GomokuPlayer player1;
    private GomokuPlayer player2;
    private final Board board;
    private boolean isOver;

    public GomokuLogic(GomokuPlayer player1, GomokuPlayer player2) {
        this.board = new Board(15,5);
        this.player1 = player1;
        this.player2 = player2;
        currentPlayer = player1;
        isOver = false;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public void setOwner(int[] move, Player player) {
        board.getCell(move[0], move[1]).setState(player.getSymbol());
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

    public boolean isDraw(Board board) {
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

    // Méthode pour vérifier une direction spécifique (horizontal, vertical, diagonale)
    private boolean checkDirection(int row, int col, CellState state, int dRow, int dCol, int winnerRange) {
        int count = 1; // La case actuelle compte déjà pour 1

        // Compter les cases dans la direction positive (dRow, dCol)
        for (int i = 1; i < winnerRange; i++) {
            int newRow = row + i * dRow;
            int newCol = col + i * dCol;
            if (newRow < 0 || newRow >= board.getSize() || newCol < 0 || newCol >= board.getSize() ||
                    !board.getCell(newRow, newCol).getState().equals(state)) {
                break;
            }
            count++;
        }

        // Compter les cases dans la direction négative (-dRow, -dCol)
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
}