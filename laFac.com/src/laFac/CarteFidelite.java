package laFac;

public class CarteFidelite
{
	private int nbPtsFidelite;
	
	public CarteFidelite()
	{
		nbPtsFidelite = 0;
	}
	
	public CarteFidelite(int nbPts)
	{
		nbPtsFidelite = nbPts;
	}
	
	public String toString()
	{
		return ("Nombre de Points de Fidelite : " + nbPtsFidelite);
	}
}
