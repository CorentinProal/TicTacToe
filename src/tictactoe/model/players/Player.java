package tictactoe.model.players;

import tictactoe.model.CellState;
import tictactoe.model.TicTacToeLogic;

public abstract class Player<T> {
    private final CellState symbol;

    public Player(String representation) {
        this.symbol = representation.trim().equals("X") ? CellState.X : CellState.O;
    }

    public String getRepresentation() {
        return symbol.getRep();
    }

    public CellState getSymbol() {
        return symbol;
    }

    public abstract int[] getMove(T logic);

    public abstract int[] getMove(TicTacToeLogic logic);
}

/*
Cette classe abstraite représente un joueur du jeu.
- symbol : symbole du joueur (" X " ou " O ")
- getRep() : obtient le symbole du joueur
- getMove() : méthode abstraite pour obtenir le prochain coup
*/