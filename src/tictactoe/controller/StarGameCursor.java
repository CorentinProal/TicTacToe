
//    public void startGame() {
//        boolean debugMode = true; // Activez pour afficher les logs de débogage
//        view.afficherDebutPartie();
//
//        while (!model.isOver()) {
//            if (debugMode) {
//                System.out.println("\n--- Début du tour ---");
//                System.out.println("État actuel du plateau :");
//                view.afficherPlateau(model.getBoard());
//                System.out.println("Joueur actuel : " + model.getCurrentPlayer().getRepresentation());
//            }
//
//            int[] move;
//            do {
//                move = model.getCurrentPlayer().getMove(model);
//
//                if (!model.isValidMove(move)) {
//                    System.out.println("Mouvement invalide généré : " + move[0] + ", " + move[1]);
//                    view.afficherErreurSaisie();
//                } else if (debugMode) {
//                    System.out.println("Mouvement valide généré : " + move[0] + ", " + move[1]);
//                }
//            } while (!model.isValidMove(move));
//
//            model.setOwner(move, model.getCurrentPlayer());
//            if (debugMode) {
//                System.out.println("Plateau mis à jour après le coup :");
//                view.afficherPlateau(model.getBoard());
//            }
//
//            if (model.isOver()) {
//                view.afficherVictoire(model.getCurrentPlayer());
//                if (debugMode) {
//                    System.out.println("Le jeu est terminé !");
//                }
//                break;
//            }
//
//            model.switchPlayer();
//            if (debugMode) {
//                System.out.println("Joueur changé pour : " + model.getCurrentPlayer().getRepresentation());
//            }
//        }
//
//        view.afficherFinPartie();
//    }