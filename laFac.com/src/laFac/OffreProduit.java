package laFac;

import java.util.ArrayList;

public class OffreProduit extends Offre
{
	// La date limite est défini en nombre de mise à jour du contexte.
	private int dateExpiration;
	
	/** Reduction en pourcentage. Si le produit n'est pas elligible on ne l'ajoute pas à la liste de produit. */
	public OffreProduit(Produit prod, double reduction, int dateExpiration)
	{
		super(reduction);
		this.dateExpiration = dateExpiration;
		
		if (prod.getEstElligibleAOffreProduit())
		{
			produits.add(prod);
		}
	}
	
	public double getReduction()
	{
		if(!produits.isEmpty())
			return produits.get(0).getPrix() * reduction;
		else
			return 0;
	}
	
	public boolean estElligiblePourPanier(final ArrayList<Produit> listProd)
	{
		for(Produit prod : listProd)
		{
			if(prod.equals(produits.get(0)))
				return true;
		}
		
		return false;
	}
	
	public String toString()
	{
		if(!produits.isEmpty())
			return "OFFRE PRODUIT : \nProduit : " + produits.get(0).getNom() + "\nReduction : " + (reduction * 100) + " %\nDate d'Expiration : " + (dateExpiration - Contexte.getDateDuJour()) + " jours restants.";
		else
			return "OFFRE PRODUIT NON APPLICABLE";
	}
	
}
