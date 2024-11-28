//package tictactoe.controller;
//
//import tictactoe.model.TicTacToeLogic;
//import tictactoe.model.players.Player;
//import tictactoe.view.TicTacToeView;
//
//public class TicTacToeController {
//    private final TicTacToeLogic model;
//    private final TicTacToeView view;
//
//    public TicTacToeController(Player player1, Player player2) {
//        this.model = new TicTacToeLogic(player1, player2);
//        this.view = new TicTacToeView();
//    }
//
//    public void startGame() {
//        view.displayStartMessage();
//
//        while (!model.isOver()) {
//            view.displayBoard(model.getBoard());
//            view.displayCurrentPlayer(model.getCurrentPlayer());
//
//            int[] move;
//            do {
//                move = model.getCurrentPlayer().getMove(model);
//                if (!model.isValidMove(move)) {
//                    view.displayInvalidMoveMessage();
//                }
//            } while (!model.isValidMove(move));
//
//            model.setOwner(move, model.getCurrentPlayer());
//            model.switchPlayer();
//        }
//
//        Player winner = model.getWinner();
//        if (winner != null) {
//            view.displayEndMessage();
//            System.out.println("Le gagnant est: " + winner.getRepresentation());
//        } else {
//            view.displayEndMessage();
//            System.out.println("Match nul!");
//        }
//    }
//}