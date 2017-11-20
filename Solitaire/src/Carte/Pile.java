package Carte;

import java.util.ArrayList;

public class Pile 
{
	private String symbole;
	private ArrayList<Carte> cartes;
	
	//constructeur
	public Pile(String symbole) {
		this.symbole = symbole;
		this.cartes = new ArrayList<Carte>();
	}

	public String getSymbole() {
		return symbole;
	}

	public void setSymbole(String symbole) {
		this.symbole = symbole;
	}

	public ArrayList<Carte> getCartes() {
		return cartes;
	}

	public void setCartes(ArrayList<Carte> cartes) {
		this.cartes = cartes;
	}
	
	//Cette fonction affiche les cartes d'une pile
		public String afficherCartes() 
		{
			String cartes = "";
			for (int i = 0; i < this.cartes.size(); i++)
			{
				cartes += this.cartes.get(i).toString() + "\n";
			}
			return cartes;
		}

}