package gomoku.players;

import gomoku.GomokuLogic;
import tictactoe.model.players.Player;

public abstract class GomokuPlayer extends Player<GomokuLogic> {
    public GomokuPlayer(String representation) {
        super(representation);
    }

    @Override
    public abstract int[] getMove(GomokuLogic logic);
}

/*
Cette classe abstraite représente un joueur du jeu.
- symbol : symbole du joueur (" X " ou " O ")
- getRep() : obtient le symbole du joueur
- getMove() : méthode abstraite pour obtenir le prochain coup
*/