package laFac;

import java.util.ArrayList;

/** Classe Singleton */
public final class Contexte
{
	private ArrayList<Personne> listePersonne;
	private ArrayList<Produit> listeProduit;
	private ArrayList<Offre> listeOffreGenerale;
	private ArrayList<Offre> listeOffreEmploye;
	private ArrayList<Offre> listeOffreFidelite;
	/** Instance unique pré-initialisée */
	private static Contexte INSTANCE = new Contexte();
	private static int dateDuJour = 0;
	
	private Contexte()
	{
		listePersonne = new ArrayList<Personne>();
		listeProduit = new ArrayList<Produit>();
		listeOffreGenerale = new ArrayList<Offre>();
		listeOffreEmploye = new ArrayList<Offre>();
		listeOffreFidelite = new ArrayList<Offre>();
	}
	
	/** Point d'accès pour l'instance unique du singleton */
	public static Contexte getInstance()
	{
		return INSTANCE;
	}
	
	private void creationLivreOffreEmployeFidelite(double prix, int stock, String titre, String auteur, double reductionEmploye, int ptsFidelite)
	{
		Livres l = new Livres(prix, stock, titre, auteur);
		listeProduit.add(l);
		listeOffreEmploye.add(new OffreEmploye(l, reductionEmploye));
		listeOffreFidelite.add(new OffreFidelite(l, ptsFidelite));
	}
	
	private void creationSpectacleOffreEmployeFidelite(double prix, int stock, String titre, String date, double reductionEmploye, int ptsFidelite)
	{
		Spectacles l = new Spectacles(prix, stock, titre, date);
		listeProduit.add(l);
		listeOffreEmploye.add(new OffreEmploye(l, reductionEmploye));
		listeOffreFidelite.add(new OffreFidelite(l, ptsFidelite));
	}
	
	private void creationTabletteOffreEmployeFidelite(double prix, int stock, int tmpsGarantie, String marque, double reductionEmploye, int ptsFidelite)
	{
		Tablette l = new Tablette(prix, stock, tmpsGarantie, marque);
		listeProduit.add(l);
		listeOffreEmploye.add(new OffreEmploye(l, reductionEmploye));
		listeOffreFidelite.add(new OffreFidelite(l, ptsFidelite));
	}
	
	public static int getDateDuJour()
	{
		return dateDuJour;
	}
	
	/** Incrémente la date de 1 et supprime toutes les Offres révolues. */
	public void miseAJourDate()
	{
		dateDuJour++;
		
		for(Offre ofr : listeOffreGenerale)
		{
			if(!ofr.miseAJourDate())
				listeOffreGenerale.remove(ofr);
		}
		
		for(Offre ofr : listeOffreEmploye)
		{
			if(!ofr.miseAJourDate())
				listeOffreGenerale.remove(ofr);
		}
		
		for(Offre ofr : listeOffreFidelite)
		{
			if(!ofr.miseAJourDate())
				listeOffreGenerale.remove(ofr);
		}
	}
	
	public static ArrayList<Offre> getListeOffreGenerale()
	{
		final ArrayList<Offre> listTmp = new ArrayList<Offre>();
		listTmp.addAll(Contexte.getInstance().getLOffreGenerale());
		return listTmp;
	}
	
	public ArrayList<Offre> getLOffreGenerale()
	{
		return listeOffreGenerale;
	}
	
	public static ArrayList<Offre> getListeOffreEmploye()
	{
		final ArrayList<Offre> listTmp = new ArrayList<Offre>();
		listTmp.addAll(Contexte.getInstance().getLOffreEmploye());
		return listTmp;
	}
	
	public ArrayList<Offre> getLOffreEmploye()
	{
		return listeOffreEmploye;
	}
	
	public static ArrayList<Offre> getListeOffreAdherent()
	{
		final ArrayList<Offre> listTmp = new ArrayList<Offre>();
		listTmp.addAll(Contexte.getInstance().getLOffreFidelite());
		return listTmp;
	}
	
	public ArrayList<Offre> getLOffreFidelite()
	{
		return listeOffreFidelite;
	}
	
	public String toString()
	{
		String ret = new String();
		
		ret = "ENVIRONNEMENT\n--------------------\nListe des PRODUITS : \n-----";		
		for (Produit prod : listeProduit)
		{
			ret += "\n" + prod.toString() + "\n-----";
		}
		
		ret += "\n--------------------\nListe des OFFRES : \n-----";
		for (Offre ofr : listeOffreGenerale)
		{
			ret += "\n" + ofr.toString() + "\n-----";
		}
		
		for (Offre ofr : listeOffreEmploye)
		{
			ret += "\n" + ofr.toString() + "\n-----";
		}
		
		for (Offre ofr : listeOffreFidelite)
		{
			ret += "\n" + ofr.toString() + "\n-----";
		}
		
		ret += "\n--------------------\nListe des PERSONNES : \n-----";
		for (Personne pers : listePersonne)
		{
			ret += "\n" + pers.toString() + "\n-----";
		}
		
		ret += "\n--------------------";
		
		return ret;
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
		listeOffreGenerale.add(new OffreProduit(listeProduit.get(0), 0.25, 2));
		listeOffreGenerale.add(new OffreProduit(listeProduit.get(2), 0.25, 2));
		listeOffreGenerale.add(new OffreProduit(listeProduit.get(4), 0.25, 3));
		/* Offre Flash */
		OffreFlash f = new OffreFlash(listeProduit.get(0), 0.25, 2);
		listeOffreGenerale.add(f);
		f.addProduit(listeProduit.get(1));
		ArrayList<Produit> tmp = new ArrayList<Produit>();
		tmp.addAll(listeProduit);
		listeOffreGenerale.add(new OffreFlash(tmp, 0.25, 2));
		listeOffreGenerale.add(new OffreFlash(listeProduit.get(4), 0.25, 3));
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
	
	public void testerEnvironnement()
	{
		Personne p = listePersonne.get(5);
		p.achat(listeProduit.get(4));
		System.out.println("-----");
		double paiement = p.paiement();
		System.out.println("Le Client " + p.getId() + " a payé " + paiement + " €.");
	}
	
	public static void main(String[] args)
	{
		Contexte environnement = Contexte.getInstance();
		environnement.initMarketing();
		environnement.initPersonne();
		//System.out.println(environnement.toString() + "\n");
		
		environnement.testerEnvironnement();
		// System.out.println(environnement.toString());
	}
}
