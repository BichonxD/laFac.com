package laFac;

import java.util.ArrayList;

public class Employe extends Statut
{
	
	public Employe()
	{
		super(NomStatut.Employe);
	}
	
	public ArrayList<Offre> getListeOffreStatut()
	{
		return Contexte.getListeOffreEmploye();
	}
	
	public double getReductionFixeFidelite()
	{
		return 0;
	}
	
	public void miseAJourPtsFidelite(int ptsFidelite)
	{
	}
	
}
