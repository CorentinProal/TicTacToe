package Game.controllers;

import GameLogic.GomokuLogic;
import Game.players.GomokuArtificialPlayer;
import Game.players.GomokuPlayer;
import Game.players.GomokuHumanPlayer;
import Board.GomokuView;

public class GomokuController {
    private GomokuLogic model;
    private GomokuView view;

    public GomokuController(GomokuPlayer player1, GomokuPlayer player2) {
        this.model = new GomokuLogic(player1, player2);
        this.view = new GomokuView(this);
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

    public static GomokuController createHumanVsHuman() {
        return new GomokuController(
            new GomokuHumanPlayer(" X "),
            new GomokuHumanPlayer(" O ")
        );
    }

    public static GomokuController createHumanVsAI() {
        return new GomokuController(
            new GomokuHumanPlayer(" X "),
            new GomokuArtificialPlayer(" O ")
        );
    }

    public static GomokuController createAIVsAI() {
        return new GomokuController(
            new GomokuArtificialPlayer(" X "),
            new GomokuArtificialPlayer(" O ")
        );
    }
} 