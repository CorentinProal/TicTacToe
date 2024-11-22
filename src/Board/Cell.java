package Board;

public class Cell {
    private CellState state;

    public Cell() {
        this.state = CellState.EMPTY;
    }

    public String getRepresentation() {
        return state.getRep();
    }

    public void setState(CellState state) {
        this.state = state;
    }

    public boolean isEmpty() {
        return state == CellState.EMPTY;
    }
}

/*
Cette classe représente une cellule du jeu de TicTacToe.
- Elle contient un attribut state initialisé avec l'état EMPTY
- getRep() permet d'obtenir la représentation actuelle de la cellule
- setState() permet de modifier l'état (utilisé quand un joueur capture la cellule)
- isEmpty() permet de vérifier si la cellule est vide
*/