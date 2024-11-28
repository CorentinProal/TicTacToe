//package tictactoe.model.players;
//
//import tictactoe.model.CellState;
//import tictactoe.model.TicTacToeLogic;
//
//public abstract class Player {
//    private final CellState symbol;
//
//    public Player(String representation) {
//        this.symbol = representation.trim().equals("X") ? CellState.X : CellState.O;
//    }
//
//    public String getRepresentation() {
//        return symbol.getRep();
//    }
//
//    public CellState getSymbol() {
//        return symbol;
//    }
//
//    public abstract int[] getMove(TicTacToeLogic logic);
//}