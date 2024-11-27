import tictactoe.controller.TicTacToeController;
import tictactoe.model.players.HumanPlayer;
import tictactoe.model.players.ArtificialPlayer;
import tictactoe.controller.UserInteract;

public class Game {
    public static void main(String[] args) {
        String gameMode = UserInteract.chooseGameMode();
        TicTacToeController game;

        switch (gameMode) {
            case "PVP":
                game = new TicTacToeController(
                    new HumanPlayer(" X "),
                    new HumanPlayer(" O ")
                );
                break;
            case "PVB":
                game = new TicTacToeController(
                    new HumanPlayer(" X "),
                    new ArtificialPlayer(" O ")
                );
                break;
            case "BVB":
                game = new TicTacToeController(
                    new ArtificialPlayer(" X "),
                    new ArtificialPlayer(" O ")
                );
                break;
            default:
                throw new IllegalArgumentException("Mode de jeu non reconnu");
        }

        game.startGame();
        UserInteract.closeScanner();
    }
}