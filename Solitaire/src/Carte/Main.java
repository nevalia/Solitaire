package Carte;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) 
	{
		Jeu jeu = new Jeu();
		jeu.initialiser();
		jeu.listeVisible();
		
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
						
						//Ex: Si on trouve une carte visible de valeur 8 dans une colonne A,
						//et une carte de valeur 7 dans une colonne B, on d�place le 7 vers la colonne A
						/*if(indexDerniereCarteVisible == (indexCarteVisible + 1))
						{
							//Supprimer la carte de la premi�re colonne 
							colonne.getListeCartes().remove(carteVisible);
							//Rendre visible une carte cach�e de la colonne
							ArrayList<Carte> cartesCachees = colonne.getCartesCachees();
							if(! cartesCachees.isEmpty())
							{
								Carte derniereCarteCachee = cartesCachees.get(cartesCachees.size() - 1);
								derniereCarteCachee.setVisible(true);
								System.out.println("Carte rendue visible : " + derniereCarteCachee.toString() + " dans la colonne : " + colonne.getNumeroOrdre() );
							}
							//ajouter la carte dans une autre colonne
							colonneTmp.getListeCartes().add(carteVisible);
							
							changement = true;
							System.out.println("D�placement de la carte " + carteVisible.toString() + "de la colonne : " + (i+1) + " vers la colonne: " + (m+1));
							
						}
					*/
					}
				}
				
				//On parcourt les cartes visibles de chaque colonne
				/*for(int j = 0; j < cartesVisibles.size(); j++)
				{
					Carte carte = cartesVisibles.get(j);
					int numPile = TypeCarte.getIndexInSymbolesCartes(carte.getSymbole());
					Pile pile = piles.get(numPile);
					
					if (pile.getCartes().isEmpty()) 
					{
						//si la pile du symbole est vide, et que la carte est un As
						//Donc on peut d�placer la carte de la colonne vers la pile
						if(pile.getCartes().size() == 0 && carte.getValeur() == "As")
						{
							//On ajoute la carte � la pile
							pile.getCartes().add(carte);
							//il faut la retirer ensuite de la colonne
							colonne.getCartesVisible().remove(carte);
							//il faut mettre la premi�re carte de la colonne en visible, si elle n'est pas vide
							if(colonne.getCartesVisible().size() > 0)
							{
								colonne.getCartesVisible().get(0).setVisible(true);
							}
							
							changement = true;
							System.out.println("D�placement de la carte : " + carte.toString() + " de la colonne : " + (i+1) + " vers la pile : " + pile.getSymbole());
						}
						
					} else {
						//R�cup�rer le dernier �l�ment de la pile
						Carte derniereCartePile = pile.getCartes().get(pile.getCartes().size()-1);
						
						// Ex: pour une carte de valeur As, cette variable vaut 0, pour un 2, elle vaut 1 et ainsi de suite 
						int indexCarteVisible = TypeCarte.getIndexInValeursCartes(carte.getValeur());
						
						int indexDerniereCartePile = TypeCarte.getIndexInValeursCartes(derniereCartePile.getValeur());
						
						//Ex: Si on trouve une carte visible de valeur 8 de coeur dans une colonne,
						//et que la derni�re carte de la pile coeur est un 7, il faut d�placer le 8 de la colonne vers la pile
						if(indexCarteVisible == (indexDerniereCartePile + 1))
						{
							//On ajoute la carte � la pile
							pile.getCartes().add(carte);
							//il faut la retirer ensuite de la colonne
							colonne.getCartesVisible().remove(carte);
							//il faut mettre la premi�re carte de la colonne en visible, si elle n'est pas vide
							if(colonne.getCartesVisible().size() > 0)
							{
								colonne.getCartesVisible().get(0).setVisible(true);
							}
							
							changement = true;
							System.out.println("D�placement de la carte : " + carte.toString() + " de la colonne : " + (i+1) +" vers la pile : " + pile.getSymbole());
						}
					}
				}
				*/
			}
			//s'il n'y a pas de changement, on pioche une carte
			/*if(changement == false)
			{
				//Cette variable vaut true si on arrive à placer une carte piochée dans une colonne
				boolean cartePlaceeDansColonne = false;
				//Cette variable vaut true si on arrive à placer une carte piochée dans une pile
				boolean cartePlaceeDansPile = false;
			
				int cpt = 0;
				//On continue à piocher des cartes tant qu'on n'arrive pas à les placer dans une pile ou dans une colonne
				while((cartePlaceeDansColonne || cartePlaceeDansPile) == false)
				{
					Carte cartePiochee = jeu.piocher();
					
					cartePlaceeDansColonne = jeu.placerCarteDansColonne(cartePiochee);
					
					//Si on n'arrive pas à placer la carte piochée dans une colonne, on essaye de la placer dans une pile
					if(cartePlaceeDansColonne == false)
					{
						cartePlaceeDansPile = jeu.placerCartePile(cartePiochee);
					}
					
					//Si on n'arrive pas à placer la carte ni dans une pile ni dans une colonne, on la range et on pioche à nouveau
					if((cartePlaceeDansColonne || cartePlaceeDansPile) == false)
					{
						jeu.ranger(cartePiochee);
					}
					cpt++;
					
					// Cette ligne permet de délimiter le jeu et vérifier la validité des actions faites
					if (cpt == 10)return;
				}
			}
			*/

		}
		


		
		System.out.println("\n affichage des piles : \n");
		System.out.println(jeu.afficherPiles());
		

	}
}