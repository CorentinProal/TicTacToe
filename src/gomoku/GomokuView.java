package gomoku;

import global.Board;
import global.Cell;
import global.Player;
import global.GlobalController;

public class GomokuView {
    private GlobalController controller;

    public GomokuView(GlobalController controller) {
        this.controller = controller;
    }

    public static void afficherMenuPrincipal() {
        System.out.println("Go faire un petit Gomoku !");
        System.out.println("Comment tu joues ?");
        System.out.println("1. PvP");
        System.out.println("2. PvB");
        System.out.println("3. BvB");
        System.out.print(" Option  1 - 3  : ");
    }

    public void afficherErreurMenu() {
        System.out.println(" Veuillez choisir entre 0 et 14 ");
    }

    public void afficherDemanderLigne() {
        System.out.print("Ligne (0-14) : ");
        System.out.println("   ");;
    }

    public void afficherDemanderColonne() {
        System.out.print("Colonne (0-14) : ");
    }

    public void afficherErreurCoup() {
        System.out.println("Position invalide ou case déjà occupée !");
    }

    public void afficherDebutPartie() {
        System.out.println(" Début de la partie ! ");
    }

    public void afficherPlateau(Board board) {
        Cell[][] cells = board.getCells();
        int size = cells.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("----");
            }
            System.out.println();
            for (int j = 0; j < size; j++) {
                System.out.print("|" + cells[i][j].getRepresentation());
            }
            System.out.println("|");
        }
        for (int j = 0; j < size; j++) {
            System.out.print("----");
        }
        System.out.println();
    }

    public void afficherTourJoueur(Player player) {
        System.out.println("\nAu tour du joueur" + player.getRepresentation());
    }

    public void afficherErreurSaisie() {
        System.out.println("Veuillez entrer un nombre entre 0 et 14 !");
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

    public static void afficherCoupOrdinateur() {
        System.out.println("L'ordinateur joue...");
    }
} 