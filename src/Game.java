package global;

import java.util.Scanner;

public class Game {
    public static void play() {
        GlobalController controller = new GlobalController();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choisissez votre jeu :");
        System.out.println("1. TicTacToe");
        System.out.println("2. Gomoku");
        System.out.println("3. Quitter");

        int gameChoice = 0;
        boolean validGameChoice = false;

        while (!validGameChoice) {
            try {
                gameChoice = scanner.nextInt();
                validGameChoice = true;
            } catch (Exception e) {
                System.out.println("Veuillez entrer 1, 2 ou 3 ");
                scanner.next();
            }
        }

        if (gameChoice == 1) {
            controller.startGame(1);
        } else if (gameChoice == 2) {
            controller.startGame(2);
        } else if (gameChoice == 3) {
            System.out.println("C'est Ciao !");
        }

        scanner.close();
    }
}