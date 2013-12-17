package laFac;

public abstract class Culture extends Produit
{
	public Culture(String nom, double prix, double reductionEmploye, int ptsFidelite, int stock)
	{
		super(nom, prix, reductionEmploye, ptsFidelite, stock);
		this.categorie = NomCategorie.Culture;
	}
	
	/**
	 * La Categorie de produit n'est pas considérée comme élligible aux offres promotionnelles. Elle remonte donc une
	 * exception si on essaie de définir une offre pour la catégorie. A noter que la fonction est redéfinie comme final
	 * pour que les sous-classes ne puissent la redéfinir.
	 */
	@Override
	public void setOffreProduit(OffreProduit offre) throws Erreur
	{
		throw new Erreur("Les objets de la Catégorie Culture ne sont pas elligibles à des offres promotionnelles.");
	}
	
	/**
	 * Comme la catégorie n'est pas considérée comme elligible elle renvoie toujours null. A noter que la fonction est
	 * redéfinie comme final pour que les sous-classes ne puissent la redéfinir.
	 */
	@Override
	public OffreProduit getOffreProduit()
	{
		return null;
	}
	
	public String toString()
	{
		String s = new String();
		s = super.toString();
		s = s + "\nCategorie non elligible aux offres promotionnelles.";
		
		return s;
	}
	
}
