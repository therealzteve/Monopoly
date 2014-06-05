package monopoly;

public class GK2 implements Aktion{
	Monopoly monopoly;
	public GK2 (Monopoly monopoly){
		this.monopoly = monopoly;
	}
	@Override
	public void fuehreAktionAus(int id) {
		// TODO Auto-generated method stub
		kartentext = "DU HAST DEN 2. PREIS IN EINER SCHÖNHEITSKONKURRENZ GEWONNEN. ZIEHE € 10 EIN.";
		monopoly.players.get(id).setGuthaben(monopoly.players.get(id).getGuthaben() +10);
	}

}
