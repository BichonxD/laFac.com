package laFac;

import java.util.ArrayList;

public class OffreFlash extends Offre
{
	// La date limite est défini en nombre de mise à jour du contexte.
	private int dateExpiration;
	
	/** Reduction en pourcentage. */
	public OffreFlash(Produit prod, double reduction, int dateExpiration)
	{
		super(reduction);
		this.dateExpiration = dateExpiration;
		if (prod != null)
			produits.add(prod);
	}
	
	/** Reduction en pourcentage. */
	public OffreFlash(ArrayList<Produit> prods, double reduction, int dateExpiration)
	{
		super(reduction);
		this.dateExpiration = dateExpiration;
		if (prods != null)
			produits.addAll(prods);
	}
	
	public double getReduction()
	{
		double prix = 0;
		
		for (Produit prod : produits)
		{
			prix += prod.getPrix() * reduction;
		}
		
		return prix;
	}
	
	public void addProduit(Produit prod)
	{
		if(prod != null)
			produits.add(prod);
	}
	
	public boolean estElligiblePourPanier(final ArrayList<Produit> listProd)
	{
		return listProd.containsAll(produits);
	}
	
	public String toString()
	{
		String s = new String();
		
		if (!produits.isEmpty())
		{
			s += "OFFRE FLASH : \nProduits : \n";
			for (Produit prod : produits)
			{
				s += " - " + prod.getNom() + "\n";
			}
			
			s += "Reduction : " + (reduction * 100) + " %\nDate d'Expiration : " + (dateExpiration - Contexte.getDateDuJour()) + " jours restants.";
			
			return s;
		} else
			return "OFFRE FLASH NON APPLICABLE";
	}
	
}
