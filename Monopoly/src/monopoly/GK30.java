package monopoly;

public class GK30 implements Aktion{
	Monopoly monopoly;
	public GK30 (Monopoly monopoly){
		this.monopoly = monopoly;
	}
	@Override
	public void fuehreAktionAus(int id) {
		// TODO Auto-generated method stub
		
		monopoly.players.get(id).setPosition(5);

	}
	@Override
	public String getKartenText() {
		// TODO Auto-generated method stub
		return "MACHE EINEN AUSFLUG ZUM SÜDBAHNHOF. WENN DU ÜBER LOS KOMMST ZIEHE € 200 EIN.";
	}

}
