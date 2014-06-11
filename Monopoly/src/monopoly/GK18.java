package monopoly;

public class GK18 implements Aktion{
	Monopoly monopoly;
	public GK18 (Monopoly monopoly){
		this.monopoly = monopoly;
	}
	@Override
	public void fuehreAktionAus(int id) {
		// TODO Auto-generated method stub
		String kartentext = "DU HAST IN EINEM KREUZWORTRÄTSELWETTBEWERB GEWONNEN. ZIEHE € 100 EIN.";
		
		monopoly.players.get(id).setGuthaben(monopoly.players.get(id).getGuthaben() +100);

	}

}
