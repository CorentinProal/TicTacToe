//public void startGame() {
//    // Afficher le début de la partie
//    view.afficherDebutPartie();
//
//    // Boucle principale du jeu
//    while (!model.isOver()) {
//        // Afficher l'état actuel du plateau et le joueur en cours
//        view.afficherPlateau(model.getBoard());
//        view.afficherTourJoueur(model.getCurrentPlayer());
//
//        int[] move;
//
//        // Boucle pour obtenir un mouvement valide
//        do {
//            // Demander les coordonnées de la ligne et de la colonne
//            view.afficherDemanderLigne();
//            view.afficherDemanderColonne();
//            move = model.getCurrentPlayer().getMove(model);
//
//            // Vérifier si le mouvement est valide
//            if (!model.isValidMove(move)) {
//                view.afficherErreurSaisie(); // Mouvement non valide
//            } else if (!model.isValidMove(move)) { // Vérification supplémentaire (si applicable)
//                view.afficherErreurCoup(); // Case déjà occupée
//            }
//        } while (!model.isValidMove(move));
//
//        // Appliquer le mouvement au modèle
//        model.setOwner(move, model.getCurrentPlayer());
//
//        // Vérifier si la partie est terminée après ce mouvement
//        if (model.isOver()) {
//            view.afficherPlateau(model.getBoard()); // Dernière mise à jour du plateau
//            view.afficherVictoire(model.getCurrentPlayer()); // Annonce du gagnant
//            break; // Sortir de la boucle principale
//        }
//
//        // Passer au joueur suivant
//        model.switchPlayer();
//    }
//
//    // Afficher la fin de la partie
//    view.afficherFinPartie();
//}