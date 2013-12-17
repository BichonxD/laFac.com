package laFac;

//Classe a changer, la gestion des exceptions est clairement à revoir
public class Erreur extends Exception
{
	private static final long serialVersionUID = 1L;
	
	public Erreur(String s)
	{
		super(s);
	}
	
	public Erreur()
	{
		super();
	}
}
