package laFac;

public abstract class Hightech extends Produit
{
	private int tempsGarantie;
	
	public Hightech(String nom, double prix, double reductionEmploye, int ptsFidelite, int stock, int tempsGarantie)
	{
		super(nom, prix, reductionEmploye, ptsFidelite, stock);
		this.tempsGarantie = tempsGarantie;
		this.categorie = NomCategorie.Hightech;
	}
	
	/** La catégorie Hightech est elligible pour les offres promotionnelles */
	@Override
	public void setOffreProduit(OffreProduit offre) throws Erreur
	{
		this.offre = offre;
	}
	
	@Override
	public OffreProduit getOffreProduit()
	{
		return offre;
	}
	
	public String toString()
	{
		String s = new String();
		s = super.toString() + "\nGarantie : " + tempsGarantie + " ans";
		
		if(offre != null)
			s = s + offre.toString();
		else
			s = s + "\nAucune offre promotionnelle actuellement.";
		
		return s;
	}
}
