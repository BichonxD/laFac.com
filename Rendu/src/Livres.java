package laFac;

public class Livres extends Culture
{
	private String titre;
	private String auteur;
	
	public Livres(double prix, int stock, String titre, String auteur)
	{
		super(titre, prix, stock, false);
		this.titre = titre;
		this.auteur = auteur;
	}
	
	public String toString()
	{
		return "LIVRE : \nTitre : " + titre + "\nAuteur : " + auteur + "\n" + super.toString();
	}
	
}
