package Game;

import Board.TicTacToeView;
import Player.ArtificialPlayer;
import Player.HumanPlayer;

public class Game {
    public TicTacToeLogic createGame() {
        TicTacToeView.afficherMenuPrincipal();
        int choice = UserInteract.obtenirChoixMenu();
        
        TicTacToeLogic game = null;
        switch (choice) {
            case 1:
                game = new TicTacToeLogic(new HumanPlayer("X"), new HumanPlayer("O"));
                break;
            case 2:
                game = new TicTacToeLogic(new HumanPlayer("X"), new ArtificialPlayer("O"));
                break;
            case 3:
                game = new TicTacToeLogic(new ArtificialPlayer("X"), new ArtificialPlayer("O"));
                break;
        }
        
        return game;
    }
}