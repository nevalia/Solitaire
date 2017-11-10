package Carte;


public class Carte 
{
	private String symbole;
	private String valeur;
	public String couleur;
	private boolean visible; 
	
	
	public Carte(String symbole, String valeur, boolean visible) {
		this.symbole = symbole;
		this.valeur = valeur;
		this.visible = visible;
		this.setCouleur();
	}

	public String getSymbole() {
		return symbole;
	}

	public void setSymbole(String symbole)
	{
		this.symbole = symbole;
	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

	public String getCouleur() {
		return couleur;
	}

	
	
}