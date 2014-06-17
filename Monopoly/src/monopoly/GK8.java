package monopoly;

public class GK8 implements Aktion {
	Monopoly monopoly;
	public GK8 (Monopoly monopoly){
		this.monopoly = monopoly;
	}
	@Override
	public void fuehreAktionAus(int id) {
		// TODO Auto-generated method stub
		monopoly.players.get(id).setGuthaben(monopoly.players.get(id).getGuthaben() +20);
		//monopoly.freiParken.addBetrag(20)

	}
	@Override
	public String getKartenText() {
		// TODO Auto-generated method stub
		return "EINKOMMENSTEUER-RÜCKZAHLUNG. ZIEHE € 20 EIN.";
	}
}
