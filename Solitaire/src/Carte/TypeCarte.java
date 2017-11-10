package Carte;


public class TypeCarte 
{
	private static final String[] symbolesCartes = {"pique","coeur","carreau","trefle"};
	private static final String[] valeursCartes = {"As","2","3","4","5","6","7","8","9","10","V","D","R"};
	
	
	public static String[] getSymbolescartes() {
		return symbolesCartes;
	}

	
	public static String[] getValeurscartes() {
		return valeursCartes;
	}
	public static int getIndexInSymbolesCartes (String symbole)
	{
		for(int i=0; i< 4; i++)
		{
			if(TypeCarte.symbolesCartes[i] == symbole)
			{
				return i;
			}
		}
		return -1;
	}
	public static int getIndexInValeursCartes (String valeur)
	{
		for(int i=0; i<13; i++)
		{
			if(TypeCarte.valeursCartes[i] == valeur)
			{
				return i;
			}
		}
		return -1;
	}
}