import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {
    private final int SIZE = 3;
    private Cell[][] board;
    private Player player;

    public TicTacToe() {
        board = new Cell[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = new Cell();
            }
        }
        player = new Player();
    }

    public void display() {
        String line = "-------------";
        String bar = "|";
        System.out.println(line);
        for (int a = 0; a < SIZE; a++) {
            for (int b = 0; b < SIZE; b++) {
                System.out.print(bar);
                System.out.print(board[a][b].getRepresentation());
            }
            System.out.println(bar);
            System.out.println(line);
        }
    }

    public int[] getMoveFromPlayer(){
        Scanner scan = new Scanner(System.in);
        int[] move = new int[2];
        boolean niceMove = false;

        while (!niceMove) {
            try {
                System.out.println("Entrez le numéro de ligne (o - 2) : ");
                move[0] = scan.nextInt();

                System.out.println("Entrez le numéro de colonne (o - 2) : ");
                move[1] = scan.nextInt();

                if (move[0] < 0 || move[0] >= SIZE || move[1] < 0 || move [1] >= SIZE){
                    System.out.println("Hors Limite");
                    continue;
                }

                if (!board[move[0]][move[1]].getRepresentation().equals("X")) {
                    System.out.println("Déja utilisée");
                    continue;
                }

                niceMove = true;
            } catch (Exception e) {
                System.out.println("Erreur");
                scan.nextLine();
            }
        }
        return move;
    }

    public void setOwner(int[] move, Player player) {
        int row = move[0];
        int col = move[1];
        board[row][col].setRepresentation(player.getRepresentation());
    }
}
