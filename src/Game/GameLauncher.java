package Game;

import Game.controllers.GomokuController;
import Game.controllers.TicTacToeController;

public class GameLauncher {
    public static void launch() {
        Game launcher = new Game();
        System.out.println("Choisissez votre jeu :");
        System.out.println("1. TicTacToe");
        System.out.println("2. Gomoku");
        int gameChoice = UserInteract.obtenirChoixMenu();

        if (gameChoice == 1) {
            TicTacToeController game = launcher.createTicTacToeGame();
            game.startGame();
        } else if (gameChoice == 2) {
            GomokuController game = launcher.createGomokuGame();
            game.startGame();
        }

        UserInteract.fermerScanner();
    }
}

/*
Classe qui :
- Gère l'affichage du menu
- Récupère le choix de l'utilisateur
- Crée le type de jeu approprié
- Lance la partie
*/ 