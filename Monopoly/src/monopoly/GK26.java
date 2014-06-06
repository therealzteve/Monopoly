package monopoly;

public class GK26 implements Aktion{
	Monopoly monopoly;
	public GK26 (Monopoly monopoly){
		this.monopoly = monopoly;
	}
	@Override
	public void fuehreAktionAus(int id) {
		// TODO Auto-generated method stub
		String kartentext = "DU BIST ZUM VORSTAND GEWÄHLT WORDEN. ZAHLE JEDEM SPIELER € 50";
		
		monopoly.players.get(id).setGuthaben(monopoly.players.get(id).getGuthaben() -monopoly.players.size()*50);
		
		for (int i = 0; monopoly.players.size() < i; i++){
			if (i != id){
				monopoly.players.get(i).setGuthaben(monopoly.players.get(i).getGuthaben() + 50);
	
			}
		}
	}

}
