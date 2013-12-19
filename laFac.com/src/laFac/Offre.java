package laFac;

import java.util.ArrayList;

public abstract class Offre
{
	protected ArrayList<Produit> produits;
	protected double reduction;
	
	public Offre(double reduction)
	{
		produits = new ArrayList<Produit>();
		this.reduction = reduction;
	}
	
	public abstract double getReduction();
	
	public int getPtsFidelite()
	{
		return 0;
	}
	
	public ArrayList<Produit> getProduits()
	{
		ArrayList<Produit> l = new ArrayList<Produit>();
		l.addAll(produits);
		return l;
	}
	
}
