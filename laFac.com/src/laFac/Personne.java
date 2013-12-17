package laFac;

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
		pan = new Panier();
	}
	
	public Personne(String nom, String adresse, Statut statut)
	{
		this(nom, adresse);
		stat = statut;
	}
	
	public static int getNewID()
	{
		return currentID++;
	}
	
	public String toString()
	{
		return "PERSONNE : \nNom : " + nom + "\nE-mail : " + adresse + "\nId : " + id + "\nStatut : " + stat.toString() + "\nPanier : " + pan.toString();
	}
}
