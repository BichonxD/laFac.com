package laFac;

public class Adherent extends Statut
{
	private int nbPtsFidelite;
	
	public Adherent()
	{
		nbPtsFidelite = 0;
	}
	
	public String toString()
	{
		return super.toString() + "\nNombre de Points de Fidelite : " + nbPtsFidelite;
	}
	
}
