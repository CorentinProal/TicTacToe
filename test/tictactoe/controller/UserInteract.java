//package tictactoe.controller;
//
//import java.util.Scanner;
//
//public class UserInteract {
//    private static final Scanner scanner = new Scanner(System.in);
//
//    public static int[] getPlayerMove() {
//        int[] move = new int[2];
//        boolean validMove = false;
//        Scanner scanner = new Scanner(System.in);
//
//        while (!validMove) {
//            try {
//                System.out.print("Enter row (0-2): ");
//                move[0] = scanner.nextInt();
//                System.out.print("Enter column (0-2): ");
//                move[1] = scanner.nextInt();
//
//                // Vérifiez si les mouvements sont dans les limites
//                if (move[0] < 0 || move[0] > 2 || move[1] < 0 || move[1] > 2) {
//                    System.out.println("Les coordonnées doivent être entre 0 et 2. Veuillez réessayer.");
//                    continue;
//                }
//
//                validMove = true;
//            } catch (Exception e) {
//                System.out.println("Entrée invalide, veuillez entrer des chiffres (0, 1 ou 2).");
//                scanner.nextLine(); // Clear the invalid input
//            }
//        }
//        return move;
//    }
//
//    public static void closeScanner() {
//        scanner.close();
//    }
//
//    public static String chooseGameMode() {
//        Scanner scanner = new Scanner(System.in);
//        String mode = "";
//        boolean validInput = false;
//
//        while (!validInput) {
//            System.out.println("Choisissez le mode de jeu :");
//            System.out.println("1. Joueur contre Joueur (PVP)");
//            System.out.println("2. Joueur contre IA (PVB)");
//            System.out.println("3. IA contre IA (BVB)");
//
//            try {
//                int choice = scanner.nextInt();
//                switch (choice) {
//                    case 1:
//                        mode = "PVP";
//                        validInput = true;
//                        break;
//                    case 2:
//                        mode = "PVB";
//                        validInput = true;
//                        break;
//                    case 3:
//                        mode = "BVB";
//                        validInput = true;
//                        break;
//                    default:
//                        System.out.println("Choix invalide, veuillez réessayer.");
//                }
//            } catch (Exception e) {
//                System.out.println("Entrée invalide, veuillez entrer un chiffre (1, 2 ou 3).");
//                scanner.nextLine(); // Clear the invalid input
//            }
//        }
//        return mode;
//    }
//}