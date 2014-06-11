package monopoly;

public class GK32 implements Aktion{
	Monopoly monopoly;
	public GK32 (Monopoly monopoly){
		this.monopoly = monopoly;
	}
	@Override
	public void fuehreAktionAus(int id) {
		// TODO Auto-generated method stub
		String kartentext = "GEHE 3 FELDER ZURÜCK.";
		
		monopoly.players.get(id).setPosition(monopoly.players.get(id).getPosition()-3);

	}

}
