package monopoly;

public class GK16 implements Aktion{
	Monopoly monopoly;
	public GK16 (Monopoly monopoly){
		this.monopoly = monopoly;
	}
	@Override
	public void fuehreAktionAus(int id) {
		// TODO Auto-generated method stub
		
		monopoly.players.get(id).setGuthaben(monopoly.players.get(id).getGuthaben() -100);

	}
	@Override
	public String getKartenText() {
		// TODO Auto-generated method stub
		return "ZAHLE AN DAS KRANKENHAUS: € 100";
	}

}
