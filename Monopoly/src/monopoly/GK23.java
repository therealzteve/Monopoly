package monopoly;

public class GK23 implements Aktion{
	Monopoly monopoly;
	public GK23 (Monopoly monopoly){
		this.monopoly = monopoly;
	}
	@Override
	public void fuehreAktionAus(int id) {
		// TODO Auto-generated method stub
		
		monopoly.players.get(id).setPosition(39);

	}
	@Override
	public String getKartenText() {
		// TODO Auto-generated method stub
		return "RÜCKE VOR BIS ZUR SCHLOSSALLEE.";
	}

}
