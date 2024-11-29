package gomoku;

import gomoku.board.GomokuView;
import gomoku.players.GomokuArtificialPlayer;
import gomoku.players.GomokuHumanPlayer;
import gomoku.players.GomokuPlayer;

public class GomokuController {
    private GomokuLogic model;
    private GomokuView view;

    public GomokuController(GomokuPlayer player1, GomokuPlayer player2) {
        this.model = new GomokuLogic(player1, player2);
        this.view = new GomokuView(this);
    }

    public void startGame() {
        view.afficherDebutPartie();

        while (!model.isGameOver()) {
            view.afficherPlateau(model.getBoard().getCells());
            view.afficherTourJoueur(model.getCurrentPlayer());

            int[] move;
            do {
                view.afficherDemanderLigne();
                view.afficherDemanderColonne();
                move = model.getCurrentPlayer().getMove(model);
                if (!model.isValidMove(move)) {
                    view.afficherErreurSaisie();
                }
            } while (!model.isValidMove(move));

            model.setOwner(move, model.getCurrentPlayer());

            if (model.isOver(move[0], move[1], model.getCurrentPlayer().getCellState())) {
                view.afficherPlateau(model.getBoard().getCells());
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