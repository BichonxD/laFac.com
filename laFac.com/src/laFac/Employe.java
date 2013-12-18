package laFac;

import java.util.ArrayList;

public class Employe extends Statut
{
	private OffreEmploye offre;
	
	public Employe()
	{
		super(NomStatut.Employe);
	}
	
	public String toString()
	{
		return super.toString();
	}

	@Override
	public ArrayList<Offre> getContexteStatut()
	{
		// TODO Auto-generated method stub
		return null;
	}
}
