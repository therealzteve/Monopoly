package monopoly;

public class GK6 implements Aktion{
	Monopoly monopoly;
	public GK6 (Monopoly monopoly){
		this.monopoly = monopoly;
	}
	@Override
	public void fuehreAktionAus(int id) {
		// TODO Auto-generated method stub
		monopoly.players.get(id).setGuthaben(monopoly.players.get(id).getGuthaben() + (monopoly.players.size()-1)*10);
		
		for (int i = 0; monopoly.players.size() < i; i++){
			if (i != id){
				monopoly.players.get(i).setGuthaben(monopoly.players.get(i).getGuthaben() - 10);
	
			}
		}
	}
	@Override
	public String getKartenText() {
		// TODO Auto-generated method stub
		return "ES IST DEIN GEBURTSTAG. ZIEHE VON JEDEM SPIELER € 10 EIN.";
	}

}
