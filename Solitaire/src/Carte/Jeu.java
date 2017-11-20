package Carte;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Jeu 
{
	private final int nbCartes = 52; // toute partie solitaire est compos�e de 52 cartes : constante
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
	
	public void deplacer(){
		System.out.println("Vers colonne tu veux la mettre");
		Scanner dd = new Scanner(System.in);
		int d = dd.nextInt();
		
		System.out.println("Carte de la pioche : " + cartesRestantes.get(0));
		System.out.println("Carte de la colonne : " + colonnes.get(d).getLastCarte());
		
		if(verifCarte(cartesRestantes.get(0),colonnes.get(d-1).getLastCarte())) {
			colonnes.get(d-1).incNb();
			colonnes.get(d-1).addCarte(cartesRestantes.get(0));
			System.out.println("La carte a bien été ajoutée.");
		}
		else
			System.out.println("La carte ne peut pas être ajoutée");

	}
	public void setPiles(ArrayList<Pile> piles) {
		this.piles = piles;
	}
	
	public void choix() {
		System.out.println("1. Piocher");
		System.out.println("2. Déplacer cartes vers pioche.");	
		
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		
		switch (r) {
		case 1: piocher();
				break;
				
		case 2: deplacer();
				
				break;
				
		}
	}
	
	public void initialiser() 
	{
		// On parcourt les valeurs qui sont dans TypeCarte
		for(int i = 0; i < 13; i++)
		{
			// On parcourt les symboles qui sont dans TypeCarte
			for(int j = 0; j < 4; j++)
			{
				String symbole = TypeCarte.getSymbolescartes()[j];
				int valeur = TypeCarte.getValeurscartes()[i];
				this.cartesRestantes.add(new Carte(symbole, valeur , false));
			}
		}
		
		// Cr�ation des colonnes
		for(int i = 1; i < 8; i++)
		{
			Colonne colonne = new Colonne(i, i);
			ArrayList<Carte> listeCartesAleatoires = this.recupererPlusieursCartes(i);
			colonne.setListeCartes(listeCartesAleatoires);
			this.colonnes.add(colonne);
		}
		
		//Cr�ation de piles
		for(int i = 0; i < 4; i++)
		{
			piles.add(new Pile(TypeCarte.getSymbolescartes()[i]));
		}
		
	}
	
	public void listeVisible() {
		for (int i = 0 ; i < cartesRestantes.size(); i++) {
			cartesRestantes.get(i).setVisible();
		}
	}
	
	/**
	 * Cette fonction r�cup�re une carte al�atoire 
	 * @return Carte
	 */
	public Carte recupererCarteAleatoire()
	{
		Random random = new Random	();
		// R�cup�rer un nombre al�atoire entre 0 et le nombre de carte restantes
		int nbCartesRestantes = this.cartesRestantes.size();
		int  nombreAleatoire = random.nextInt(nbCartesRestantes - 1) + 1;
		
		Carte carteAleatoire = this.cartesRestantes.get(nombreAleatoire);
		
		//Une fois la carte est r�cup�r�e, on la retire de la liste
		this.cartesRestantes.remove(nombreAleatoire);
		
	
		return carteAleatoire;
	}
	
	/**
	 * Cette fonction r�cup�re plusieurs cartes al�atoires et retourne une liste
	 * @param nbCartesARecuperer
	 * @return cartes
	 */
	public ArrayList<Carte> recupererPlusieursCartes(int nbCartesARecuperer) 
	{
		ArrayList<Carte> cartes = new ArrayList<Carte>();
		
		for(int i = 0; i < nbCartesARecuperer; i++)
		{
			Carte carteAleatoire = this.recupererCarteAleatoire();
			cartes.add(carteAleatoire);
		}
		
		//on rend visible la premi�re carte de chaque colonne
		cartes.get(0).setVisible();
		return cartes;
	}
	
	//Cette fonction affiche les cartes d'un jeu
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
	
	//piocher la première carte de la liste restante
	
	public void affichePioche() {
		System.out.println("Pioche : " + cartesRestantes.get(0));
	}
	
	public Carte piocher()
	{
		Carte cartePiochee = this.cartesRestantes.get(0);
		this.cartesRestantes.remove(0);
		
		//System.out.println("Carte piochée :" + cartePiochee.toString());
		return cartePiochee;
	}
	
	
	public boolean verifCarte(Carte choix, Carte destination) {
		if(verifNum(choix,destination) && verifSymbole(choix,destination)) {
			return true;
		}
		else
			return false;
	}
	
	public boolean verifNum(Carte choix, Carte destination) {
		return choix.getValeur() - destination.getValeur() == -1;
	}
	
	public boolean verifSymbole(Carte choix, Carte destination) {
		if(choix.getSymbole() == "pique" || choix.getSymbole() == "trefle") {
			return destination.getSymbole() == "carreau" || destination.getSymbole() == "coeur";
		}
		else
			return destination.getSymbole() == "pique" || destination.getSymbole() == "trefle";
	}
	
	//Cette fonction permet de ranger une carte piochée si on n'arrive pas la placer dans une colonne ou dans une pile
	public void ranger(Carte carte)
	{
		System.out.println("Carte rangée :" + carte.toString());
		this.cartesRestantes.add(carte);
	}
	
	//Cette fonction permet de placer une carte piochée dans une colonne, si cela est possible
	public boolean placerCarteDansColonne(Carte carte)
	{
		// On parcourt l'ensemble des colonnes
		for(int i = 0; i < 7; i++)
		{
			Colonne colonne = this.colonnes.get(i);
			//On récupère les cartes visibles de chaque colonne et on vérifie si on peut placer la carte passée en paramètre
			ArrayList<Carte> cartesVisibles = colonne.getCartesVisible();
			
			//Si la colonne n'a pas de cartes visibles (elle est vide), donc on peut placer la carte en paramètre 
			if(cartesVisibles.size() == 0)
			{
				carte.setVisible();
				this.colonnes.get(i).getListeCartes().add(carte);
				
				System.out.println("Déplacement de la carte piochée:" + carte.toString() + "vers la colonne :" + colonne.getNumeroOrdre());
				return true;
			}
			else
			{
				//Récupérer la dernière carte visible de la colonne
				Carte derniereCarteVisible = cartesVisibles.get(cartesVisibles.size()-1);
				
				// Ex: pour une carte de valeur As, cette variable vaut 0, pour un 2, elle vaut 1 et ainsi de suite
				int indiceDerniereCarteVisible = TypeCarte.getIndexInValeursCartes(derniereCarteVisible.getValeur());
				int indiceCarteAPlacer = TypeCarte.getIndexInValeursCartes(carte.getValeur());
				
				if( (indiceCarteAPlacer + 1) == indiceDerniereCarteVisible)
				{
					carte.setVisible();
					this.colonnes.get(i).getListeCartes().add(carte);
					System.out.println("carte d'avant : " + derniereCarteVisible.toString());
					System.out.println("Déplacement de la carte piochée :" + carte.toString() + "vers la colonne :" + colonne.getNumeroOrdre());
					return true;
				}
			}
		}
		
		//Si on n'arrive pas à placer la carte dans une colonne, alors on retourne false
		return false;
		
	}
	
	public boolean placerCartePile(Carte carte)
	{
		int numPile = TypeCarte.getIndexInSymbolesCartes(carte.getSymbole());
		Pile pile = this.piles.get(numPile);
		
		//si la pile du symbole est vide, et que la carte est un As
		//Donc on peut déplacer la carte de la colonne vers la pile
		if(pile.getCartes().size() == 0 && carte.getValeur() == 1)
		{
			//On ajoute la carte à la pile
			pile.getCartes().add(carte);
			System.out.println("Déplacement de la carte piochée :" + carte.toString() + "vers la pile :" + pile.getSymbole());
			
			return true;
		}
		else if (pile.getCartes().size() != 0 )
		{
			//Récupérer la dernière carte de la pile
			Carte derniereCartePile = pile.getCartes().get(pile.getCartes().size()-1);
			
			// Ex: pour une carte de valeur As, cette variable vaut 0, pour un 2, elle vaut 1 et ainsi de suite 
			int indiceCarteVisible = TypeCarte.getIndexInValeursCartes(carte.getValeur());
			
			int indiceDerniereCartePile = TypeCarte.getIndexInValeursCartes(derniereCartePile.getValeur());
			
			if(indiceCarteVisible == (indiceDerniereCartePile + 1))
			{
				//On ajoute la carte à la pile
				pile.getCartes().add(carte);
				System.out.println("Déplacement de la carte piochée:" + carte.toString() + "vers la pile :" + pile.getSymbole());
				
				return true;
			}
		}
			
		//Si on n'arrive pas à placer la carte dans une pile, alors on retourne false
		return false;
			
	}
		

}