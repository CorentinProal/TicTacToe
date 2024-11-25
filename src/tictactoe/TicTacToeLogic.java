package tictactoe;

import tictactoe.board.BoardGame;
import tictactoe.board.CellState;
import tictactoe.players.Player;

public class TicTacToeLogic extends BoardGame {
    private Player currentPlayer;
    private final Player player1;
    private final Player player2;

    public TicTacToeLogic(Player player1, Player player2) {
        super(3);
        this.player1 = player1;
        this.player2 = player2;
        currentPlayer = player1;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public void setOwner(int[] move, Player player) {
        CellState newState = player.getRepresentation().equals(" X ") ? CellState.X : CellState.O;
        board[move[0]][move[1]].setState(newState);
    }

    @Override
    public boolean isValidMove(int[] move) {
        return move[0] >= 0 && move[0] < size &&
                move[1] >= 0 && move[1] < size &&
                board[move[0]][move[1]].isEmpty();
    }

    @Override
    public boolean isOver() {

        // Vérif lignes
        for (int i = 0; i < size; i++) {
            if (exist(i, 0) && !board[i][0].isEmpty() &&
                    board[i][0].getState() == board[i][1].getState() &&
                    board[i][0].getState() == board[i][2].getState()) {
                return true;
            }
        }

        // Vérif Colonne
        for (int j = 0; j < size; j++) {
            if (exist(0, j) && !board[0][j].isEmpty() &&
                    board[0][j].getState() == board[1][j].getState() &&
                    board[0][j].getState() == board[2][j].getState()) {
                return true;
            }
        }

        //Vérif Diag
        if (exist(0, 0) && !board[0][0].isEmpty() &&
                board[0][0].getState() == board[1][1].getState() &&
                board[0][0].getState() == board[2][2].getState()) {
            return true; // Pour diagonnale \
        }
        if (exist(0, 2) && !board[0][2].isEmpty() &&
                board[0][2].getState() == board[1][1].getState() &&
                board[0][2].getState() == board[2][0].getState()) {
            return true; // Pour diagonnale /
        }

        // Vérif Match nul
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j].isEmpty()) {
                    return false; // Si il y a encore des cases vides
                }
            }
        }

        return true; // Match nul
    }
}