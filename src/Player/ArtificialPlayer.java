package Player;

import Board.TicTacToeView;
import Game.TicTacToeLogic;

import java.util.Random;

public class ArtificialPlayer extends Player {
    private Random random;

    public ArtificialPlayer(String representation) {
        super(representation);
        this.random = new Random();
    }

    @Override
    public int[] getMove(TicTacToeLogic logic) {
        TicTacToeView.afficherCoupOrdinateur();
        int[] move = new int[2];
        do {
            move[0] = random.nextInt(3);
            move[1] = random.nextInt(3);
        } while (!logic.isValidMove(move));
        
        return move;
    }
}

/*
Cette classe représente un joueur artificiel qui joue des coups aléatoires.

ATTRIBUTS :
- random : générateur de nombres aléatoires
- logic : référence vers la logique du jeu pour vérifier les coups valides

CONSTRUCTEUR :
- Initialise le générateur aléatoire
- Stocke la référence vers la logique du jeu

MÉTHODES :
getMove() :
- Génère des coordonnées aléatoires
- Vérifie si le coup est valide
- Continue jusqu'à trouver une case libre
- Retourne les coordonnées du coup choisi
*/ 