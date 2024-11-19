public class Cell {
    private String representation = "   ";

    public String getRepresentation() {
        return representation;
    }

    public void setRepresentation(String representation) {
        this.representation = representation;
    }
}

/*
Cette classe représente une cellule du jeu de TicTacToe.
- Elle contient un attribut representation initialisé avec trois espaces "   "
- getRepresentation() permet d'obtenir la représentation actuelle de la cellule
- setRepresentation() permet de modifier la représentation (utilisé quand un joueur capture la cellule)
*/