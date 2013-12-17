package laFac;

public class Livres extends Culture
{
	private String titre;
	private String auteur;
	
	public Livres(double prix, double reductionEmploye, int ptsFidelite, int stock, String titre, String auteur)
	{
		super(titre, prix, reductionEmploye, ptsFidelite, stock);
		this.titre = titre;
		this.auteur = auteur;
	}
	
	public String toString()
	{
		return "LIVRE : \nTitre : " + titre + "\nAuteur : " + auteur + "\n" + super.toString();
	}
}
