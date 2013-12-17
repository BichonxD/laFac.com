package laFac;

import java.util.ArrayList;

public abstract class Produit
{
	protected String nom;
	protected double prix;
	protected double reductionEmploye;
	protected int ptsFidelite;
	protected int stock;
	protected ArrayList<Offre> offre;
	protected NomCategorie categorie;
	
	public Produit(String nom, double prix, double reductionEmploye, int ptsFidelite, int stock)
	{
		this.nom = nom;
		this.prix = prix;
		this.reductionEmploye = reductionEmploye;
		this.ptsFidelite = ptsFidelite;
		this.stock = stock;
		offre = new ArrayList<Offre>();
	}
	
	/** Remonte une erreur si la catégorie du produit n'est pas elligible au promotion */
	public abstract void setOffreProduit(OffreProduit offre) throws Erreur;
	
	/** Renvoie l'offre produit disponible pour le produit ou null si aucune offre n'existe */
	public abstract OffreProduit getOffreProduit();
	
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
		s = "Nom Produit : " + nom + "\nPrix : " + prix + " €\nReduction pour les Employes : " + reductionEmploye + " €\nPoints de fidelite : " + ptsFidelite + "\nCategorie : " + categorie;
		if(stock == 0)
			s = s + "\nStock vide";
		else
			s = s + "\nEn stock : " + stock;
		
		return s;
	}
}
