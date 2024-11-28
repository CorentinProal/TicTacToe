import gomoku.GomokuUserInteract;
import tictactoe.view.TicTacToeView;
import gomoku.board.GomokuView;
import gomoku.GomokuController;
import tictactoe.controller.TicTacToeController;
import tictactoe.controller.UserInteract;

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
        int choice = GomokuUserInteract.obtenirChoixMenu();
        
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

    public static void play() {
        Game launcher = new Game();
        System.out.println("Choisissez votre jeu :");
        System.out.println("1. TicTacToe");
        System.out.println("2. Gomoku");
        System.out.println("3. Quitter");
        int gameChoice = 0;

        boolean validGameChoice = false;
        while (!validGameChoice) {
            try {
                gameChoice = UserInteract.obtenirChoixMenu();
                validGameChoice = true;
            } catch (Exception e) {
                System.out.println("Veuillez entrer 1, 2 ou 3 ");
            }
        }

        if (gameChoice == 1) {
            TicTacToeController game = launcher.createTicTacToeGame();
            game.startGame();
        } else if (gameChoice == 2) {
            GomokuController game = launcher.createGomokuGame();
            game.startGame();
        } else if (gameChoice == 3) {
            System.out.println("C'est Ciao !");
        }

        UserInteract.fermerScanner();
    }

    public static void main(String[] args) {
        play();
    }

}