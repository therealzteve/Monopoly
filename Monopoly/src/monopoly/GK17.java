package monopoly;

public class GK17 implements Aktion{
	Monopoly monopoly;
	public GK17 (Monopoly monopoly){
		this.monopoly = monopoly;
	}
	@Override
	public void fuehreAktionAus(int id) {
		// TODO Auto-generated method stub
		String kartentext = "STRAFE FÜR ZU SCHNELLES FAHREN: €15";
		
		monopoly.players.get(id).setGuthaben(monopoly.players.get(id).getGuthaben() -15);

	}

}
