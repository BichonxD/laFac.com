package laFac;

import java.util.ArrayList;

public class Panier
{
	private String date;
	private ArrayList<Produit> listProduits;
	private Personne proprietaire;
	
	public Panier(Personne proprietaire)
	{
		// La date est fixée à aujourd'hui pour plus de simplicité
		date = "Aujourd'hui";
		listProduits = new ArrayList<Produit>();
		this.proprietaire = proprietaire;
	}
	
	public boolean ajoutProduit(Produit p)
	{
		if (p != null)
		{
			listProduits.add(p);
			return true;
		} else
		{
			System.out.println("Impossible d'ajouter au panier, produit inexistant");
			return false;
		}
	}
	
	public double facturation()
	{
		double coutAchat = 0;
		double coutReductionGenerale = 0;
		double coutReductionStatut = 0;
		int ptsFidelite = 0;
		
		for (Produit prod : listProduits)
		{
			coutAchat += prod.getPrix();
		}
		
		for (Offre ofr : Contexte.getListeOffreGenerale())
		{
			if (!ofr.getProduits().isEmpty() && listProduits.containsAll(ofr.getProduits()))
				coutReductionGenerale += ofr.getReduction();
		}
		
		for (Offre ofr : proprietaire.getListeOffreStatut())
		{
			if (!ofr.getProduits().isEmpty() && listProduits.containsAll(ofr.getProduits()))
			{
				coutReductionStatut += ofr.getReduction();
				ptsFidelite += ofr.getPtsFidelite();
			}
		}
		
		if (ptsFidelite != 0)
		{
			proprietaire.miseAJourPtsFidelite(ptsFidelite);
			coutReductionStatut += proprietaire.getReductionFixeFidelite();
		}
		
		// On présente l'addition
		System.out.println(lAddition(coutAchat, coutReductionGenerale, coutReductionStatut, ptsFidelite));
		
		// Avant de retourner ce que doit payer le Client on vide le panier
		videPanier();
		return coutAchat - coutReductionGenerale - coutReductionStatut;
	}
	
	public void videPanier()
	{
		listProduits.removeAll(listProduits);
	}
	
	public String toString()
	{
		String s = new String();
		s = "\n Date de création : " + date;
		
		if (listProduits.isEmpty())
			s += "\n Panier Vide.";
		else
		{
			
			s += "\n Produits contenus :";
			
			for (Produit prod : listProduits)
			{
				s += "\n - " + prod.toStringPanier();
			}
		}
		
		return s;
	}
	
	public String lAddition(double coutAchat, double coutReductionGenerale, double coutReductionStatut, int ptsFidelite)
	{
		String s = new String();
		s += "VOICI L'ADDITION\n--------------------";
		
		for (Produit prod : listProduits)
		{
			s += "\n - " + prod.toStringPanier();
		}
		
		s += "\n--------------------\nTotal des Achats\t" + coutAchat + " €";
		if (coutReductionGenerale != 0)
			s += "\nTotal des Promotions\t" + coutReductionGenerale + " €";
		if (coutReductionStatut != 0)
			s += "\nTotal des réductions grâce à votre Statut\t" + coutReductionStatut + " €";
		if (ptsFidelite != 0)
			s += "\nTotal des points de fidelité gagné\t" + ptsFidelite;
		s += "\n--------------------\nTotal\t" + (coutAchat - coutReductionGenerale - coutReductionStatut) + " €";
		
		return s;
	}
	
}
