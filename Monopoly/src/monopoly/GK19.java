package monopoly;

public class GK19 implements Aktion{
	Monopoly monopoly;
	public GK19 (Monopoly monopoly){
		this.monopoly = monopoly;
	}
	@Override
	public void fuehreAktionAus(int id) {
		// TODO Auto-generated method stub
		String kartentext = "RÜCKE VOR BIS ZUM OPERNPLATZ. WENN DU ÜBER LOS KOMMST ZIEHE € 200 EIN.";
		
		monopoly.players.get(id).setPosition(24);

	}

}
