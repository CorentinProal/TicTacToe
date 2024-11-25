import tictactoe.UserInteract;
import tictactoe.board.TicTacToeView;
import gomoku.board.GomokuView;
import gomoku.players.GomokuController;
import tictactoe.TicTacToeController;

public class Game {
    public TicTacToeController createTicTacToeGame() {
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

    public GomokuController createGomokuGame() {
        GomokuView.afficherMenuPrincipal();
        int choice = UserInteract.obtenirChoixMenu();
        
        GomokuController game = null;
        switch (choice) {
            case 1:
                game = GomokuController.createHumanVsHuman();
                break;
            case 2:
                game = GomokuController.createHumanVsAI();
                break;
            case 3:
                game = GomokuController.createAIVsAI();
                break;
        }
        
        return game;
    }
}