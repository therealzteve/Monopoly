package actions.ingame;

import javax.servlet.http.HttpServletRequest;

import beans.Result;
import misc.TextKeys;
import monopoly.Feld;
import monopoly.Monopoly;
import monopoly.Spieler;
import monopoly.Street;
import actions.GameBaseAction;

public class BuildAction extends GameBaseAction {

	public BuildAction(Monopoly monopoly , int playerId) {
		super(monopoly,playerId);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String performAction(HttpServletRequest request) {
		
		//Request Daten ermitteln
		int streetId = Integer.parseInt(request.getParameter(TextKeys.streetId));
		int buildAmount = Integer.parseInt(request.getParameter(TextKeys.buildAmount));
		
		//Find street
		Feld f = monopoly.fields.get(streetId);
		
		
		Street str = null;
		String message = "";
		//Typ pruefen und pruefen ob  strasse dem jeweiligen Spieler gehoert
		if("strasse".equals(f.getTyp()) || monopoly.players.get(playerId).getOwnedStreets().contains(f)){
			//Feld zu strasse casten
			str = (Street)f;
			
			if(str.getStufe() < 4){
				//Baustufe erhoehen
				str.setStufe(str.getStufe() + buildAmount);
				//get player
				Spieler p = monopoly.players.get(playerId);
				if(str.getStufe()< 3){
					p.setGuthaben(p.getGuthaben() - str.getPreisHaus());
				}else{
					p.setGuthaben(p.getGuthaben() - str.getPreisHotel());
				}
				
				message = "Bau erfolgreich abgeschlossen <br> Stra&szlig;e: "+str.getName()+"<br> Neuer Mietpreis: " + str.getCurrentMiete();
			}else{
				message = "Stra&szlig;e: "+ str.getName() + " ist schon voll ausgebaut."; 
			}
		}
		
		Result r = new Result();
		r.setSuccess(true);
		r.setMessage(message);
		r.setEvent("build");
		request.setAttribute(TextKeys.result,r );
		return "/json/standard.jsp";
	}

}
