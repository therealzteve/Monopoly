package monopoly;

public class GK9 implements Aktion{
	Monopoly monopoly;
	public GK9 (Monopoly monopoly){
		this.monopoly = monopoly;
	}
	@Override
	public void fuehreAktionAus(int id) {
		// TODO Auto-generated method stub
		String kartentext = "ARZT KOSTEN. ZAHLE: € 50";
		
		monopoly.players.get(id).setGuthaben(monopoly.players.get(id).getGuthaben() +50);

	}

}
