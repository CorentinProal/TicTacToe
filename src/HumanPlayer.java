import java.util.Scanner;

public class HumanPlayer extends Player {
    private Scanner scanner;

    public HumanPlayer(String representation) {
        super(representation);
        scanner = new Scanner(System.in);
    }

    @Override
    public int[] getMove(TicTacToeLogic logic) {
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
} 