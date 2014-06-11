package monopoly;

public class GK28 implements Aktion{
	Monopoly monopoly;
	public GK28 (Monopoly monopoly){
		this.monopoly = monopoly;
	}
	@Override
	public void fuehreAktionAus(int id) {
		// TODO Auto-generated method stub
		String kartentext = "DIE BANK ZAHLT DIR EINE DIVIDENDE: € 50";
		
		monopoly.players.get(id).setGuthaben(monopoly.players.get(id).getGuthaben() +50);

	}

}
