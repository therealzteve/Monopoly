package monopoly;

import java.util.ArrayList;
/*Erzeugt das Monopoly Spielfeld, mit allen Feldern.
 * Enthält zwei Listen, eine mit Monopolyspielen und eine zweite mit Spielern auf dem jeweiligen Monopolyfeld.
 * 
 */

public class Monopoly {
	int id;
	int playerId = 0;
	int currentPlayerId = 0;
	public ArrayList<Spieler> players = new ArrayList<Spieler>();
	public ArrayList<Feld> fields = new ArrayList<Feld>();
	public boolean isRunning = false; // gibt an ob das Spiel gerade laeuft oder nicht
	private static int gameId = 0;
	
	public void spielerHinzufuegen(Spieler spieler){
		players.add(spieler);
	}
	
	public void erstelleStrassen(){
		 Feld Los = new Feld(0, "Los", "los");
		 Feld Bad = new Street(1, "Badstrasse", 0, 60,2,10,30,90,160,250);
		 Feld Ereignisfeld1 =new Aktionsfeld(2, "Ereignisfeld", "aktion", this);
		 Feld Turm = new Street(3, "Turmstrasse", 0, 60,4,20,60,180,320,450);
		 Feld Einkommenssteuer = new Aktionsfeld(4, "Einkommenssteuer", "aktion", this);
		 Feld Suedbahnhof = new Street (5, "Suedbahnhof", "bahnhof");
		 Feld Chausse = new Street(6,"Chaussestrasse", 1,100,6,30,90,270,400,550);
		 Feld Ereignisfeld2 = new Aktionsfeld(7, "Ereignisfeld", "aktion", this);
		 Feld Elisen =new Street (8, "Elisenstrasse", 1,100,6,30,90,270,400,550);
		 Feld Post = new Street(9, "Poststraße", 1,120,8,40,100,300,400,550);
		 Feld Gefaengnis = new Feld (10, "Gefaengnis", "gefaengnis");
		 Feld See = new Street (11, "Seestrasse",2,140,10,50,150,450,625,750);
		 Feld Elektrizitaetswerk = new Street (12, "Elektrizitaetswerk", "werk");
		 Feld Hafen = new Street (13, "Hafenstrasse",2,140,10,50,150,450,625,750);
		 Feld Neue = new Street (14, "Neue Strasse", 2, 160,12,60,180,500,700,900);
		 Feld Westbahnhof = new Street (15, "Westbahnhof", "bahnhof");
		 Feld Muenchener = new Street(16, "Muenchener Strasse", 3, 180,14,70,200,550,750,950);
		 Feld Wiener = new Street (17, "Wiener Strasse", 3,180,14,70,200,550,750,950);
		 Feld Gemeinschaftsfeld1 = new Aktionsfeld (18, "Gemeinschaftsfeld", "aktion", this);		 
		 Feld Berliner = new Street (19, "Berliner Strasse", 3,200,16,80,220,600,800,1000);
		 Feld FreiParken = new Feld (20, "Frei Parken", "freiParken");
		 Feld Theater = new Street (21, "Theaterstrasse", 4,220,18,90,250,700,875,1050);
		 Feld Ereignisfeld3 = new Aktionsfeld (22, "Ereignisfeld", "aktion", this);
		 Feld Museum = new Street (23, "Museumsstrasse", 4,220,18,90,250,700,875,1050);
		 Feld Opernplatz = new Street (24, "Opernplatz", 4,240,20,100,300,750,925,1100);
		 Feld Nordbahnhof = new Street (25, "Nordbahnhof", "bahnhof");
		 Feld Lessing = new Street (26, "Lessingstrasse", 5,260,22,110,330,800,975,1150);
		 Feld Schiller = new Street (27, "Schillerstrasse", 5,260,22,110,330,800,975,1150);
		 Feld Wasserwerk = new Street (28, "Wasserwerk", "werk");
		 Feld Goethe = new Street (29, "Goethestrasse", 5,280,24,120,360,850,1025,1200);
		 Feld GeheInsGefaengnis = new Feld (30, "Gehe ins Gefaengnis!", "geheGefaengnis");
		 Feld Rathausplatz = new Street (31, "Rathausplatz", 6,300,26,130,390,900,1100,1275);
		 Feld Haupt = new Street (32, "Hauptstrasse", 6,300,26,130,390,900,1100,1275);
		 Feld Gemeinschaftsfeld2 = new Aktionsfeld (33, "Gemeinschaftsfeld", "aktion", this);
		 Feld Bahnhof = new Street (34, "Bahnhofsstrasse", 6,320,28,150,450,1100,1200,1400);
		 Feld Hauptbahnhof = new Street (35, "Hauptbahnhof", "bahnhof");
		 Feld Ereignisfeld4 = new Aktionsfeld(36, "Ereignisfeld", "aktion", this);
		 Feld Park = new Street (37, "Parkstrasse", 7,350,35,175,500,1100,1300,1500);
		 Feld Zusatzsteuer = new Aktionsfeld (38, "Zusatzsteuer", "aktion", this);
		 Feld Schlossallee = new Street (39, "Schlossallee", 7,400,50,200,600,1400,1700,2000);
		 
		 Feld[] fields = {Los, Bad, Ereignisfeld1, Turm, Einkommenssteuer, Suedbahnhof, Chausse, Ereignisfeld2, Elisen, 
					Post, Gefaengnis, See,Elektrizitaetswerk,Hafen,Neue,Westbahnhof,Muenchener,Wiener,Gemeinschaftsfeld1,
					Berliner,FreiParken,Theater,Ereignisfeld3,Museum,Opernplatz,Nordbahnhof,Lessing,Schiller,Wasserwerk,
					Goethe,GeheInsGefaengnis,Rathausplatz,Haupt,Gemeinschaftsfeld2,Bahnhof,Hauptbahnhof,Ereignisfeld4,
					Park,Zusatzsteuer, Schlossallee};
		 
		 //Felder in ArrayList einfuegen
		 for(Feld f : fields){
			 this.fields.add(f);
		 }
	}
	
	public static int getGameId (){
		return gameId++;
	}
	
	/**
	 *  Startet die Runde des naechsten Spielers
	 * 
	 */
	public void nextPlayer(){
		//current Player ID hochsetzen
		currentPlayerId++;
		
		//Wenn groesser als Laenge des Liste, wieder auf 0 (1. Spieler) setzen
		if(currentPlayerId == players.size()){
			currentPlayerId = 0;
		}
		//Userstate des Spielers aendern
		players.get(currentPlayerId).setUserState(0);
		
		//Falls Spieler schon verloren hat, diesen ueberspringen
		if(players.get(currentPlayerId).getHasLost()){
			players.get(currentPlayerId).setUserState(-1);
			
			//Pruefen ob mindesten 1 Spieler noch nicht verloren hat
			boolean playingPlayers = false;
			for(Spieler p : players){
				if(p.hasLost == false){
					playingPlayers = true;
				}
			}
			
			//Wenn noch spielende Spieler da sind, naechster Spieler auswaehlen
			if(playingPlayers){
				nextPlayer();
			}
		}
	}
	
	
	public int getNewPlayerId(){
		System.out.println("PlayerId: " + playerId);
		return playerId++;
	}
	
	public Monopoly(){
		this.erstelleStrassen();
		
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCurrentPlayerId() {
		return currentPlayerId;
	}
	public void setCurrentPlayerId(int currentPlayerId) {
		this.currentPlayerId = currentPlayerId;
	}
	public ArrayList<Spieler> getPlayers() {
		return players;
	}
	public void setPlayers(ArrayList<Spieler> players) {
		this.players = players;
	}
	public ArrayList<Feld> getFields() {
		return fields;
	}
	public void setFields(ArrayList<Feld> fields) {
		this.fields = fields;
	}
	
	public boolean getIsRunning(){
		return isRunning;
	}
	
	public boolean isRunning() {
		return isRunning;
	}
	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}
}
