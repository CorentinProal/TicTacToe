package Player;

import Board.CellState;
import Game.TicTacToeLogic;

public abstract class Player {
    private CellState symbol;

    public Player(String representation) {
        this.symbol = representation.trim().equals("X") ? CellState.X : CellState.O;
    }

    public String getRepresentation() {
        return symbol.getRep();
    }

    public CellState getSymbol() {
        return symbol;
    }

    public abstract int[] getMove(TicTacToeLogic logic);
}

/*
Cette classe abstraite représente un joueur du jeu.
- symbol : symbole du joueur (" X " ou " O ")
- getRep() : obtient le symbole du joueur
- getMove() : méthode abstraite pour obtenir le prochain coup
*/