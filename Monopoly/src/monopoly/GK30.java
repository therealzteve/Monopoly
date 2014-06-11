package monopoly;

public class GK30 implements Aktion{
	Monopoly monopoly;
	public GK30 (Monopoly monopoly){
		this.monopoly = monopoly;
	}
	@Override
	public void fuehreAktionAus(int id) {
		// TODO Auto-generated method stub
		String kartentext = "MACHE EINEN AUSFLUG ZUM SÜDBAHNHOF. WENN DU ÜBER LOS KOMMST ZIEHE € 200 EIN.";
		
		monopoly.players.get(id).setPosition(5);

	}

}
