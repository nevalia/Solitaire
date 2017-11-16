package Carte;

import java.util.ArrayList;

public class Action {
	
	Jeu jeu = new Jeu();
	
	public void bouger() {
		//Utiliser ce booléen pour savoir quand est-ce qu'il faut piocher (il faut piocher quand il n'y a pas de changement)
		boolean chargement = false; 
		ArrayList<Colonne> colonnes = jeu.getColonnes();
		ArrayList<Pile> piles = jeu.getPiles();
	
		
		//affichage de colonnes
		for(int i = 0; i < 7; i++)
		{
			System.out.println("colonne n° " + colonnes.get(i).getNumeroOrdre());
			//affichage de chaque carte d'une colonne
			System.out.println(colonnes.get(i).afficherColonne());
			System.out.println("/*****************************/");
		}

		while(! jeu.isColonnesEmpty()){
			//on parcourt les colonnes
			for(int i = 0; i < 7; i++)
			{
				Colonne colonne = colonnes.get(i);
				ArrayList<Carte> cartesVisibles = colonne.getCartesVisible();
				
				//On essaye de déplacer une carte dans une colonne uniquement si la colonne
				// possède une seule carte visible. Dans l'autre cas, le déplacement n'est pas
				// intéressant car il ne nous permettra pas d'afficher une carte cachée
				if(cartesVisibles.size() == 1)
				{
					Carte carteVisible = cartesVisibles.get(0);
					
					//Voir si on déplacer cette carte vers une autre colonne
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
						//et une carte de valeur 7 dans une colonne B, on déplace le 7 vers la colonne A
						if(indexDerniereCarteVisible == (indexCarteVisible + 1))
						{
							//Supprimer la carte de la première colonne 
							colonne.getListeCartes().remove(carteVisible);
							//Rendre visible une carte cachée de la colonne
							ArrayList<Carte> cartesCachees = colonne.getCartesCachees();
							if(! cartesCachees.isEmpty())
							{
								Carte derniereCarteCachee = cartesCachees.get(cartesCachees.size() - 1);
								derniereCarteCachee.setVisible(true);
							}
							//ajouter la carte dans une autre colonne
							colonneTmp.getListeCartes().add(carteVisible);
							
							chargement = true;
							System.out.println("Déplacement de la carte " + carteVisible.toString() + "de la colonne : " + (i+1) + " vers la colonne: " + (m+1));
							
						}
					}
				}
				
				//On parcourt les cartes visibles de chaque colonne
				for(int j = 0; j < cartesVisibles.size(); j++)
				{
					Carte carte = cartesVisibles.get(j);
					int numPile = TypeCarte.getIndexInSymbolesCartes(carte.getSymbole());
					Pile pile = piles.get(numPile);
					
					if (pile.getCartes().isEmpty()) 
					{
						//si la pile du symbole est vide, et que la carte est un As
						//Donc on peut déplacer la carte de la colonne vers la pile
						if(pile.getCartes().size() == 0 && carte.getValeur() == "As")
						{
							//On ajoute la carte à la pile
							pile.getCartes().add(carte);
							//il faut la retirer ensuite de la colonne
							colonne.getCartesVisible().remove(carte);
							//il faut mettre la première carte de la colonne en visible, si elle n'est pas vide
							if(colonne.getCartesVisible().size() > 0)
							{
								colonne.getCartesVisible().get(0).setVisible(true);
							}
							
							chargement = true;
							System.out.println("Déplacement de la carte : " + carte.toString() + " de la colonne : " + (i+1) + " vers la pile : " + pile.getSymbole());
						}
						
					} else {
						//Récupérer le dernier élément de la pile
						Carte derniereCartePile = pile.getCartes().get(pile.getCartes().size()-1);
						
						// Ex: pour une carte de valeur As, cette variable vaut 0, pour un 2, elle vaut 1 et ainsi de suite 
						int indexCarteVisible = TypeCarte.getIndexInValeursCartes(carte.getValeur());
						
						int indexDerniereCartePile = TypeCarte.getIndexInValeursCartes(derniereCartePile.getValeur());
						
						//Ex: Si on trouve une carte visible de valeur 8 de coeur dans une colonne,
						//et que la dernière carte de la pile coeur est un 7, il faut déplacer le 8 de la colonne vers la pile
						if(indexCarteVisible == (indexDerniereCartePile + 1))
						{
							//On ajoute la carte à la pile
							pile.getCartes().add(carte);
							//il faut la retirer ensuite de la colonne
							colonne.getCartesVisible().remove(carte);
							//il faut mettre la première carte de la colonne en visible, si elle n'est pas vide
							if(colonne.getCartesVisible().size() > 0)
							{
								colonne.getCartesVisible().get(0).setVisible(true);
							}
							
							chargement = true;
							System.out.println("Déplacement de la carte : " + carte.toString() + " de la colonne : " + (i+1) +" vers la pile : " + pile.getSymbole());
						}
					}
				}
				
			}
			//s'il n'y a pas de changement, on quitte la boucle
			if(chargement == false)
			{
				break;
			}
		}
	}
	
	
}
