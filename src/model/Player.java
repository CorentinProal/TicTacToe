package model;

public abstract class Player {
    private String representation;

    public Player(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return representation;
    }

    public CellState getCellState() {
        if (representation.trim().equals("X")) {
            return CellState.X;
        } else if (representation.trim().equals("O")) {
            return CellState.O;
        } else {
            return CellState.EMPTY;
        }
    }

    public abstract int[] getMove(Board board);
}

/*
Cette classe abstraite représente un joueur du jeu.
- symbol : symbole du joueur (" X " ou " O ")
- getRep() : obtient le symbole du joueur
- getMove() : méthode abstraite pour obtenir le prochain coup
*/