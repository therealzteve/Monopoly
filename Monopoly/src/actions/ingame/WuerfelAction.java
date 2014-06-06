package actions.ingame;

import javax.servlet.http.HttpServletRequest;

import beans.Result;
import misc.TextKeys;
import monopoly.Feld;
import monopoly.Monopoly;
import monopoly.Spieler;
import monopoly.Street;
import actions.GameBaseAction;


public class WuerfelAction extends GameBaseAction {

	public WuerfelAction(Monopoly monopoly ,int  playerId) {
		super(monopoly, playerId);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String performAction(HttpServletRequest request) {
		String resultText = "";
		int result = (int)(Math.random()*12)+1;
		request.setAttribute("wuerfelzahl", result);
		
		
		//get Player
		Spieler p = monopoly.players.get(playerId);
		
		//change position
		p.addPosition(result);
		//handle position:
		
			//get type of field
			Feld f = monopoly.fields.get(p.getPosition());
		
			
			//if Aktionsfeld
			if("aktion".equals(f.getTyp()) ){
				resultText =  handleAktion(p);
			}
			
			//if street
			if("street".equals(f.getTyp()) ){
				resultText = handleStreet(p, (Street) f);
			}
			
			//Wenn unbekannt
			if(f.getTyp() == null){
				System.out.println( "Type is null");
				resultText =  handleMisc(p);
			}
		

		Result r = new Result();
		r.setSuccess(true);
		r.setMessage( "Wuerfelzahl: " + result + "<br>" + resultText);
		r.setEvent("wuerfel");
		request.setAttribute(TextKeys.result,r );
		
		return "/json/wuerfel.jsp";
	}
	

	private String handleAktion(Spieler p ){
		p.setUserState(2);
		return "Aktion bla blub";
	}
	
	private String handleMisc(Spieler p){
		p.setUserState(2);
		return "Noch zu bearbeiten";
	}
	
	private String handleStreet(Spieler p, Street str){
		String resultText = "";
		
		//if street
		//Check owner of street
		Spieler owner = str.getOwner();
		
		if(owner == null){
			p.setUserState(1);
			//if null change userState to enable buy
			resultText = "Strasse ist noch frei!";
		}else{
			if(owner.equals(p)){
				
				//Change user state to end turn state
				p.setUserState(2);
				
				
				resultText = "Diese Strasse gehoert dir bereits!";
			}else{
				p.setGuthaben(p.getGuthaben() - str.getCurrentMiete());
				owner.setGuthaben(owner.getGuthaben() + str.getCurrentMiete());
				
				//check guthaben of player
				//if minus --> GiveUp
				
				//Remove player from game, release cards
				
				//Set user state
				p.setUserState(2);
				
				resultText = "Diese Strasse gehoert "+ owner.getName() + "<br> Miete: "+ str.getCurrentMiete();
			}
		}
		return resultText;
	}
}
