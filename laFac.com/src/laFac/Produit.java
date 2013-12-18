package laFac;

public abstract class Produit
{
	protected String nom;
	protected double prix;
	protected int stock;
	protected boolean estElligibleAOffreProduit;
	protected NomCategorie categorie;
	
	public Produit(String nom, double prix, int stock, boolean estElligibleAOffreProduit)
	{
		this.nom = nom;
		this.prix = prix;
		this.stock = stock;
		this.estElligibleAOffreProduit = estElligibleAOffreProduit;
	}
	
	public void setEstElligibleAOffreProduit(boolean estElligibleAOffreProduit)
	{
		this.estElligibleAOffreProduit = estElligibleAOffreProduit;
	}
	
	public boolean getEstElligibleAOffreProduit()
	{
		return estElligibleAOffreProduit;
	}
	
	public String getNom()
	{
		return nom;
	}
	
	public double getPrix()
	{
		return prix;
	}
	
	public void setStock(int stock)
	{
		this.stock = stock;
	}
	
	public String toStringPanier()
	{
		return nom + ", " + prix + " €.";
	}
	
	public String toString()
	{
		String s = new String();
		s = "Nom Produit : " + nom + "\nPrix : " + prix + " €\nCategorie : " + categorie;
		if (stock == 0)
			s = s + "\nRupture de stock.";
		else
			s = s + "\nEn stock : " + stock;
		
		return s;
	}
	
}
