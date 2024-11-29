package tictactoe;

import global.Board;
import global.HumanPlayer;
import global.ArtificialPlayer;
import global.Player;

public class TicTacToeController {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private final TicTacToeLogic model;
    private final TicTacToeView view;
    private final Board board;

    public TicTacToeController() {
        this.board = new Board(3, 3);
        this.model = new TicTacToeLogic(board);
        this.view = new TicTacToeView(this);
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
                view.afficherPlateau(board);
//                view.afficherMatchNul();
                break;
            }

            switchPlayer();
        }
        view.afficherFinPartie();
    }

    public void createHumanVsHuman() {
        return new TicTacToeController(
            player1 = new HumanPlayer(" X "),
            player2 = new HumanPlayer(" O ")
        );
    }

    public void createHumanVsAI() {
        return new TicTacToeController(
                player1 = new HumanPlayer(" X "),
                player2 = new ArtificialPlayer(" O ")
        );
    }

    public void createAIVsAI() {
        return new TicTacToeController(
            player1 = new ArtificialPlayer(" X "),
            player2 = new ArtificialPlayer(" O ")
        );
    }
} 