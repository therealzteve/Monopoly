package monopoly;



public class Aktionsfeld extends Feld {
	static int id;
	Monopoly monopoly;
	public Aktionsfeld (int id, String name, String typ){
		
	}
	
	public void fuehreKarteAus (int idSpieler){
		if (Aktionsfeld.getId() == 2 || Aktionsfeld.getId() == 7 || Aktionsfeld.getId() == 17 || 
			Aktionsfeld.getId() == 22 || Aktionsfeld.getId() == 33 || Aktionsfeld.getId() == 38){
			//führe zufällige aktion aus
		}
		else if (Aktionsfeld.getId() == 4){
			monopoly.players.get(idSpieler).setGuthaben(monopoly.players.get(idSpieler).getGuthaben() -200);
		}
		else if (Aktionsfeld.getId() == 38){
			monopoly.players.get(idSpieler).setGuthaben(monopoly.players.get(idSpieler).getGuthaben() -100);
		}
	}

	public static int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
