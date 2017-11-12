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

		public String afficherColonne() 
		{
			String colonne = "";
			for (int i = 0; i < this.nbCartes; i++)
			{
				colonne += this.listeCartes.get(i).toString() + "\n";
			}
			return colonne;
		}
		
		
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
		
		
			public ArrayList<Carte> getCartesCachees()
			{
				ArrayList<Carte> cartes = new ArrayList<Carte>();
				
				for(int i = 0; i < this.listeCartes.size(); i++)
				{
					
					if(! this.listeCartes.get(i).isVisible())
					{
						cartes.add(this.listeCartes.get(i));
					}
				}
				
				return cartes;
			}
		
	}
