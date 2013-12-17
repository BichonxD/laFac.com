package laFac;

import java.util.ArrayList;

/**
 * Singleton de l'offre employé.
 * Tous les employés ont la même gamme d'offre disponible.
 */
public class OffreEmploye extends Offre
{
	ArrayList<Offre> offresEmploye;
	
	/** Constructeur privé */
	private OffreEmploye()
	{
		offresEmploye = new ArrayList<>();
	}

	/** Instance unique pré-initialisée */
	private static OffreEmploye INSTANCE = new OffreEmploye();

	/** Point d'accès pour l'instance unique du singleton */
	public static OffreEmploye getInstance()
	{
		return INSTANCE;
	}
	
	public void ajouterOffre(Offre offre)
	{
		offresEmploye.add(offre);
	}
	
	public void supprimerOffre(Offre offre)
	{
		offresEmploye.remove(offre);
	}
}
