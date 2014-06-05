package monopoly;

public class GK5 implements Aktion {

	@Override
	public void fuehreAktionAus() {
		// TODO Auto-generated method stub
		kartentext = "DIE JAHRESRENTE WIRD FALLIG. ZIEHE € 100 EIN.";
		Guthaben += 100;
	}

}
