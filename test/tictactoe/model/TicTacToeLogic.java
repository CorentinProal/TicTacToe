//package tictactoe.model;
//import tictactoe.model.players.Player;
//
//public class TicTacToeLogic extends TicTacToeBoard {
//    private Player currentPlayer;
//    private final Player player1;
//    private final Player player2;
//
//    public TicTacToeLogic(Player player1, Player player2) {
//        super(3);
//        this.player1 = player1;
//        this.player2 = player2;
//        currentPlayer = player1;
//    }
//
//    public Player getCurrentPlayer() {
//        return currentPlayer;
//    }
//
//    public void switchPlayer() {
//        currentPlayer = (currentPlayer == player1) ? player2 : player1;
//    }
//
//    public void setOwner(int[] move, Player player) {
//        CellState newState = player.getRepresentation().equals(" X ") ? CellState.X : CellState.O;
//        cells[move[0]][move[1]].setState(newState);
//    }
//
//    @Override
//    public boolean isValidMove(int[] move) {
//        return move[0] >= 0 && move[0] < SIZE &&
//                move[1] >= 0 && move[1] < SIZE &&
//                cells[move[0]][move[1]].isEmpty();
//    }
//
//    @Override
//    public boolean isOver() {
//        // Vérif lignes
//        for (int i = 0; i < SIZE; i++) {
//            if (exist(i, 0) && !cells[i][0].isEmpty() &&
//                    cells[i][0].getState() == cells[i][1].getState() &&
//                    cells[i][0].getState() == cells[i][2].getState()) {
//                return true;
//            }
//        }
//
//        // Vérif Colonne
//        for (int j = 0; j < SIZE; j++) {
//            if (exist(0, j) && !cells[0][j].isEmpty() &&
//                    cells[0][j].getState() == cells[1][j].getState() &&
//                    cells[0][j].getState() == cells[2][j].getState()) {
//                return true;
//            }
//        }
//
//        if (exist(0, 0) && !cells[0][0].isEmpty() &&
//                cells[0][0].getState() == cells[1][1].getState() &&
//                cells[0][0].getState() == cells[2][2].getState()) {
//            return true;
//        }
//        if (exist(0, 2) && !cells[0][2].isEmpty() &&
//                cells[0][2].getState() == cells[1][1].getState() &&
//                cells[0][2].getState() == cells[2][0].getState()) {
//            return true;
//        }
//
//        // Vérifiez si le plateau est plein
//        for (int i = 0; i < SIZE; i++) {
//            for (int j = 0; j < SIZE; j++) {
//                if (cells[i][j].isEmpty()) {
//                    return false; // Il y a encore des cases vides
//                }
//            }
//        }
//
//        return true; // Plateau plein, match nul
//    }
//
//    public Player getWinner() {
//        // Vérifiez les lignes, colonnes et diagonales pour un gagnant
//        for (int i = 0; i < SIZE; i++) {
//            if (exist(i, 0) && !cells[i][0].isEmpty() &&
//                    cells[i][0].getState() == cells[i][1].getState() &&
//                    cells[i][0].getState() == cells[i][2].getState()) {
//                return (cells[i][0].getState() == CellState.X) ? player1 : player2;
//            }
//        }
//
//        for (int j = 0; j < SIZE; j++) {
//            if (exist(0, j) && !cells[0][j].isEmpty() &&
//                    cells[0][j].getState() == cells[1][j].getState() &&
//                    cells[0][j].getState() == cells[2][j].getState()) {
//                return (cells[0][j].getState() == CellState.X) ? player1 : player2;
//            }
//        }
//
//        if (exist(0, 0) && !cells[0][0].isEmpty() &&
//                cells[0][0].getState() == cells[1][1].getState() &&
//                cells[0][0].getState() == cells[2][2].getState()) {
//            return (cells[0][0].getState() == CellState.X) ? player1 : player2;
//        }
//        if (exist(0, 2) && !cells[0][2].isEmpty() &&
//                cells[0][2].getState() == cells[1][1].getState() &&
//                cells[0][2].getState() == cells[2][0].getState()) {
//            return (cells[0][2].getState() == CellState.X) ? player1 : player2;
//        }
//
//        return null; // Aucun gagnant
//    }
//}