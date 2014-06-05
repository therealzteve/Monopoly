package monopoly;

public class GK3 implements Aktion {
	Monopoly monopoly;
	public GK3 (Monopoly monopoly){
		this.monopoly = monopoly;
	}
	@Override
	public void fuehreAktionAus(int id) {
		// TODO Auto-generated method stub
		String kartentext = "AUS LAGERVERKÄUFEN ERHÄLTST DU: € 50";
		monopoly.players.get(id).setGuthaben(monopoly.players.get(id).getGuthaben() +50);

	}

}
