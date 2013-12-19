package laFac;

import java.util.ArrayList;

public class OffreEmploye extends Offre
{
	
	/** Reduction en pourcentage. */
	public OffreEmploye(Produit prod, double reduction)
	{
		super(reduction);
		if (prod != null)
			produits.add(prod);
	}
	
	public double getReduction()
	{
		if (!produits.isEmpty())
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
		if (!produits.isEmpty())
			return "OFFRE EMPLOYE : \nProduit : " + produits.get(0).getNom() + "\nReduction : " + (reduction * 100) + " %";
		else
			return "OFFRE EMPLOYE NON APPLICABLE";
	}
	
}
