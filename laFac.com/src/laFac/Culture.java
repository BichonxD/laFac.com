package laFac;

public abstract class Culture extends Produit
{
	public Culture(String nom, double prix, int stock, boolean estElligibleAOffreProduit)
	{
		super(nom, prix, stock, estElligibleAOffreProduit);
		this.categorie = NomCategorie.Culture;
	}
	
}
