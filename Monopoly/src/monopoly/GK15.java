package monopoly;

public class GK15 implements Aktion{
	Monopoly monopoly;
	public GK15 (Monopoly monopoly){
		this.monopoly = monopoly;
	}
	@Override
	public void fuehreAktionAus(int id) {
		// TODO Auto-generated method stub
		
		monopoly.players.get(id).setSimplePosition(10);;

	}
	@Override
	public String getKartenText() {
		// TODO Auto-generated method stub
		return "GEHE IN DAS GEFÄNGNIS! BEGIB DICH DIREKT DORTHIN. GEHE NICHT ÜBER LOS. ZIEHE NICHT € 200 EIN.";
	}

}
