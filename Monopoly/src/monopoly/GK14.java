package monopoly;

public class GK14 implements Aktion{
	Monopoly monopoly;
	public GK14 (Monopoly monopoly){
		this.monopoly = monopoly;
	}
	@Override
	public void fuehreAktionAus(int id) {
		// TODO Auto-generated method stub
		String kartentext = "GEHE ZURÜCK ZUR BADSTRASSE.";
		
		for (int i = monopoly.players.get(id).getPosition(); monopoly.players.get(id).getPosition() != 1; i--){
			monopoly.players.get(id).setSimplePosition(i);
		}

	}

}
