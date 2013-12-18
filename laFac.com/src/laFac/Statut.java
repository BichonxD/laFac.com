package laFac;

import java.util.ArrayList;

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
	
	public abstract ArrayList<Offre> getContexteStatut();
	
	public String toString()
	{
		return "" + nomStat;
	}
	
}
