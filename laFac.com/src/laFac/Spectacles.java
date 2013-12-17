package laFac;

public class Spectacles extends Culture
{
	private String titre;
	private String date;
	
	public Spectacles(double prix, double reductionEmploye, int ptsFidelite, int stock, String titre, String date)
	{
		super(titre, prix, reductionEmploye, ptsFidelite, stock);
		this.titre = titre;
		this.date = date;
	}
	
	public String toString()
	{
		return "SPECTACLE : \nTitre : " + titre + "\nDate de représentation : " + date + "\n" + super.toString();
	}
}
