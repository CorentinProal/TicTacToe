package gomoku;

import global.Board;
import global.HumanPlayer;
import global.ArtificialPlayer;
import global.Player;

public class GomokuController {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private GomokuLogic model;
    private GomokuView view;
    private Board board;

    public GomokuController() {
        this.board = new Board(15, 5);
        this.model = new GomokuLogic(board);
        this.view = new GomokuView(this);
        currentPlayer = player1;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public void startGame() {
        view.afficherDebutPartie();

        while (!model.isGameOver()) {
            view.afficherPlateau(board);
            view.afficherTourJoueur(currentPlayer);

            int[] move;
            do {
                view.afficherDemanderLigne();
                view.afficherDemanderColonne();
                move = currentPlayer.getMove(board);
                if (!model.isValidMove(move)) {
                    view.afficherErreurSaisie();
                }
            } while (!model.isValidMove(move));

            model.setOwner(move, currentPlayer.getCellState());

            if (model.isOver(move[0], move[1], currentPlayer.getCellState())) {
                view.afficherPlateau(board);
                view.afficherVictoire(currentPlayer);
                model.setGameOver(true);
                break;
            }

            if (model.isDraw()) {
                view.afficherPlateau(model.getBoard().getCells());
//                view.afficherMatchNul();
                break;
            }

            switchPlayer();
        }
        view.afficherFinPartie();
    }

    public void createHumanVsHuman() {
        return new GomokuController(
            player1 = new HumanPlayer(" X "),
            player2 = new HumanPlayer(" O ")
        );
    }

    public void createHumanVsAI() {
        return new GomokuController(
                player1 = new HumanPlayer(" X "),
                player2 = new ArtificialPlayer(" O ")
        );
    }

    public void createAIVsAI() {
        return new GomokuController(
                player1 = new ArtificialPlayer(" X "),
                player2 = new ArtificialPlayer(" O ")
        );
    }
} 