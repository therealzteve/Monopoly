package monopoly;

public class GK21 implements Aktion{
	Monopoly monopoly;
	public GK21 (Monopoly monopoly){
		this.monopoly = monopoly;
	}
	@Override
	public void fuehreAktionAus(int id) {
		// TODO Auto-generated method stub
		String kartentext = "GEHE IN DAS GEFÄNGNIS! BEGIB DICH DIREKT DORTHIN. GEHE NICHT ÜBER LOS. ZIEHE NICHT € 200 EIN.";
		
		monopoly.players.get(id).setSimplePosition(10);;

	}

}
