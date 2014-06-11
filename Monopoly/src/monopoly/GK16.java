package monopoly;

public class GK16 implements Aktion{
	Monopoly monopoly;
	public GK16 (Monopoly monopoly){
		this.monopoly = monopoly;
	}
	@Override
	public void fuehreAktionAus(int id) {
		// TODO Auto-generated method stub
		String kartentext = "ZAHLE AN DAS KRANKENHAUS: € 100";
		
		monopoly.players.get(id).setGuthaben(monopoly.players.get(id).getGuthaben() -100);

	}

}
