package view;

import model.Board;
import model.Cell;
import model.Player;

public class TicTacToeView {

//    public static void afficherMenuPrincipal() {
//        System.out.println("Go faire un petit Morpion !");
//        System.out.println("Comment tu joues ?");
//        System.out.println("1. PvP");
//        System.out.println("2. PvB");
//        System.out.println("3. BvB");
//        System.out.print(" Option  1 - 3  : ");
//    }

//    public void afficherDemanderLigne() {
//        System.out.print("Ligne ( 0 - 2 ) : ");
//    }
//
//    public void afficherDemanderColonne() {
//        System.out.print("Colonne ( 0 - 2 ) : ");
//    }
//
//    public void afficherErreurCoup() {
//        System.out.println("Case déjà occupée ou position invalide !");
//    }

    public void afficherErreurSaisie() {
        System.out.println("Veuillez entrer un nombre entre 0 et 2 !");
    }

    public void afficherDebutPartie() {
        System.out.println(" Début de la partie ! ");
    }

    public void afficherPlateau(Board board) {
        Cell[][] cells = board.getCells();
        for (int i = 0; i < 3; i++) {
            System.out.println("-------------");
            for (int j = 0; j < 3; j++) {
                System.out.print("|" + cells[i][j].getRepresentation());
            }
            System.out.println("|");
        }
        System.out.println("-------------");
    }

    public static void afficherTourJoueur(Player player) {
        System.out.println("\nAu tour du joueur" + player.getRepresentation());
    }

    public void afficherVictoire(Player player) {
        System.out.println(" Le joueur " + player.getRepresentation() + " a gagné ! ");
    }

    public void afficherFinPartie() {
        System.out.println(" Fin de partie ! ");
    }

    public void afficherMatchNul() {
        System.out.println("C'est un match nul !");
    }

//    public static void afficherCoupOrdinateur() {
//        System.out.println("L'ordinateur joue...");
//    }
}