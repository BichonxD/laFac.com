package laFac;

public abstract class Culture extends Produit
{


	@Override
	public void setOffreProduit(OffreProduit offre) throws Erreur
	{
		throw new Erreur("Les objets de la Catégorie Culture ne sont pas elligibles à des offres promotionnelles.");
	}
	
	@Override
	public final OffreProduit getOffreProduit()
	{
		return null;
	}
	
}
