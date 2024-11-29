//package tictactoe.view;
//
//import global.Cell;
//import tictactoe.model.players.Player;
//
//public class TicTacToeView {
//    public void displayStartMessage() {
//        System.out.println("Game Start!");
//    }
//
//    public void displayBoard(Cell[][] cells) {
//        for (int i = 0; i < 3; i++) {
//            System.out.println("-------------");
//            for (int j = 0; j < 3; j++) {
//                System.out.print("|" + cells[i][j].getRepresentation());
//            }
//            System.out.println("|");
//        }
//        System.out.println("-------------");
//    }
//
//    public void displayCurrentPlayer(Player player) {
//        System.out.println("Current player: " + player.getRepresentation());
//    }
//
//    public void displayInvalidMoveMessage() {
//        System.out.println("Invalid move! Try again.");
//    }
//
//    public void displayEndMessage() {
//        System.out.println("Game Over!");
//    }
//}