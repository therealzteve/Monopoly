package monopoly;

public class GK4 implements Aktion{
	Monopoly monopoly;
	public GK4 (Monopoly monopoly){
		this.monopoly = monopoly;
	}
	@Override
	public void fuehreAktionAus(int id) {
		// TODO Auto-generated method stub
		String kartentext = "DU ERBST: € 100";
		monopoly.players.get(id).setGuthaben(monopoly.players.get(id).getGuthaben() +100);

	}

}
