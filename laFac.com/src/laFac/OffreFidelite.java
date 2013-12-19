package laFac;

import java.util.ArrayList;

public class OffreFidelite extends Offre
{
	public int ptsFidelite;
	
	public OffreFidelite(Produit prod, int ptsFidelite)
	{
		super(0);
		this.ptsFidelite = ptsFidelite;
		if (prod != null)
			produits.add(prod);
	}
	
	public double getReduction()
	{
		return reduction;
	}
	
	public int getPtsFidelite()
	{	
		return ptsFidelite;
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
			return "OFFRE FIDELITE : \nProduit : " + produits.get(0).getNom() + "\nPoints de Fidelite a gagner : " + reduction;
		else
			return "OFFRE FIDELITE NON APPLICABLE";
	}
	
}
