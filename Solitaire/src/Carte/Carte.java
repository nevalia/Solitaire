package Carte;


public class Carte 
{
	private String symbole ;  
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

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	
	@Override
	public String toString() {
		return "Carte [symbole=" + symbole + ", valeur=" + valeur + ", couleur=" + couleur + ", visible=" + visible
				+ "]";
	}
	
	
}