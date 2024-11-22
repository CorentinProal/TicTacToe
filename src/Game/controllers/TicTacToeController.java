package Game.controllers;

import Game.players.Player;
import Game.players.HumanPlayer;
import Game.players.ArtificialPlayer;
import GameLogic.TicTacToeLogic;
import Board.TicTacToeView;

public class TicTacToeController {
    private TicTacToeLogic model;
    private TicTacToeView view;

    public TicTacToeController(Player player1, Player player2) {
        this.model = new TicTacToeLogic(player1, player2);
        this.view = new TicTacToeView(this);
    }

    public void startGame() {
        view.afficherDebutPartie();
        
        while (!model.isOver()) {
            view.afficherPlateau(model.getBoard());
            view.afficherTourJoueur(model.getCurrentPlayer());
            
            int[] move;
            do {
                view.afficherDemanderLigne();
                view.afficherDemanderColonne();
                move = model.getCurrentPlayer().getMove(model);
                
                if (!model.isValidMove(move)) {
                    view.afficherErreurCoup();
                }
            } while (!model.isValidMove(move));
            
            model.setOwner(move, model.getCurrentPlayer());
            
            if (model.isOver()) {
                view.afficherPlateau(model.getBoard());
                view.afficherVictoire(model.getCurrentPlayer());
                break;
            }
            
            model.switchPlayer();
        }
        view.afficherFinPartie();
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