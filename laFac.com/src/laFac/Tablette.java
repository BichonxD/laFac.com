package laFac;

public class Tablette extends Hightech
{
	private String marque;
	
	public Tablette(double prix, int stock, int tempsGarantie, String marque)
	{
		super("Tablette " + marque, prix, stock, true, tempsGarantie);
		this.marque = marque;
	}
	
	public String toString()
	{
		return "TABLETTE : \nMarque : " + marque + "\n" + super.toString();
	}
	
}
