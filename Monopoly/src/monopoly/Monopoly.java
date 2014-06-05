package monopoly;

import java.util.ArrayList;
import java.util.List;

public class Monopoly {
	int id;
	public ArrayList<Spieler> players = new ArrayList<Spieler>();
	Spieler spieler = new Spieler (id, null, false);
	
	public void spielerHinzufuegen(){
		players.add(spieler);
	}
	public void erstelleStrassen(){
		
	}
	
	static Feld Los = new Feld(0, "Los", "aktion");
	static Feld Bad = new Street(1, "Badstrasse", 60,2,10,30,90,160,250);
	static Feld Ereignisfeld1 =new Aktionsfeld(2, "Ereignisfeld", "aktion");
	static Feld Turm = new Street(3, "Turmstrasse", 60,4,20,60,180,320,450);
	static Feld Einkommenssteuer = new Aktionsfeld(4, "Einkommenssteuer", "aktion");
	static Feld Suedbahnhof = new Bahnhof (5, "Suedbahnhof", "street");
	static Feld Chausse = new Street(6,"Chaussestrasse",100,6,30,90,270,400,550);
	static Feld Ereignisfeld2 = new Aktionsfeld(7, "Ereignisfeld", "aktion");
	static Feld Elisen =new Street (8, "Elisenstrasse",100,6,30,90,270,400,550);
	static Feld Post = new Street(9, "Poststraße",120,8,40,100,300,400,550);
	static Feld Gefaengnis = new Feld (10, "Gefaengnis", "aktion");
	static Feld See = new Street (11, "Seestrasse",140,10,50,150,450,625,750);
	static Feld Elektrizitaetswerk = new Werk (12, "Elektrizitaetswerk", "street");
	static Feld Hafen = new Street (13, "Hafenstrasse", 140,10,50,150,450,625,750);
	static Feld Neue = new Street (14, "Neue Strasse", 160,12,60,180,500,700,900);
	static Feld Westbahnhof = new Bahnhof (15, "Westbahnhof", "street");
	static Feld Muenchener = new Street(16, "Muenchener Strasse", 180,14,70,200,550,750,950);
	static Feld Gemeinschaftsfeld1 = new Aktionsfeld (17, "Gemeinschaftsfeld", "aktion");
	static Feld Wiener = new Street (18, "Wiener Strasse", 180,14,70,200,550,750,950);
	static Feld Berliner = new Street (19, "Berliner Strasse", 200,16,80,220,600,800,1000);
	static Feld FreiParken = new Feld (20, "Frei Parken", "aktion");
	static Feld Theater = new Street (21, "Theaterstrasse", 220,18,90,250,700,875,1050);
	static Feld Ereignisfeld3 = new Aktionsfeld (22, "Ereignisfeld", "aktion");
	static Feld Museum = new Street (23, "Museumsstrasse", 220,18,90,250,700,875,1050);
	static Feld Opernplatz = new Street (24, "Opernplatz", 240,20,100,300,750,925,1100);
	static Feld Nordbahnhof = new Bahnhof (25, "Nordbahnhof", "street");
	static Feld Lessing = new Street (26, "Lessingstrasse", 260,22,110,330,800,975,1150);
	static Feld Schiller = new Street (27, "Schillerstrasse", 260,22,110,330,800,975,1150);
	static Feld Wasserwerk = new Werk (28, "Wasserwerk", "street");
	static Feld Goethe = new Street (29, "Goethestrasse", 280,24,120,360,850,1025,1200);
	static Feld GeheInsGefaengnis = new Feld (30, "Gehe ins Gefaengnis!", "aktion");
	static Feld Rathausplatz = new Street (31, "Rathausplatz", 300,26,130,390,900,1100,1275);
	static Feld Haupt = new Street (32, "Hauptstrasse", 300,26,130,390,900,1100,1275);
	static Feld Gemeinschaftsfeld2 = new Aktionsfeld (33, "Gemeinschaftsfeld", "aktion");
	static Feld Bahnhof = new Street (34, "Bahnhofsstrasse", 320,28,150,450,1100,1200,1400);
	static Feld Hauptbahnhof = new Bahnhof (35, "Hauptbahnhof", "street");
	static Feld Ereignisfeld4 = new Aktionsfeld(36, "Ereignisfeld", "aktion");
	static Feld Park = new Street (37, "Parkstrasse", 350,35,175,500,1100,1300,1500);
	static Feld Zusatzsteuer = new Feld (38, "Zusatzsteuer", "aktion");
	static Feld Schlossallee = new Street (39, "Schlossallee", 400,50,200,600,1400,1700,2000);
	
	static Feld[] fields = {Los, Bad, Ereignisfeld1, Turm, Einkommenssteuer, Suedbahnhof, Chausse, Ereignisfeld2, Elisen, 
		Post, Gefaengnis, See,Elektrizitaetswerk,Hafen,Neue,Westbahnhof,Muenchener,Gemeinschaftsfeld1,Wiener,
		Berliner,FreiParken,Theater,Ereignisfeld3,Museum,Opernplatz,Nordbahnhof,Lessing,Schiller,Wasserwerke,
		Goethe,GeheInsGefaengnis,Rathausplatz,Haupt,Gemeinschaftsfeld2,Bahnhof,Hauptbahnhof,Ereignisfeld4,
		Park,Zusatzsteuer, Schlossallee};
	
	public Monopoly(){
		this.erstelleStrassen();
		
	}
}
