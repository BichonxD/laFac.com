package laFac;

import java.util.ArrayList;

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

	@Override
	public ArrayList<Offre> getContexteStatut()
	{
		// TODO Auto-generated method stub
		return null;
	}
	
}
