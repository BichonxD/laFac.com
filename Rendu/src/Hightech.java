package laFac;

public abstract class Hightech extends Produit
{
	protected int tempsGarantie;
	
	public Hightech(String nom, double prix, int stock, boolean estElligibleAOffreProduit , int tempsGarantie)
	{
		super(nom, prix, stock, estElligibleAOffreProduit);
		this.tempsGarantie = tempsGarantie;
		this.categorie = NomCategorie.Hightech;
	}
	
	public String toString()
	{
		return super.toString() + "\nGarantie : " + tempsGarantie + " ans";
	}
	
}
