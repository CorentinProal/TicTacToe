package Game;

import Player.Player;
import Player.HumanPlayer;
import Player.ArtificialPlayer;
import Game.TicTacToeLogic;
import Game.UserInteract;
public class TicTacToeController {
    private TicTacToeLogic model;

    public TicTacToeController(Player player1, Player player2) {
        this.model = new TicTacToeLogic(player1, player2);
    }

    public void startGame() {
        UserInteract.afficherDebutPartie();
        
        while (!model.isOver()) {
            UserInteract.afficherPlateau(model.getBoard());
            UserInteract.afficherTourJoueur(model.getCurrentPlayer());
            
            int[] move = model.getCurrentPlayer().getMove(model);
            model.setOwner(move, model.getCurrentPlayer());
            
            if (model.isOver()) {
                UserInteract.afficherPlateau(model.getBoard());
                UserInteract.afficherVictoire(model.getCurrentPlayer());
                break;
            }
            
            model.switchPlayer();
        }
        UserInteract.afficherFinPartie();
    }

    public TicTacToeLogic getModel() {
        return model;
    }

    public static TicTacToeController createHumanVsHuman() {
        return new TicTacToeController(
            new HumanPlayer(" X "),
            new HumanPlayer(" O ")
        );
    }

    public static TicTacToeController createHumanVsAI() {
        return new TicTacToeController(
            new HumanPlayer(" X "),
            new ArtificialPlayer(" O ")
        );
    }

    public static TicTacToeController createAIVsAI() {
        return new TicTacToeController(
            new ArtificialPlayer(" X "),
            new ArtificialPlayer(" O ")
        );
    }
} 