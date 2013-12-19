package laFac;

import java.util.ArrayList;

public class Adherent extends Statut
{
	private int nbPtsFidelite;
	private static int limitePtsFidelitePourReduction = 200;
	private static double reductionFixeFidelite = 10;
	
	public Adherent()
	{
		super(NomStatut.Adherent);
		nbPtsFidelite = 0;
	}
	
	public ArrayList<Offre> getListeOffreStatut()
	{
		return Contexte.getListeOffreAdherent();
	}
	
	public double getReductionFixeFidelite()
	{
		int nbLimite = 0;
		
		//Si l'adherent a assez de points pour avoir une reduction
		while(nbPtsFidelite >= limitePtsFidelitePourReduction)
		{
			nbLimite++;
			nbPtsFidelite -= limitePtsFidelitePourReduction;
		}
		
		return nbLimite * reductionFixeFidelite;
	}
	
	public void miseAJourPtsFidelite(int ptsFidelite)
	{
		nbPtsFidelite += ptsFidelite;
	}
	
	public String toString()
	{
		return super.toString() + "\nNombre de Points de Fidelite : " + nbPtsFidelite;
	}
}
