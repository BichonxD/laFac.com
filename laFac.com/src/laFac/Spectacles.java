package laFac;

public class Spectacles extends Culture
{
	private String titre;
	private String date;
	
	public Spectacles(double prix, int stock, String titre, String date)
	{
		super(titre, prix, stock, true);
		this.titre = titre;
		this.date = date;
	}
	
	public String toString()
	{
		return "SPECTACLE : \nTitre : " + titre + "\nDate de representation : " + date + "\n" + super.toString();
	}
}
