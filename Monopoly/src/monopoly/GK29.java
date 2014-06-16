package monopoly;

public class GK29 implements Aktion{
	Monopoly monopoly;
	public GK29 (Monopoly monopoly){
		this.monopoly = monopoly;
	}
	@Override
	public void fuehreAktionAus(int id) {
		// TODO Auto-generated method stub
		
		for (int i = 0; monopoly.players.get(id).ownedStreets.size() <= i; i++){
			int ausbau = monopoly.players.get(id).ownedStreets.get(i).getStufe();
				if (ausbau < 6){
					monopoly.players.get(id).setGuthaben(monopoly.players.get(id).getGuthaben() - (ausbau * 25));
				}
				else  {
					monopoly.players.get(id).setGuthaben(monopoly.players.get(id).getGuthaben() - 100);
				}
			}

	}
	@Override
	public String getKartenText() {
		// TODO Auto-generated method stub
		return "LASSE ALLE DEINE HÄUSER RENOVIEREN! ZAHLE AN DIE BANK: FÜR JEDES HAUS € 25 FÜR JEDES HOTEL € 100";
	}

}
