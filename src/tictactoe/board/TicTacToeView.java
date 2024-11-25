package tictactoe.board;

import tictactoe.TicTacToeController;
import tictactoe.players.Player;

public class TicTacToeView {
    private TicTacToeController controller;

    public TicTacToeView(TicTacToeController controller) {
        this.controller = controller;
    }

    public static void afficherMenuPrincipal() {
        System.out.println("Go faire un petit Morpion !");
        System.out.println("Comment tu joues ?");
        System.out.println("1. PvP");
        System.out.println("2. PvB");
        System.out.println("3. BvB");
        System.out.print(" Option  1 - 3  : ");
    }

    public void afficherErreurMenu() {
        System.out.println(" Veuillez choisir entre 1 et 3 ");
    }

    public void afficherDemanderLigne() {
        System.out.print("Ligne (0-2) : ");
        System.out.println("   ");
    }

    public void afficherDemanderColonne() {
        System.out.print("Colonne (0-2) : ");
    }

    public void afficherErreurCoup() {
        System.out.println("Position invalide ou case déjà occupée !");
    }

    public void afficherErreurSaisie() {
        System.out.println("Veuillez entrer un nombre !");
    }

    public void afficherDebutPartie() {
        System.out.println(" Début de la partie ! ");
    }

    public void afficherPlateau(Cell[][] board) {
        for (int i = 0; i < 3; i++) {
            System.out.println("-------------");
            for (int j = 0; j < 3; j++) {
                System.out.print("|" + board[i][j].getRepresentation());
            }
            System.out.println("|");
        }
        System.out.println("-------------");
    }

    public void afficherTourJoueur(Player player) {
        System.out.println("\nAu tour du joueur" + player.getRepresentation());
    }

    public void afficherVictoire(Player player) {
        System.out.println(" Le joueur " + player.getRepresentation() + " a gagné ! ");
    }

    public void afficherFinPartie() {
        System.out.println(" Fin de partie ! ");
    }

    public static void afficherCoupOrdinateur() {
        System.out.println("L'ordinateur joue...");
    }
}


/*
Cette classe gère l'interface utilisateur du jeu TicTacToe.

ATTRIBUTS :
- controller : instance de Game.controllers.TicTacToeController qui gère la logique du jeu

CONSTRUCTEUR :
- Initialise une nouvelle instance de Game.controllers.TicTacToeController

MÉTHODES :
afficherMenuPrincipal() :
- Affiche le menu principal du jeu

afficherErreurMenu() :
- Affiche le message d'erreur pour un choix de menu invalide

afficherDemanderLigne() :
- Affiche le message pour demander la ligne d'un coup

afficherDemanderColonne() :
- Affiche le message pour demander la colonne d'un coup

afficherErreurCoup() :
- Affiche le message d'erreur pour un coup invalide

afficherErreurSaisie() :
- Affiche le message d'erreur pour une saisie invalide

afficherDebutPartie() :
- Affiche le message de début de partie

afficherPlateau(Board.Cell[][] tictactoe.board) :
- Affiche l'état actuel du plateau

afficherTourJoueur(Game.players.Player player) :
- Affiche le message pour le joueur actuel

afficherVictoire(Game.players.Player player) :
- Affiche le message pour le joueur gagnant

afficherFinPartie() :
- Affiche le message pour la fin de partie

afficherCoupOrdinateur() :
- Affiche le message pour le coup de l'ordinateur
*/