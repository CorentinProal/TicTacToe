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
        return false;
    }
} 