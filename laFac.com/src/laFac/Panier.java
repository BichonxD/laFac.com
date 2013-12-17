package laFac;

import java.util.ArrayList;

public class Panier
{
	private String date;
	private ArrayList<Produit> listProduits;
	
	public Panier()
	{
		// La date est fixée à aujourd'hui pour plus de simplicité
		date = "Aujourd'hui";
		listProduits = new ArrayList<Produit>();
	}
	
	public String toString()
	{
		String s = new String();
		s = "\n Date de création : " + date;
		
		if(listProduits.isEmpty())
			s += "\n Panier Vide.";
		else
		{
			
			s += "\n Produits contenus :";
			
			for(Produit prod : listProduits)
			{
				s += "\n - " + prod.toStringPanier();
			}
		}
		
		return s;
	}
	
}
