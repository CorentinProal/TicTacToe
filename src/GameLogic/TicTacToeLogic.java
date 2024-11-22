package GameLogic;

import Board.BoardGame;
import Board.CellState;
import Game.players.Player;

public class TicTacToeLogic extends BoardGame {
    private Player currentPlayer;
    private Player player1;
    private Player player2;

    public TicTacToeLogic(Player player1, Player player2) {
        super(3);
        this.player1 = player1;
        this.player2 = player2;
        currentPlayer = player1;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public void setOwner(int[] move, Player player) {
        CellState newState = player.getRepresentation().equals(" X ") ? CellState.X : CellState.O;
        board[move[0]][move[1]].setState(newState);
    }

    @Override
    public boolean isValidMove(int[] move) {
        return move[0] >= 0 && move[0] < size && 
               move[1] >= 0 && move[1] < size && 
               board[move[0]][move[1]].isEmpty();
    }

    @Override
    public boolean isOver() {
        // Vérification des lignes
        for (int i = 0; i < size; i++) {
            if (!board[i][0].isEmpty() &&
                board[i][0].getRepresentation().equals(board[i][1].getRepresentation()) &&
                board[i][0].getRepresentation().equals(board[i][2].getRepresentation())) {
                return true;
            }
        }

        // Vérification des colonnes
        for (int j = 0; j < size; j++) {
            if (!board[0][j].isEmpty() &&
                board[0][j].getRepresentation().equals(board[1][j].getRepresentation()) &&
                board[0][j].getRepresentation().equals(board[2][j].getRepresentation())) {
                return true;
            }
        }

        // Vérification des diagonales
        if (!board[0][0].isEmpty() &&
            board[0][0].getRepresentation().equals(board[1][1].getRepresentation()) &&
            board[0][0].getRepresentation().equals(board[2][2].getRepresentation())) {
            return true;
        }

        if (!board[0][2].isEmpty() &&
            board[0][2].getRepresentation().equals(board[1][1].getRepresentation()) &&
            board[0][2].getRepresentation().equals(board[2][0].getRepresentation())) {
            return true;
        }

        // Vérification match nul
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j].isEmpty()) {
                    return false;
                }
            }
        }

        return true;
    }
} 


/*
Cette classe gère toute la logique du jeu TicTacToe.

ATTRIBUTS :
- SIZE : constante définissant la taille du plateau (3x3)
- board : tableau 2D de Board.Cell représentant le plateau de jeu
- currentPlayer : référence vers le joueur actuel
- player1 : joueur avec le symbole " X "
- player2 : joueur avec le symbole " O "

CONSTRUCTEUR :
- Initialise le plateau avec des cellules vides
- Crée les deux joueurs
- Définit le joueur 1 comme joueur initial

MÉTHODES :
getBoard() :
- Retourne le plateau de jeu actuel

getCurrentPlayer() :
- Retourne le joueur actuel

switchPlayer() :
- Change le joueur actuel

setOwner() :
- Place le symbole du joueur sur la case choisie

isValidMove() :
- Vérifie si un coup est valide :
  * Coordonnées dans les limites
  * Case non occupée

isOver() :
- Vérifie si la partie est terminée :
  * Alignement horizontal, vertical ou diagonal
  * Plateau plein
*/