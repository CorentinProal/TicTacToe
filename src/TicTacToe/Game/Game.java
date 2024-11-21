package TicTacToe.Game;

import TicTacToe.Board.TicTacToeView;

public class Game {
    public TicTacToeController createGame() {
        TicTacToeView.afficherMenuPrincipal();
        int choice = UserInteract.obtenirChoixMenu();
        
        TicTacToeController game = null;
        switch (choice) {
            case 1:
                game = TicTacToeController.createHumanVsHuman();
                break;
            case 2:
                game = TicTacToeController.createHumanVsAI();
                break;
            case 3:
                game = TicTacToeController.createAIVsAI();
                break;
        }
        
        return game;
    }
}