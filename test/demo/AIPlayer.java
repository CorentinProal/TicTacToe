//package demo;
//
//import tictactoe.model.TicTacToeBoard;
//
//public class AIPlayer extends Player {
//
//    AIPlayer() {
//        super(PosStrategies.AI);
//    }
//
//    @Override
//    public Position getMove(TicTacToeBoard cells) {
//        Position pos = super.getMove(cells);
//        while(testPos(cells, pos)<50){
//            pos = super.getMove(cells);
//        }
//        return pos;
//    }
//
//    private int testPos(TicTacToeBoard cells, Position pos) {
//        int score = 60;
//        return score;// à calculer
//    }
//
//}
