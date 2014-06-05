package monopoly;

public class GK1 implements Aktion{
	Monopoly monopoly;
	public GK1 (Monopoly monopoly){
		this.monopoly = monopoly;
	}
	@Override
	public void fuehreAktionAus(int id) {
		// TODO Auto-generated method stub
		String kartentext = "ZAHLE EINE STRAFE VON € 10.";// ODER NIMM EINE EREIGNISKARTE.";
		
		monopoly.players.get(id).setGuthaben(monopoly.players.get(id).getGuthaben() +10);

	}

}
