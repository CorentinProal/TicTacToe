package TicTacToe.Player;

import TicTacToe.Board.CellState;
import TicTacToe.Game.TicTacToeLogic;

public abstract class Player {
    private CellState symbol;

    public Player(String representation) {
        this.symbol = representation.equals(" X ") ? CellState.X : CellState.O;
    }

    public String getRepresentation() {
        return symbol.getRep();
    }

    public abstract int[] getMove(TicTacToeLogic logic);
}

/*
Cette classe abstraite représente un joueur du jeu.
- symbol : symbole du joueur (" X " ou " O ")
- getRep() : obtient le symbole du joueur
- getMove() : méthode abstraite pour obtenir le prochain coup
*/