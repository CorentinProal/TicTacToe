package global;

public class Board {
    private final int SIZE;
    private Cell[][] cells;
    private int winnerRange;


    public Board(int size, int winnerRange) {
        this.SIZE = size ;
        this.winnerRange = winnerRange;
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

    public Cell getCell(int row, int col) {
        return cells[row][col];
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

    public Board getCells() {
        return cells[row][col];
    }

}