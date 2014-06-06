package monopoly;

public class GK23 implements Aktion{
	Monopoly monopoly;
	public GK23 (Monopoly monopoly){
		this.monopoly = monopoly;
	}
	@Override
	public void fuehreAktionAus(int id) {
		// TODO Auto-generated method stub
		String kartentext = "RÜCKE VOR BIS ZUR SCHLOSSALLEE.";
		
		monopoly.players.get(id).setPosition(39, id);;

	}

}
