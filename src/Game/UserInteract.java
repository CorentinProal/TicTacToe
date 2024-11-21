package Game;

import Board.Cell;
import Player.Player;

import java.util.Scanner;

public class UserInteract {
    private static Scanner scanner = new Scanner(System.in);

    public static void afficherMenuPrincipal() {
        System.out.println("Go faire un petit Morpion !");
        System.out.println("Comment tu joues ?");
        System.out.println("1. PvP");
        System.out.println("2. PvB");
        System.out.println("3. BvB");
    }

    public static int obtenirChoixMenu() {
        boolean validChoice = false;
        int choice = 0;

        while (!validChoice) {
            try {
                System.out.print(" Option  1 - 3  : ");
                choice = scanner.nextInt();
                
                if (choice >= 1 && choice <= 3) {
                    validChoice = true;
                } else {
                    System.out.println(" Veuillez choisir entre 1 et 3 ");
                }
            } catch (Exception e) {
                System.out.println(" Veuillez entrer un nombre ");
                scanner.nextLine();
            }
        }
        return choice;
    }

    public static int[] obtenirCoupJoueur(TicTacToeLogic logic) {
        int[] move = new int[2];
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Ligne (0-2) : ");
                move[0] = scanner.nextInt();
                System.out.print("Colonne (0-2) : ");
                move[1] = scanner.nextInt();

                if (!logic.isValidMove(move)) {
                    System.out.println("Position invalide ou case déjà occupée !");
                    continue;
                }

                validInput = true;
            } catch (Exception e) {
                System.out.println("Veuillez entrer un nombre !");
                scanner.nextLine();
            }
        }
        return move;
    }

    // Messages du jeu
    public static void afficherDebutPartie() {
        System.out.println(" Début de la partie ! ");
    }

    public static void afficherPlateau(Cell[][] board) {
        for (int i = 0; i < 3; i++) {
            System.out.println("-------------");
            for (int j = 0; j < 3; j++) {
                System.out.print("|" + board[i][j].getRepresentation());
            }
            System.out.println("|");
        }
        System.out.println("-------------");
    }

    public static void afficherTourJoueur(Player player) {
        System.out.println("\nAu tour du joueur" + player.getRepresentation());
    }

    public static void afficherVictoire(Player player) {
        System.out.println(" Le joueur " + player.getRepresentation() + " a gagné ! ");
    }

    public static void afficherFinPartie() {
        System.out.println(" Fin de partie ! ");
    }

    public static void afficherCoupOrdinateur() {
        System.out.println("L'ordinateur joue...");
    }

    // Gestion des ressources
    public static void fermerScanner() {
        scanner.close();
    }
}