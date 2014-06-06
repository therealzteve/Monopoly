package monopoly;

public class GK20 implements Aktion{
	Monopoly monopoly;
	public GK20 (Monopoly monopoly){
		this.monopoly = monopoly;
	}
	@Override
	public void fuehreAktionAus(int id) {
		// TODO Auto-generated method stub
		String kartentext = "DU WIRST ZU STRASSENAUSBESSERUNGS­ARBEITEN HERANGEZOGEN. ZAHLE € 40 JE HAUS UND € 115 JE HOTEL AN DIE BANK.";
		
		for (int i = 0; monopoly.players.get(id).ownedStreets.size() <= i; i++){
		monopoly.players.get(id).ownedStreets.get(i).getStufe
		}

	}

}
