import Game.Game;
import Game.TicTacToeLogic;
import Game.UserInteract;

public class Main {
    public static void main(String[] args) {
        Game launcher = new Game();
        TicTacToeLogic game = launcher.createGame();
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