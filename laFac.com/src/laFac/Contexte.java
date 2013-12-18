package laFac;

import java.util.ArrayList;

/** Classe Singleton */
public final class Contexte
{
	private ArrayList<Personne> listePersonne;
	private ArrayList<Produit> listeProduit;
	private ArrayList<Offre> listeOffre;
	/** Instance unique pré-initialisée */
	private static Contexte INSTANCE = new Contexte();
	private static int dateDuJour = 0;
	
	private Contexte()
	{
		listePersonne = new ArrayList<Personne>();
		listeProduit = new ArrayList<Produit>();
		listeOffre = new ArrayList<Offre>();
	}
	
	/** Point d'accès pour l'instance unique du singleton */
	public static Contexte getInstance()
	{
		return INSTANCE;
	}
	
	private void creationLivreOffreEmployeFidelite(double prix, int stock, String titre, String auteur, double reductionEmploye, double ptsFidelite)
	{
		Livres l = new Livres(prix, stock, titre, auteur);
		listeProduit.add(l);
		listeOffre.add(new OffreEmploye(l, reductionEmploye));
		//listeOffre.add(new OffreFlash(l, ptsFidelite));
	}
	
	private void creationSpectacleOffreEmployeFidelite(double prix, int stock, String titre, String date, double reductionEmploye, double ptsFidelite)
	{
		Spectacles l = new Spectacles(prix, stock, titre, date);
		listeProduit.add(l);
		listeOffre.add(new OffreEmploye(l, reductionEmploye));
		//listeOffre.add(new OffreFlash(l, ptsFidelite));
	}
	
	private void creationTabletteOffreEmployeFidelite(double prix, int stock, int tmpsGarantie, String marque, double reductionEmploye, double ptsFidelite)
	{
		Tablette l = new Tablette(prix, stock, tmpsGarantie, marque);
		listeProduit.add(l);
		listeOffre.add(new OffreEmploye(l, reductionEmploye));
		//listeOffre.add(new OffreFlash(l, ptsFidelite));
	}
	
	/** L'initialisation de la partie marketing consiste à initialiser les produits et offres. */
	public void initMarketing()
	{
		/* Initialisation des produits */
		creationLivreOffreEmployeFidelite(25, 10, "Toto à l'école des Charcutiers", "Toto", 0.5, 10);
		creationLivreOffreEmployeFidelite(15, 2000, "Toto et Martine", "Martine", 0.5, 10);
		creationSpectacleOffreEmployeFidelite(50, 50, "Toto est Figaro", "12 décembre 2012", 0.4, 25);
		creationSpectacleOffreEmployeFidelite(75, 250, "Toto attend Godot", "36 avril 2013", 0.4, 25);
		creationTabletteOffreEmployeFidelite(250, 5000, 2, "Comon", 0.25, 50);
		creationTabletteOffreEmployeFidelite(400, 5000, 3, "Gogo Gadgeto", 0.25, 200);
		
		/* Initialisation des offres */
		/* Offre Produits */
		listeOffre.add(new OffreProduit(listeProduit.get(0), 0.25, 2));
		listeOffre.add(new OffreProduit(listeProduit.get(2), 0.25, 2));
		listeOffre.add(new OffreProduit(listeProduit.get(4), 0.25, 3));
		/* Offre Flash */
		OffreFlash f = new OffreFlash(listeProduit.get(0), 0.25, 2);
		listeOffre.add(f);
		f.addProduit(listeProduit.get(1));
		ArrayList<Produit> tmp = new ArrayList<Produit>();
		tmp.addAll(listeProduit);
		listeOffre.add(new OffreFlash(tmp, 0.25, 2));
		listeOffre.add(new OffreFlash(listeProduit.get(4), 0.25, 3));
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
	
	public static int getDateDuJour()
	{
		return dateDuJour;
	}
	
	/** Incrémente la date de 1 et supprime toutes les Offres révolues. */
	public void miseAJourDate()
	{
		dateDuJour++;
	}
	
	public String toString()
	{
		String ret = new String();
		
		ret = "ENVIRONNEMENT\n--------------------\nListe des PRODUITS : \n-----";
		/*
		 * for (Produit prod : listeProduit) { ret += "\n" + prod.toString() + "\n-----"; }
		 */

		ret += "\n--------------------\nListe des OFFRES : \n-----";
		for (Offre ofr : listeOffre)
		{
			ret += "\n" + ofr.toString() + "\nReduction possible : " + ofr.getReduction() + " €\n-----";
		}
		
		/*
		 * ret += "\n--------------------\nListe des PERSONNES : \n-----"; for (Personne pers : listePersonne) { ret
		 * += "\n" + pers.toString() + "\n-----"; }
		 */

		ret += "\n--------------------";
		
		return ret;
	}
	
	public void testerEnvironnement()
	{
		
	}
	
	public static void main(String[] args)
	{
		Contexte environnement = Contexte.getInstance();
		environnement.initMarketing();
		environnement.initPersonne();
		System.out.println(environnement.toString());
		
		environnement.testerEnvironnement();
		// System.out.println(environnement.toString());
	}
}
