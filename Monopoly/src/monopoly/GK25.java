package monopoly;

public class GK25 implements Aktion{
	Monopoly monopoly;
	public GK25 (Monopoly monopoly){
		this.monopoly = monopoly;
	}
	@Override
	public void fuehreAktionAus(int id) {
		// TODO Auto-generated method stub
		
		monopoly.players.get(id).setPosition(11);

	}
	@Override
	public String getKartenText() {
		// TODO Auto-generated method stub
		return "RÜCKE VOR BIS ZUR SEESTRASSE. WENN DU ÜBER LOS KOMMST ZIEHE € 200 EIN.";
	}

}
