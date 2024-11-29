//package tictactoe.model;
//
//public abstract class TicTacToeBoard {
//    protected Cell[][] cells;
//    protected final int SIZE;
//
//    public TicTacToeBoard(int SIZE) {
//        this.SIZE = SIZE;
//        this.cells = new Cell[SIZE][SIZE];
//        for (int i = 0; i < SIZE; i++) {
//            for (int j = 0; j < SIZE; j++) {
//                cells[i][j] = new Cell();
//            }
//        }
//    }
//
//    public boolean exist(int row, int col) {
//        return row >= 0 && row < SIZE && col >= 0 && col < SIZE;
//    }
//
//    public Cell[][] getCells() {
//        return cells;
//    }
//
//    public abstract boolean isValidMove(int[] move);
//    public abstract boolean isOver();
//}