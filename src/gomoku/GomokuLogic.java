package gomoku;

import gomoku.players.GomokuPlayer;
import tictactoe.model.BoardGame;
import tictactoe.model.CellState;

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
        // Vérification des lignes
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= size - 5; j++) {
                if (!board[i][j].isEmpty() &&
                        board[i][j].getState() == board[i][j + 1].getState() &&
                        board[i][j].getState() == board[i][j + 2].getState() &&
                        board[i][j].getState() == board[i][j + 3].getState() &&
                        board[i][j].getState() == board[i][j + 4].getState()) {
                    return true;
                }
            }
        }


        for (int j = 0; j < size; j++) {
            for (int i = 0; i <= size - 5; i++) {
                if (!board[i][j].isEmpty() &&
                        board[i][j].getState() == board[i + 1][j].getState() &&
                        board[i][j].getState() == board[i + 2][j].getState() &&
                        board[i][j].getState() == board[i + 3][j].getState() &&
                        board[i][j].getState() == board[i + 4][j].getState()) {
                    return true;
                }
            }
        }

        // Vérification des diagonales principales (\)
        for (int i = 0; i <= size - 5; i++) {
            for (int j = 0; j <= size - 5; j++) {
                if (!board[i][j].isEmpty() &&
                        board[i][j].getState() == board[i + 1][j + 1].getState() &&
                        board[i][j].getState() == board[i + 2][j + 2].getState() &&
                        board[i][j].getState() == board[i + 3][j + 3].getState() &&
                        board[i][j].getState() == board[i + 4][j + 4].getState()) {
                    return true;
                }
            }
        }

        // Vérification des diagonales secondaires (/)
        for (int i = 0; i <= size - 5; i++) {
            for (int j = 4; j < size; j++) {
                if (!board[i][j].isEmpty() &&
                        board[i][j].getState() == board[i + 1][j - 1].getState() &&
                        board[i][j].getState() == board[i + 2][j - 2].getState() &&
                        board[i][j].getState() == board[i + 3][j - 3].getState() &&
                        board[i][j].getState() == board[i + 4][j - 4].getState()) {
                    return true;
                }
            }
        }

        // Vérification d'un match nul
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j].isEmpty()) {
                    return false;
                }
            }
        }

        return true;
    }

}
