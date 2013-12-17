package laFac;

public abstract class Statut
{
	private NomStatut nomStat;
	
	public Statut()
	{
		nomStat = NomStatut.Visiteur;
	}
	
	public String toString()
	{
		return "" + nomStat;
	}
	
}
