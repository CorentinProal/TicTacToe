package Board;

import Game.TicTacToeController;
import Player.Player;

public class TicTacToeView {
    private TicTacToeController controller;

    public TicTacToeView(TicTacToeController controller) {
        this.controller = controller;
    }

    public void displayInitialMessage() {
        System.out.println(" Début de la partie ! ");
    }

    public void displayBoard(Cell[][] board) {
        for (int i = 0; i < 3; i++) {
            System.out.println("-------------");
            for (int j = 0; j < 3; j++) {
                System.out.print("|" + board[i][j].getRepresentation());
            }
            System.out.println("|");
        }
        System.out.println("-------------");
    }

    public void displayCurrentPlayerTurn(Player player) {
        System.out.println("\nAu tour du joueur" + player.getRepresentation());
    }

    public void displayWinner(Player player) {
        System.out.println(" Le joueur " + player.getRepresentation() + " a gagné ! ");
    }

    public void displayGameOver() {
        System.out.println(" Fin de partie ! ");
    }
}


/*
Cette classe gère l'interface utilisateur du jeu TicTacToe.

ATTRIBUTS :
- controller : instance de Game.TicTacToeController qui gère la logique du jeu

CONSTRUCTEUR :
- Initialise une nouvelle instance de Game.TicTacToeController

MÉTHODES :
displayInitialMessage() :
- Affiche le message de début de partie

displayBoard(Board.Cell[][] board) :
- Affiche l'état actuel du plateau

displayCurrentPlayerTurn(Player.Player player) :
- Affiche le message pour le joueur actuel

displayWinner(Player.Player player) :
- Affiche le message pour le joueur gagnant

displayGameOver() :
- Affiche le message pour la fin de partie
*/