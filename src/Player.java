public abstract class Player {
    private String representation;

    public Player(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return representation;
    }

    public abstract int[] getMove(TicTacToeLogic logic);
}

/*
Cette classe abstraite représente un joueur du jeu.
- representation : symbole du joueur (" X " ou " O ")
- getRepresentation() : obtient le symbole du joueur
- getMove() : méthode abstraite pour obtenir le prochain coup
*/