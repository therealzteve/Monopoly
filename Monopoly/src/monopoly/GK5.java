package monopoly;

public class GK5 implements Aktion {
	Monopoly monopoly;
	public GK5 (Monopoly monopoly){
		this.monopoly = monopoly;
	}
	@Override
	public void fuehreAktionAus(int id) {
		// TODO Auto-generated method stub
		String kartentext = "DIE JAHRESRENTE WIRD FALLIG. ZIEHE € 100 EIN.";
		monopoly.players.get(id).setGuthaben(monopoly.players.get(id).getGuthaben() +100);
	}

}
