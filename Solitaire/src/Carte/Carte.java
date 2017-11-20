package Carte;


public class Carte 
{
	private String symbole;
	private int valeur;
	public String couleur;
	private boolean visible; // pour savoir si la carte est visible ou non dans une colonne 
	
	//constructeur  n
	//On ne passe pas la couleur en param�tre parce qu'on peut la deviner � partir du symbole
	public Carte(String symbole, int valeur, boolean visible) {
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

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur() {
		switch (this.symbole) {
			case "pique":
				this.couleur = "noire";
				break;
			case "trefle":
				this.couleur = "noire";
				break;
			case "coeur":
				this.couleur = "rouge";
				break;
			case "carreau":
				this.couleur = "rouge";
				break;
			default:
				break;
			}
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible() {
		this.visible = true;
	}

	//g�n�r� par eclipse
	@Override
	public String toString() {
		if(visible)
		return "Carte [symbole=" + symbole + ", valeur=" + valeur + ", couleur=" + couleur + ", visible=" + visible
				+ "]";
		else
			return "Carte Cachée";
	}
	
	
}