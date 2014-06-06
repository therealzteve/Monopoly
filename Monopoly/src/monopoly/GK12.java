package monopoly;

public class GK12 implements Aktion{
	Monopoly monopoly;
	public GK12 (Monopoly monopoly){
		this.monopoly = monopoly;
	}
	@Override
	public void fuehreAktionAus(int id) {
		// TODO Auto-generated method stub
		String kartentext = "DU ERHÄLTST AUF VORZUGS-AKTIEN 7 % DIVIDENDE: € 25";
		
		monopoly.players.get(id).setGuthaben(monopoly.players.get(id).getGuthaben() +25);

	}

}
