package monopoly;

public class GK7 implements Aktion {
	Monopoly monopoly;
	public GK7 (Monopoly monopoly){
		this.monopoly = monopoly;
	}
	@Override
	public void fuehreAktionAus(int id) {
		// TODO Auto-generated method stub
		monopoly.players.get(id).setGuthaben(monopoly.players.get(id).getGuthaben() +200);

	}
	@Override
	public String getKartenText() {
		// TODO Auto-generated method stub
		return "BANK-IRRTUM ZU DEINEN GUNSTEN. ZIEHE € 200 EIN.";
	}

}
