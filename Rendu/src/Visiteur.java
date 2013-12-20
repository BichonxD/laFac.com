package laFac;

import java.util.ArrayList;

public class Visiteur extends Statut
{
	public Visiteur()
	{
		super(NomStatut.Visiteur);
	}
	
	public ArrayList<Offre> getListeOffreStatut()
	{
		return new ArrayList<Offre>();
	}
	
	public double getReductionFixeFidelite()
	{
		return 0;
	}
	
	public void miseAJourPtsFidelite(int ptsFidelite)
	{
	}
	
}
