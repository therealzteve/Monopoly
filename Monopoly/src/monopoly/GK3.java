package monopoly;

public class GK3 implements Aktion {
	Monopoly monopoly;
	public GK3 (Monopoly monopoly){
		this.monopoly = monopoly;
	}
	@Override
	public void fuehreAktionAus(int id) {
		// TODO Auto-generated method stub
		monopoly.players.get(id).setGuthaben(monopoly.players.get(id).getGuthaben() +50);

	}
	@Override
	public String getKartenText() {
		// TODO Auto-generated method stub
		return "AUS LAGERVERKÄUFEN ERHÄLTST DU: € 50";
	}

}
