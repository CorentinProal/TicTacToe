package tictactoe;

import java.util.Scanner;

public class UserInteract {
    private static final Scanner scanner = new Scanner(System.in);

    public static int obtenirChoixMenu() {
        boolean validChoice = false;
        int choice = 0;

        while (!validChoice) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= 3) {
                    validChoice = true;
                } else {
                    System.out.println("Veuillez choisir un nombre entre 1 et 3 !");
                }
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide 1, 2 ou 3  !");
            }
        }
        return choice;
    }

    public static int[] obtenirCoupJoueur() {
        int[] move = new int[2];
        boolean validInput = false;
        while (!validInput) {
            try {

                move[0] = Integer.parseInt(scanner.nextLine());
                move[1] = Integer.parseInt(scanner.nextLine());

                if (move[0] >= 0 && move[0] <= 2 && move[1] >= 0 && move[1] <= 2) {
                    validInput = true;
                } else {
                    System.out.println("Choisissez un chiffre entre 0 et 2 !");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erreur de saisie. Veuillez entrer un nombre entre 0 et 2 !");
            }
        }
        System.out.println("Coup saisi : [" + move[0] + ", " + move[1] + "]");
        return move;
    }

    public static void fermerScanner() {
        scanner.close();
    }
}