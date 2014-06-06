package monopoly;

public class GK11 implements Aktion{
	Monopoly monopoly;
	public GK11 (Monopoly monopoly){
		this.monopoly = monopoly;
	}
	@Override
	public void fuehreAktionAus(int id) {
		// TODO Auto-generated method stub
		String kartentext = "RÜCKE VOR BIS ZUM NÄCHSTEN BAHNHOF. DER EIGENTÜMER ERHÄLT DAS DOPPELTE DER NORMALEN MIETE. HAT NOCH KEIN SPIELER EINEN BESITZANSPRUCH AUF DIESEN BAHNHOF, SO KANNST DU IHN VON DER BANK KAUFEN.";
		if (monopoly.players.get(id).getPosition() >= 35 || monopoly.players.get(id).getPosition() >= 0 & monopoly.players.get(id).getPosition() < 5 ){
		monopoly.players.get(id).setPosition(5, id);
		}
		else if (monopoly.players.get(id).getPosition() >= 5 & monopoly.players.get(id).getPosition() <15){
			monopoly.players.get(id).setPosition(15, id);
		}
		else if (monopoly.players.get(id).getPosition() >= 15 & monopoly.players.get(id).getPosition() <25){
			monopoly.players.get(id).setPosition(25, id);
		}
		else if (monopoly.players.get(id).getPosition() >= 25 & monopoly.players.get(id).getPosition() <35){
			monopoly.players.get(id).setPosition(35, id);
		}
	}

}
