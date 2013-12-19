package laFac;

import java.util.ArrayList;

public class Personne
{
	private String nom;
	private String adresse;
	private int id;
	private Statut stat;
	private Panier pan;
	private static int currentID = 0;
	
	/** La personne est créée avec un statut de visiteur, elle doit se connecter pour changer de Statut */
	public Personne(String nom, String adresse)
	{
		this.nom = nom;
		this.adresse = adresse;
		this.id = getNewID();
		stat = new Visiteur();
		pan = new Panier(this);
		pan.addObserver(new Alerte());
	}
	
	public Personne(String nom, String adresse, Statut statut)
	{
		this(nom, adresse);
		stat = statut;
	}
	
	public int getId()
	{
		return id;
	}
	
	public static int getNewID()
	{
		return currentID++;
	}

	public ArrayList<Offre> getListeOffreStatut()
	{
		return stat.getListeOffreStatut();
	}
	
	public void miseAJourPtsFidelite(int ptsFidelite)
	{
		stat.miseAJourPtsFidelite(ptsFidelite);
	}
	
	public double getReductionFixeFidelite()
	{
		return stat.getReductionFixeFidelite();
	}
	
	public boolean achat(Produit prod)
	{
		System.out.println(nom + " ajoute à son panier : \n - " + prod.toStringPanier());
		return pan.ajoutProduit(prod);
	}
	
	public double paiement()
	{
		System.out.println(nom + " passe à la caisse !");
		return pan.facturation();
	}
	
	public String toString()
	{
		return "PERSONNE : \nNom : " + nom + "\nE-mail : " + adresse + "\nId : " + id + "\nStatut : " + stat.toString() + "\nPanier : " + pan.toString();
	}
	
}
