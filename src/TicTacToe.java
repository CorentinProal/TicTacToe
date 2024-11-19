import java.util.Scanner;

public class TicTacToe {
    private TicTacToeLogic logic;

    // Constructeurs pour les différents modes de jeu
    public static TicTacToe createHumanVsHuman() {
        return new TicTacToe(
            new HumanPlayer(" X "),
            new HumanPlayer(" O ")
        );
    }

    public static TicTacToe createHumanVsAI() {
        return new TicTacToe(
            new HumanPlayer(" X "),
            new ArtificialPlayer(" O ")
        );
    }

    public static TicTacToe createAIVsAI() {
        return new TicTacToe(
            new ArtificialPlayer(" X "),
            new ArtificialPlayer(" O ")
        );
    }

    private TicTacToe(Player player1, Player player2) {
        logic = new TicTacToeLogic(player1, player2);
    }

    public void display() {
        System.out.println(" Début de la partie ! ");

        Cell[][] board = logic.getBoard();
        for (int i = 0; i < 3; i++) {
            System.out.println("-------------");
            for (int j = 0; j < 3; j++) {
                System.out.print("|" + board[i][j].getRepresentation());
            }
            System.out.println("|");
        }
        System.out.println("-------------");

        if (!logic.isOver()) {
            System.out.println("\nAu tour du joueur" + logic.getCurrentPlayer().getRepresentation());
            int[] move = getMoveFromPlayer();
            logic.setOwner(move, logic.getCurrentPlayer());
            
            if (logic.isOver()) {
                display();
                System.out.println(" Le joueur " + logic.getCurrentPlayer().getRepresentation() + " a gagné ! ");
                System.out.println(" Fin de partie ! ");
                return;
            }
            
            logic.switchPlayer();
            display();
        }
    }

    public int[] getMoveFromPlayer() {
        return logic.getCurrentPlayer().getMove(logic);
    }
}


/*
Cette classe gère l'interface utilisateur du jeu TicTacToe.

ATTRIBUTS :
- logic : instance de TicTacToeLogic qui gère la logique du jeu

CONSTRUCTEUR :
- Initialise une nouvelle instance de TicTacToeLogic

MÉTHODES :
display() :
- Affiche l'état actuel du plateau
- Dessine l'interface graphique en mode console
- Gère le déroulement de la partie
- Affiche les messages pour les joueurs
- Gère la boucle de jeu jusqu'à la fin de partie
- Affiche le résultat final

getMoveFromPlayer() :
- Gère la saisie utilisateur
- Vérifie la validité des entrées via TicTacToeLogic
- Gère les erreurs de saisie
- Retourne les coordonnées valides
*/