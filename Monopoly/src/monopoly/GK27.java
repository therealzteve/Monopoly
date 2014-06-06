package monopoly;

public class GK27 implements Aktion{
	Monopoly monopoly;
	public GK27 (Monopoly monopoly){
		this.monopoly = monopoly;
	}
	@Override
	public void fuehreAktionAus(int id) {
		// TODO Auto-generated method stub
		String kartentext = "RÜCKE VOR BIS AUF LOS.";// ODER NIMM EINE EREIGNISKARTE.";
		
		monopoly.players.get(id).setPosition(0, id);;

	}

}
