package tictactoe.model;

import global.Cell;

public class TicTacToeBoard {
    private final int SIZE = 3;
    private Cell[][] cells;
    private int winnerRange = 3;


    public TicTacToeBoard() {
        cells = new Cell[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    public int getSize() {
        return SIZE;
    }

    public Cell getCell(int newRow, int newCol) {
        return cells[newRow][newCol];
    }

    public int getWinnerRange(){
        return winnerRange;
    }

    public boolean isFull(){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (cells[i][j].isEmpty()){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean exist(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE;
    }

    public Cell[][] getCells() {
        return cells;
    }

}