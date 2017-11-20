package Carte;

import java.util.ArrayList;

public class Colonne 
{
	private int numeroOrdre;
	private int nbCartes;
	private ArrayList<Carte> listeCartes;
	
	// Constructeur
	public Colonne(int numeroOrdre, int nbCartes) {
		this.numeroOrdre = numeroOrdre;
		this.nbCartes = nbCartes;
		this.listeCartes = new ArrayList<Carte>();
	}
	
	public void incNb() {
		nbCartes++;
	}

	public int getNumeroOrdre() {
		return numeroOrdre;
	}

	public void setNumeroOrdre(int numeroOrdre) {
		this.numeroOrdre = numeroOrdre;
	}
	


	public int getNbCartes() {
		return nbCartes;
	}

	public void setNbCartes(int nbCartes) {
		this.nbCartes = nbCartes;
	}
	
	public void addCarte(Carte a) {
		listeCartes.add(a);
	}

	public ArrayList<Carte> getListeCartes() {
		return listeCartes;
	}

	public void setListeCartes(ArrayList<Carte> listeCartes) {
		this.listeCartes = listeCartes;
	}
	
	
	
	// Cette fonction affiche les cartes d'une colonne
	public String afficherColonne() 
	{
		String colonne = "";
		for (int i = 0; i < this.nbCartes; i++)
		{
			colonne += this.listeCartes.get(i).toString() + "\n";
		}
		return colonne;
	}
	
	// Cette fonction r�cup�re les cartes visibles d'une colonne
	public ArrayList<Carte> getCartesVisible()
	{
		ArrayList<Carte> cartes = new ArrayList<Carte>();
		
		for(int i = 0; i < this.listeCartes.size(); i++)
		{
			if(this.listeCartes.get(i).isVisible())
			{
				cartes.add(this.listeCartes.get(i));
			}
		}
		
		return cartes;
	}
	
	// Cette fonction r�cup�re les cartes cach�es d'une colonne
		public ArrayList<Carte> getCartesCachees()
		{
			ArrayList<Carte> cartes = new ArrayList<Carte>();
			
			for(int i = 0; i < this.listeCartes.size(); i++)
			{
				//si la carte n'est pas visible, on l'ajoute dans la liste
				if(! this.listeCartes.get(i).isVisible())
				{
					cartes.add(this.listeCartes.get(i));
				}
			}
			
			return cartes;
		}
		
		public Carte getLastCarte() {
			return listeCartes.get(0);
		}
	
}