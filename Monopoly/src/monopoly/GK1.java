package monopoly;

public class GK1 implements Aktion{

	@Override
	public void fuehreAktionAus() {
		// TODO Auto-generated method stub
		String kartentext = "ZAHLE EINE STRAFE VON € 10 ODER NIMM EINE EREIGNISKARTE.";
		
		this.Spieler.Guthaben -= 10;
	}

}
