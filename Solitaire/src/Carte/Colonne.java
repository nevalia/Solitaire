package Carte;

import java.util.ArrayList;

public class Colonne 
{
	private int numeroOrdre;
	private int nbCartes;
	private ArrayList<Carte> listeCartes;
	
	public Colonne(int numeroOrdre, int nbCartes)
	{
		this.numeroOrdre = numeroOrdre;
		this.nbCartes = nbCartes;
		this.listeCartes = new ArrayList<Carte>();
	}
	public int getNumeroOrdre()
	{
		return numeroOrdre;
	}
	
	public void setNumeroOrdre(int numeroOrdre)
	{
		this.numeroOrdre = numeroOrdre;
	}
	
	public int getNbcartes()
	{
		return nbCartes;
	}
	public void setNbCartes (int nbCartes)
	{
		this.nbCartes = nbCartes;
	}
	
	public ArrayList<Carte> getListeCartes()
	{
		return listeCartes;
	}
	
	public void setListeCartes(ArrayList<Carte> listeCartes)
	{
		this.listeCartes = listeCartes;
	}
}