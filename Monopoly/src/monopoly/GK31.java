package monopoly;

public class GK31 implements Aktion{
	Monopoly monopoly;
	public GK31 (Monopoly monopoly){
		this.monopoly = monopoly;
	}
	@Override
	public void fuehreAktionAus(int id) {
		// TODO Auto-generated method stub
		
		

	}
	@Override
	public String getKartenText() {
		// TODO Auto-generated method stub
		return "DU KOMMST AUS DEM GEFÄNGNIS FREI. Diese Karte musst du behalten, bis du sie benötigst oder verkaufst.";
	}

}
