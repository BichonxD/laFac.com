package laFac;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Alerte implements Observer
{
	private static int seuilPanier = 100;
	private static ArrayList<Produit> combinaisonProduit;
	
	public Alerte()
	{
		super();
	}
	
	public static void setCombinaisonProduit(ArrayList<Produit> combinaisonProd)
	{
		combinaisonProduit = combinaisonProd;
	}
	
	public void update(Observable arg0, Object arg1)
	{	
		Panier pan = (Panier) arg0;
		if(pan.getListProduits().containsAll(combinaisonProduit))
			System.out.println("ALERTE :\nLE panier contient la combinaison indiquée");
	}
	
}
