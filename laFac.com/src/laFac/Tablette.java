package laFac;

public class Tablette extends Hightech
{
	
	
	@Override
	public void setOffreProduit(OffreProduit offre)
	{
		this.offre = offre;
	}
	
	@Override
	public OffreProduit getOffreProduit()
	{
		return offre;
	}
	
}
