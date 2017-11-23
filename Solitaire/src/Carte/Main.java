package Carte;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) 
	{

		Jeu jeu = new Jeu();
		jeu.initialiser();
		jeu.listeVisible();
		Menu menu = new Menu(jeu); 
		menu.afficheMenu();
		
		//System.out.println(jeu.afficherCartes());
		//System.out.println("Nombre de cartes : " + jeu.getCartesRestantes().size());
		
		
		ArrayList<Colonne> colonnes = jeu.getColonnes();
	

		//affichage de colonnes

		ArrayList<Pile> piles = jeu.getPiles();
		
		//Utiliser ce bool�en pour savoir quand est-ce qu'il faut piocher (il faut piocher quand il n'y a pas de changement)
		boolean changement = false;
			
		
		while(! jeu.isColonnesEmpty()){
			changement = false;
			jeu.affichePioche();
			for(int i = 0; i < 7; i++)
			{
				System.out.println("colonne n� " + colonnes.get(i).getNumeroOrdre());
				//affichage de chaque carte d'une colonne
				System.out.println(colonnes.get(i).afficherColonne());
				System.out.println("/*****************************/");
			}
			
			jeu.choix();
			//on parcourt les colonnes
			for(int i = 0; i < 7; i++)
			{
				Colonne colonne = colonnes.get(i);
				ArrayList<Carte> cartesVisibles = colonne.getCartesVisible();
				
				//On essaye de d�placer une carte dans une colonne uniquement si la colonne
				// poss�de une seule carte visible. Dans l'autre cas, le d�placement n'est pas
				// int�ressant car il ne nous permettra pas d'afficher une carte cach�e
				if(cartesVisibles.size() == 1)
				{
					
					Carte carteVisible = cartesVisibles.get(0);
					
					//Voir si on d�placer cette carte vers une autre colonne
					// m != i pour ne pas faire de test sur la colonne actuelle de la carte
					for(int m = 0; m < 7 && m != i; m++)
					{
						Colonne colonneTmp = colonnes.get(m);
						int nbCartesVisiblesColonneTmp = colonneTmp.getCartesVisible().size();
						Carte derniereCarteVisible = colonneTmp.getCartesVisible().get(nbCartesVisiblesColonneTmp - 1);
						
						// Ex: pour une carte de valeur As, cette variable vaut 0, pour un 2, elle vaut 1 et ainsi de suite 
						int indexCarteVisible = TypeCarte.getIndexInValeursCartes(carteVisible.getValeur());
						
						int indexDerniereCarteVisible = TypeCarte.getIndexInValeursCartes(derniereCarteVisible.getValeur());
					}
				}
				
			

		}
		


		
		System.out.println("\n affichage des piles : \n");
		System.out.println(jeu.afficherPiles());
		

	}
}
}