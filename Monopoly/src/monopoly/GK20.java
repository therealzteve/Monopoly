package monopoly;

public class GK20 implements Aktion{
	Monopoly monopoly;
	public GK20 (Monopoly monopoly){
		this.monopoly = monopoly;
	}
	@Override
	public void fuehreAktionAus(int id) {
		// TODO Auto-generated method stub
		
		
		for (int i = 0; monopoly.players.get(id).ownedStreets.size() <= i; i++){
		int ausbau = monopoly.players.get(id).ownedStreets.get(i).getStufe();
			if (ausbau < 6){
				monopoly.players.get(id).setGuthaben(monopoly.players.get(id).getGuthaben() - (ausbau * 40));
			}
			else  {
				monopoly.players.get(id).setGuthaben(monopoly.players.get(id).getGuthaben() - 115);
			}
		}

	}
	@Override
	public String getKartenText() {
		// TODO Auto-generated method stub
		return "DU WIRST ZU STRASSENAUSBESSERUNGS­ARBEITEN. HERANGEZOGEN. ZAHLE € 40 JE HAUS UND € 115 JE HOTEL AN DIE BANK.";
	}

}
