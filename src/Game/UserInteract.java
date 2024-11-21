package Game;

import java.util.Scanner;

public class UserInteract {
    private static Scanner scanner = new Scanner(System.in);

    public static int obtenirChoixMenu() {
        boolean validChoice = false;
        int choice = 0;

        while (!validChoice) {
            try {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= 3) {
                    validChoice = true;
                }
            } catch (Exception e) {
                scanner.nextLine();
            }
        }
        return choice;
    }

    public static int[] obtenirCoupJoueur() {
        int[] move = new int[2];
        try {
            move[0] = scanner.nextInt();
            move[1] = scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine();
        }
        return move;
    }

    public static void fermerScanner() {
        scanner.close();
    }
}