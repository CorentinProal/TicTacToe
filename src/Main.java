public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        TicTacToe game = null;
        
        menu.displayMenu();
        int choice = menu.getChoice();
        
        switch (choice) {
            case 1:
                game = TicTacToe.createHumanVsHuman();
                break;
            case 2:
                game = TicTacToe.createHumanVsAI();
                break;
            case 3:
                game = TicTacToe.createAIVsAI();
                break;
        }
        
        game.display();
        menu.closeScanner();
    }
}

/*
Classe principale qui :
- Crée une instance du menu
- Récupère le choix de l'utilisateur
- Crée le type de jeu approprié
- Lance la partie
*/