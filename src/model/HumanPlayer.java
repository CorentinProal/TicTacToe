package model;

import view.GlobalInteract;

public class HumanPlayer extends Player {
    public HumanPlayer(String representation) {
        super(representation);
    }


    @Override
    public int[] getMove(Board board) {
        return GlobalInteract.obtenirCoupJoueur(board.getSize());
    }
} 