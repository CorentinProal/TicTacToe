//package demo;
//
//import tictactoe.model.TicTacToeBoard;
//
//public class Player implements Mover{
//
//    private PosStrategies strategy;
//
//    Player(PosStrategies posStrategies) {
//        this.strategy = posStrategies;
//    }
//
//    @Override
//    public Position getMove(TicTacToeBoard cells) {
//        if(cells != null){
//            int row = this.strategy.getPosition(cells.getSIZE());
//            int col = this.strategy.getPosition(cells.getSIZE());
//            return new Position(row, col);
//        } else {
//            return new Position(-1, -1);
//        }
//    }
//
//    public void changeStrategy(PosStrategies posStrategies) {
//        this.strategy = posStrategies;
//    }
//
//    public PosStrategies getStrategy() {
//        return this.strategy;
//    }
//}
