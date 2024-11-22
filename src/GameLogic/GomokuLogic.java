package GameLogic;

import Board.BoardGame;
import Board.CellState;
import Game.players.GomokuPlayer;

public class GomokuLogic extends BoardGame {
    private GomokuPlayer currentPlayer;
    private GomokuPlayer player1;
    private GomokuPlayer player2;

    public GomokuLogic(GomokuPlayer player1, GomokuPlayer player2) {
        super(15); // Gomoku se joue sur un plateau 15x15
        this.player1 = player1;
        this.player2 = player2;
        currentPlayer = player1;
    }

    public GomokuPlayer getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public void setOwner(int[] move, GomokuPlayer player) {
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
                    board[i][0].isX() && board[i][1].isX() && board[i][2].isX()) {
                return true; // Pour ligne X
            }
            if (exist(i, 0) && !board[i][0].isEmpty() &&
                    board[i][0].isO() && board[i][1].isO() && board[i][2].isO()) {
                return true; // Pour ligne O
            }
        }

        // Vérif Colonne

        for (int j = 0; j < size; j++) {
            if (exist(0, j) && !board[0][j].isEmpty() &&
                    board[0][j].isX() && board[1][j].isX() && board[2][j].isX()) {
                return true; // Pour colonne X
            }
            if (exist(0, j) && !board[0][j].isEmpty() &&
                    board[0][j].isO() && board[1][j].isO() && board[2][j].isO()) {
                return true; // Pour colonne O
            }
        }

        //Vérif Diag

        // Pour X

        if (exist(0, 0) && !board[0][0].isEmpty() &&
                board[0][0].isX() && board[1][1].isX() && board[2][2].isX()) {
            return true; // Pour diagonnale \ pour le joueur X
        }
        if (exist(0, 2) && !board[0][2].isEmpty() &&
                board[0][2].isX() && board[1][1].isX() && board[2][0].isX()) {
            return true; // Pour diagonnale / pour le joueur X
        }

        // Pour O

        if (exist(0, 0) && !board[0][0].isEmpty() &&
                board[0][0].isO() && board[1][1].isO() && board[2][2].isO()) {
            return true; // Pour diagonnale \ pour le joueur O
        }
        if (exist(0, 2) && !board[0][2].isEmpty() &&
                board[0][2].isO() && board[1][1].isO() && board[2][0].isO()) {
            return true; // Pour diagonnale / pour le joueur O
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
