package Game;

import Player.Player;
import Board.TicTacToeView;

public class TicTacToeController {
    private TicTacToeLogic model;
    private TicTacToeView view;

    public TicTacToeController(Player player1, Player player2) {
        this.model = new TicTacToeLogic(player1, player2);
        this.view = new TicTacToeView(this);
    }

    public void startGame() {
        // Logique de démarrage du jeu
    }
} 