package laFac;

public class Adherent extends Statut
{

	private CarteFidelite carteFid;
	
	public Adherent()
	{
		super(NomStatut.Adherent);
		carteFid = new CarteFidelite();
	}
	
	public String toString()
	{
		return super.toString() + carteFid;
	}
	
}
