package monopoly;

public class GK13 implements Aktion{
	Monopoly monopoly;
	public GK13 (Monopoly monopoly){
		this.monopoly = monopoly;
	}
	@Override
	public void fuehreAktionAus(int id) {
		// TODO Auto-generated method stub
		String kartentext = "RÜCKE VOR BIS AUF LOS.";
		
		monopoly.players.get(id).setPosition(0);

	}

}
