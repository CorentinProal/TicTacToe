import Game.Game;
import Game.TicTacToeController;
import Game.UserInteract;

public class Main {
    public static void main(String[] args) {
        Game launcher = new Game();
        TicTacToeController game = launcher.createGame();
        game.startGame();
        UserInteract.fermerScanner();
    }
}

/*
Classe principale qui :
- Crée une instance du menu
- Récupère le choix de l'utilisateur
- Crée le type de jeu approprié
- Lance la partie
*/