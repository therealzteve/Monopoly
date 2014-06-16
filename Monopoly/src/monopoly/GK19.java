package monopoly;

public class GK19 implements Aktion{
	Monopoly monopoly;
	public GK19 (Monopoly monopoly){
		this.monopoly = monopoly;
	}
	@Override
	public void fuehreAktionAus(int id) {
		// TODO Auto-generated method stub
		
		monopoly.players.get(id).setPosition(24);

	}
	@Override
	public String getKartenText() {
		// TODO Auto-generated method stub
		return "RÜCKE VOR BIS ZUM OPERNPLATZ. WENN DU ÜBER LOS KOMMST ZIEHE € 200 EIN.";
	}

}
