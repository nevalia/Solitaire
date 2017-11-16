package Carte;

import java.util.ArrayList;
import java.util.Random;



public class Jeu 
{
	private final int nbCartes = 52; // les 52 cartes qui compose le solitaire 
	private ArrayList<Carte> cartesRestantes;
	private ArrayList<Colonne> colonnes;
	private ArrayList<Pile> piles;
	
	//Constructeur
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
	
	public void initialiser() 
	{
		// les valeurs qui sont dans TypeCarte
		for(int i = 0; i < 13; i++)
		{
			// les symboles qui sont dans TypeCarte
			for(int j = 0; j < 4; j++)
			{
				String symbole = TypeCarte.getSymbolescartes()[j];
				String valeur = TypeCarte.getValeurscartes()[i];
				this.cartesRestantes.add(new Carte(symbole, valeur , false));
			}
		}
		
		// Création des colonnes
		for(int i = 1; i < 8; i++)
		{
			Colonne colonne = new Colonne(i, i);
			ArrayList<Carte> listeCartesAleatoires = this.recupererPlusieursCartes(i);
			colonne.setListeCartes(listeCartesAleatoires);
			this.colonnes.add(colonne);
		}
		
		//Création des piles
		for(int i = 0; i < 4; i++)
		{
			piles.add(new Pile(TypeCarte.getSymbolescartes()[i]));
		}
		
	}
	
	// Cette fonction récupére une carte aléatoire 
	 
	public Carte recupererCarteAleatoire()
	{
		Random random = new Random	();
		// Récupére un nombre aléatoire entre 0 et le nombre de carte restantes
		int nbCartesRestantes = this.cartesRestantes.size();
		int  nombreAleatoire = random.nextInt(nbCartesRestantes - 1) + 1;
		
		Carte carteAleatoire = this.cartesRestantes.get(nombreAleatoire);
		
		//retirer la carte de la liste une fois qu'elle est récupérée
		this.cartesRestantes.remove(nombreAleatoire);
		
		return carteAleatoire;
	}
	
	// Cette fonction récupére plusieurs cartes aléatoires et retourne une liste
	
	public ArrayList<Carte> recupererPlusieursCartes(int nbCartesARecuperer) 
	{
		ArrayList<Carte> cartes = new ArrayList<Carte>();
		
		for(int i = 0; i < nbCartesARecuperer; i++)
		{
			Carte carteAleatoire = this.recupererCarteAleatoire();
			cartes.add(carteAleatoire);
		}
		
		//les premières cartes de chaque colonne sont visible
		cartes.get(0).setVisible(true);
		return cartes;
	}
	
	//affichage des cartes du jeu
	public String afficherCartes() 
	{
		String cartes = "";
		for (int i = 0; i < this.cartesRestantes.size(); i++)
		{
			cartes += this.cartesRestantes.get(i).toString() + "\n";
		}
		return cartes;
	}
	
	public String afficherPiles()
	{
		String piles = "";
		for(int i = 0; i < 4; i++)
		{
			piles += "Pile : " + this.piles.get(i).getSymbole() + "\n";
			piles += this.piles.get(i).afficherCartes()+ "\n";
		}
		return piles;
	}
	
	public boolean isColonnesEmpty()
	{
		for(int i = 0; i < 7; i++)
		{
			if(!this.colonnes.get(i).getCartesVisible().isEmpty())
			{
				return false;
			}
		}
		return true;
	}
	
	
}