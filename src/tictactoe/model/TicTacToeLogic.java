package tictactoe.model;

import tictactoe.model.players.Player;

public class TicTacToeLogic {
    private Player currentPlayer;
    private final Player player1;
    private final Player player2;
    private final TicTacToeBoard ticTacToeBoard;
    private boolean isOver;

    public TicTacToeLogic(Player player1, Player player2) {
        this.ticTacToeBoard = new TicTacToeBoard();
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
        ticTacToeBoard.getCell(move[0], move[1]).setState(player.getSymbol());
    }

    public boolean isValidMove(int[] move) {
        boolean valid = move[0] >= 0 && move[0] < ticTacToeBoard.getSize() &&
                move[1] >= 0 && move[1] < ticTacToeBoard.getSize() &&
                ticTacToeBoard.getCell(move[0], move[1]).isEmpty();
        if (!valid) {
            System.out.println("Débogage : le coup [" + move[0] + ", " + move[1] + "] est invalide.");
        }
        return valid;
    }

    public boolean isDraw(TicTacToeBoard ticTacToeBoard) {
        return ticTacToeBoard.isFull();
    }

    public boolean isOver(int row, int col, CellState state) {
        int winnerRange = ticTacToeBoard.getWinnerRange();

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
            if (newRow < 0 || newRow >= ticTacToeBoard.getSize() || newCol < 0 || newCol >= ticTacToeBoard.getSize() ||
                    !ticTacToeBoard.getCell(newRow, newCol).getState().equals(state)) {
                break;
            }
            count++;
        }

        // Compter les cases dans la direction négative (-dRow, -dCol)
        for (int i = 1; i < winnerRange; i++) {
            int newRow = row - i * dRow;
            int newCol = col - i * dCol;
            if (newRow < 0 || newRow >= ticTacToeBoard.getSize() || newCol < 0 || newCol >= ticTacToeBoard.getSize() ||
                    !ticTacToeBoard.getCell(newRow, newCol).getState().equals(state)) {
                break;
            }
            count++;
        }
        return count >= winnerRange;
    }

    public TicTacToeBoard getBoard() {
        return ticTacToeBoard;
    }

    public boolean isGameOver() {
        return isOver;
    }
}