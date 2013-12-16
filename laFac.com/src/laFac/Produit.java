package laFac;

public abstract class Produit
{
	protected double prix;
	protected double reductionEmploye;
	protected int ptsFidelite;
	protected int stock;
	protected OffreProduit offre;
	
	public abstract void setOffreProduit(OffreProduit offre) throws Erreur;
	public abstract OffreProduit getOffreProduit();
	
}
