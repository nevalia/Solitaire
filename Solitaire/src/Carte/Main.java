package Carte;

import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jeu jeu = new Jeu();
		jeu.initialiser();
		Action a = new Action();
		a.bouger();
		//System.out.println(jeu.afficherCartes());
		//System.out.println("Nombre de cartes : " + jeu.getCartesRestantes().size());
		System.out.println("\naffichage des piles : \n");
		System.out.println(jeu.afficherPiles());

	}

}