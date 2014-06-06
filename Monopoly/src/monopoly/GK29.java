package monopoly;

public class GK29 implements Aktion{
	Monopoly monopoly;
	public GK29 (Monopoly monopoly){
		this.monopoly = monopoly;
	}
	@Override
	public void fuehreAktionAus(int id) {
		// TODO Auto-generated method stub
		String kartentext = "LASSE ALLE DEINE HÄUSER RENOVIEREN! ZAHLE AN DIE BANK: FÜR JEDES HAUS € 25 FÜR JEDES HOTEL € 100";
		
		monopoly.players.get(id).setGuthaben(monopoly.players.get(id).getGuthaben() -10);

	}

}
