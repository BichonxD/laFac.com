package laFac;

public abstract class Statut
{
	private NomStatut nomStat;
	
	protected Statut()
	{
		nomStat = NomStatut.Visiteur;
	}
	
	protected Statut(NomStatut statut)
	{
		nomStat = statut;
	}
	
	public String toString()
	{
		return "" + nomStat;
	}
	
}
