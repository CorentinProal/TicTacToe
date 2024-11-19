import java.util.Scanner;

public class Menu {
    private Scanner scanner;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Bienvenue dans le jeu de Morpion !");
        System.out.println("Choisissez votre mode de jeu :");
        System.out.println("1. Humain vs Humain");
        System.out.println("2. Humain vs IA");
        System.out.println("3. IA vs IA");
    }

    public int getChoice() {
        boolean validChoice = false;
        int choice = 0;

        while (!validChoice) {
            try {
                System.out.print("Votre choix (1-3) : ");
                choice = scanner.nextInt();
                
                if (choice >= 1 && choice <= 3) {
                    validChoice = true;
                } else {
                    System.out.println("Choix invalide ! Veuillez choisir entre 1 et 3.");
                }
            } catch (Exception e) {
                System.out.println("Entrée invalide ! Veuillez entrer un nombre.");
                scanner.nextLine();
            }
        }
        
        return choice;
    }

    public void closeScanner() {
        scanner.close();
    }
}

/*
Cette classe gère l'affichage et la saisie du menu principal.

ATTRIBUTS :
- scanner : pour la saisie utilisateur

MÉTHODES :
displayMenu() :
- Affiche les options du menu principal

getChoice() :
- Gère la saisie du choix utilisateur
- Vérifie que le choix est valide
- Retourne le choix validé

closeScanner() :
- Ferme proprement le scanner
*/ 