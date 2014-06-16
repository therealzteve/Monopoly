package monopoly;

public class GK32 implements Aktion{
	Monopoly monopoly;
	public GK32 (Monopoly monopoly){
		this.monopoly = monopoly;
	}
	@Override
	public void fuehreAktionAus(int id) {
		// TODO Auto-generated method stub
		
		monopoly.players.get(id).setPosition(monopoly.players.get(id).getPosition()-3);

	}
	@Override
	public String getKartenText() {
		// TODO Auto-generated method stub
		return "GEHE 3 FELDER ZURÜCK.";
	}

}
