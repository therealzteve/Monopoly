package monopoly;

public class GK10 implements Aktion{
	Monopoly monopoly;
	public GK10 (Monopoly monopoly){
		this.monopoly = monopoly;
	}
	@Override
	public void fuehreAktionAus(int id) {
		// TODO Auto-generated method stub
		System.out.println("test");
	}
	@Override
	public String getKartenText() {
		// TODO Auto-generated method stub
		return "DU KOMMST AUS DEM GEFÄNGNIS FREI. Diese Karte musst du behalten, bis du sie benötigst oder verkaufst.";
	}

}
