package monopoly;

public class GK27 implements Aktion{
	Monopoly monopoly;
	public GK27 (Monopoly monopoly){
		this.monopoly = monopoly;
	}
	@Override
	public void fuehreAktionAus(int id) {
		// TODO Auto-generated method stub
		
		monopoly.players.get(id).setPosition(0);

	}
	@Override
	public String getKartenText() {
		// TODO Auto-generated method stub
		return "RÜCKE VOR BIS AUF LOS.";
	}

}
