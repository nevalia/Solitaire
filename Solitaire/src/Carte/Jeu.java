package Carte;

import java.util.ArrayList;




public class Jeu 
{
	private final int nbCartes = 52; 
	private ArrayList<Carte> cartesRestantes;
	private ArrayList<Colonne> colonnes;
	private ArrayList<Pile> piles;
	
	
	public Jeu() {
		this.cartesRestantes = new ArrayList<Carte>();
		this.colonnes = new ArrayList<Colonne>();
		this.piles = new ArrayList<Pile>();
	}

	public ArrayList<Carte> getCartesRestantes() {
		return cartesRestantes;
	}

	public void setCartesRestantes(ArrayList<Carte> cartesRestantes) {
		this.cartesRestantes = cartesRestantes;
	}

	public int getNbCartes() {
		return nbCartes;
	}
	
	public ArrayList<Colonne> getColonnes() {
		return colonnes;
	}

	public void setColonnes(ArrayList<Colonne> colonnes) {
		this.colonnes = colonnes;
	}

	public ArrayList<Pile> getPiles() {
		return piles;
	}

	public void setPiles(ArrayList<Pile> piles) {
		this.piles = piles;
	}
	
}
	