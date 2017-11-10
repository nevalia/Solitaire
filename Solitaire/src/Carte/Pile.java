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

}