package monopoly;

public class GK14 implements Aktion{
	Monopoly monopoly;
	public GK14 (Monopoly monopoly){
		this.monopoly = monopoly;
	}
	@Override
	public void fuehreAktionAus(int id) {
		// TODO Auto-generated method stub
		
		for (int i = monopoly.players.get(id).getPosition(); monopoly.players.get(id).getPosition() != 1; i--){
			monopoly.players.get(id).setSimplePosition(i);
		}

	}
	@Override
	public String getKartenText() {
		// TODO Auto-generated method stub
		return "GEHE ZURÜCK ZUR BADSTRASSE.";
	}

}
