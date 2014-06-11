package monopoly;

public class GK7 implements Aktion {
	Monopoly monopoly;
	public GK7 (Monopoly monopoly){
		this.monopoly = monopoly;
	}
	@Override
	public void fuehreAktionAus(int id) {
		// TODO Auto-generated method stub
		String kartentext = "BANK-IRRTUM ZU DEINEN GUNSTEN. ZIEHE € 200 EIN.";
		monopoly.players.get(id).setGuthaben(monopoly.players.get(id).getGuthaben() +200);

	}

}
