package laFac;

public class Tablette extends Hightech
{
	private String marque;
	
	public Tablette(double prix, double reductionEmploye, int ptsFidelite, int stock, int tempsGarantie, String marque)
	{
		super("Tablette " + marque, prix, reductionEmploye, ptsFidelite, tempsGarantie, stock);
		this.marque = marque;
	}
	
	public String toString()
	{
		return "TABLETTE : \nMarque : " + marque + "\n" + super.toString();
	}
	
}
