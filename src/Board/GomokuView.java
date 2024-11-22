package Board;

import Game.controllers.GomokuController;
import Game.players.Player;

public class GomokuView {
    private GomokuController controller;

    public GomokuView(GomokuController controller) {
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
        System.out.println(" Veuillez choisir entre 1 et 3 ");
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

    public void afficherPlateau(Cell[][] board) {
//        String separator = "-".repeat(cols * 4 + 1);
        for (int i = 0; i < 15; i++) {
            System.out.println("-------------------------------------------------------------");
            for (int j = 0; j < 15; j++) {
                System.out.print("|" + board[i][j].getRepresentation());
            }
            System.out.println("|");
        }
        System.out.println("-------------------------------------------------------------");
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