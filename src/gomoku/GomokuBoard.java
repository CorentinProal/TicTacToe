package gomoku;

import tictactoe.model.Cell;

public class GomokuBoard {
    private final int SIZE = 15;
    private Cell[][] cells;
    private int winnerRange = 5;


    public GomokuBoard() {
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