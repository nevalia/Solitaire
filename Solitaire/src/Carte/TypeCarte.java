package Carte;


public class TypeCarte 
{
	private static final String[] symbolesCartes = {"pique","coeur","carreau","trefle"};
	private static final int[] valeursCartes = {1,2,3,4,5,6,7,8,9,10,11,12,13};

	
	public static String[] getSymbolescartes() {
		return symbolesCartes;
	}

	public static int[] getValeurscartes() {
		return valeursCartes;
	}
	
	//Cette fonction retourne l'indice d'un symbole dans le tableau symbolesCartes
	public static int getIndexInSymbolesCartes (String symbole) 
	{
		for(int i = 0; i < 4; i++)
		{
			if(TypeCarte.symbolesCartes[i] == symbole)
			{
				return i;
			}
		}
		
		return -1;
	}
	
	//Cette fonction retourne l'indice d'une valeur dans le tableau valeursCartes
		public static int getIndexInValeursCartes (int valeur) 
		{
			for(int i = 0; i < 13; i++)
			{
				if(TypeCarte.valeursCartes[i] == valeur)
				{
					return i;
				}
			}
			
			return -1;
		}
}