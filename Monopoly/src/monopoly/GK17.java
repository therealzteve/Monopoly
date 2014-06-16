package monopoly;

public class GK17 implements Aktion{
	Monopoly monopoly;
	public GK17 (Monopoly monopoly){
		this.monopoly = monopoly;
	}
	@Override
	public void fuehreAktionAus(int id) {
		// TODO Auto-generated method stub
		
		monopoly.players.get(id).setGuthaben(monopoly.players.get(id).getGuthaben() -15);

	}
	@Override
	public String getKartenText() {
		// TODO Auto-generated method stub
		return "STRAFE FÜR ZU SCHNELLES FAHREN: €15";
	}

}
