package monopoly;

public class GK24 implements Aktion{
	Monopoly monopoly;
	public GK24 (Monopoly monopoly){
		this.monopoly = monopoly;
	}
	@Override
	public void fuehreAktionAus(int id) {
		// TODO Auto-generated method stub
		String kartentext = "MIETE UND ANLEIHEZINSEN WERDEN FÄLLIG. DIE BANK ZAHLT DIR € 150";
		
		monopoly.players.get(id).setGuthaben(monopoly.players.get(id).getGuthaben() +150);

	}

}
