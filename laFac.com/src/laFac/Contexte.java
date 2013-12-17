package laFac;

import java.util.ArrayList;

public final class Contexte
{
	private ArrayList<Personne> listePersonne;
	private ArrayList<Produit> listeProduit;
	private ArrayList<Offre> listeOffre;
	
	public Contexte()
	{
		listePersonne = new ArrayList<Personne>();
		listeProduit = new ArrayList<Produit>();
		listeOffre = new ArrayList<Offre>();
	}
	
	/** L'initialisation de la partie marketing consiste à initialiser les produits et offres. */
	public void initMarketing()
	{
		/* Initialisation des produits */
		listeProduit.add(new Livres(25, 0, 15, 0, "Toto à l'école des Charcutiers", "Toto"));
		listeProduit.add(new Livres(15, 5, 30, 2000, "Toto et Martine", "Martine"));
		listeProduit.add(new Spectacles(50, 10, 50, 50, "Toto est Figaro", "12 décembre 2012"));
		listeProduit.add(new Spectacles(75, 0, 45, 250, "Toto attend Godot", "36 avril 2013"));
		listeProduit.add(new Tablette(250, 40, 300, 5, 5000, "Comon"));
		
		/* Initialisation des offres */

	}
	
	/** L'initialisation des personnes faisant vivre le site */
	public void initPersonne()
	{
		listePersonne.add(new Personne("Manuel Sanchez", "manuel@rigoleunpeu.fr", new Visiteur()));
		listePersonne.add(new Personne("Justine PetiteGoutte", "justine@pttegoutte.fr"));
		listePersonne.add(new Personne("Ervin PetiteGoutte", "ervin@pttegoutte.fr"));
		
		listePersonne.add(new Personne("Raoul alacavaplus", "raaaah@tatouille.fr", new Employe()));
		listePersonne.add(new Personne("Jose ventrerlaligo", "Jose@plucher.fr", new Employe()));
		
		listePersonne.add(new Personne("Jessica Scroutepourmidi", "JessicaScroutepourmidi@gfaim.fr", new Adherent()));
	}
	
	public String toString()
	{
		String ret = new String();
		
		ret = "ENVIRONNEMENT\n--------------------\nListe des PRODUITS : \n-----";
		for(Produit prod : listeProduit)
		{
			ret += "\n" + prod.toString() + "\n-----";
		}
		
		ret += "\n--------------------\nListe des OFFRES : \n-----";
		for(Offre ofr : listeOffre)
		{
			ret += "\n" + ofr.toString() + "\n-----";
		}
		
		ret += "\n--------------------\nListe des PERSONNES : \n-----";
		for(Personne pers : listePersonne)
		{
			ret += "\n" + pers.toString() + "\n-----";
		}
		
		ret += "\n--------------------";
		
		return ret;
	}
	
	public void testerEnvironnement()
	{
		
	}
	
	public static void main(String[] args)
	{
		Contexte environnement = new Contexte();
		environnement.initMarketing();
		environnement.initPersonne();
		System.out.println(environnement.toString());
		
		environnement.testerEnvironnement();
		// System.out.println(environnement.toString());
	}
}
