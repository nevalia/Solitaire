package Carte;

import java.util.Scanner;

public class Menu {
	
	private Jeu jeu;
	
	public Menu(Jeu j) {
		jeu = j;
	}
	public void afficheMenu() {
		
		System.out.println();
		System.out.println("1. Piocher");
		System.out.println("2. Déplacement de la carte de la pioche vers une colonne");
		System.out.println("3. Déplacement d'une carte de la pioche vers une pile");
		
		Scanner sc = new Scanner(System.in);
		int menu = sc.nextInt();
		
		switch(menu) {
		
		case 1 : 
				
				jeu.piocher();
				break;
		
		case 2 : 
				jeu.placerCarteDansColonne(null);
				break;
		
		case 3 : 
				jeu.placerCartePile(null); 
				break;
		
				
		default : System.out.println("Veuillez entrer un numero valide "); 
		}
	}
}
