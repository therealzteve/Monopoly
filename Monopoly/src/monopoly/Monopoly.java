package monopoly;

import java.util.ArrayList;
import java.util.List;

public class Monopoly {
	int id;
	static List players = new ArrayList<Spieler>();
	Spieler spieler = new Spieler (id, null, false);
	
	public void spielerHinzufuegen(){
		players.add(spieler);
	}
	
	static Feld Los = new Feld(0, "Los", "aktion");
	static Feld Bad = new Feld(1, "Badstrasse", "street");
	static Feld Ereignisfeld1 =new Feld(2, "Ereignisfeld", "aktion");
	static Feld Turm = new Street(3, "Turmstrasse", 1,2,3,4,5, 6, 7, 8);
	static Feld Einkommenssteuer = new Feld(4, "Einkommenssteuer", "aktion");
	static Feld Suedbahnhof = new Feld (5, "Suedbahnhof", "street");
	static Feld Chausse = new Feld(6,"Chaussestrasse", "street");
	static Feld Ereignisfeld2 = new Feld(7, "Ereignisfeld", "aktion");
	static Feld Elisen =new Feld (8, "Elisenstrasse", "aktion");
	static Feld Post = new Feld(9, "Poststraße", "street");
	static Feld Gefaengnis = new Feld (10, "Gefaengnis", "aktion");
	static Feld See = new Feld (11, "Seestrasse","street");
	static Feld Elektrizitaetswerk = new Feld (12, "Elektrizitaetswerk", "street");
	static Feld Hafen = new Feld (13, "Hafenstrasse", "street");
	static Feld Neue = new Feld (14, "Neue Strasse", "street");
	static Feld Westbahnhof = new Feld (15, "Westbahnhof", "street");
	static Feld Muenchener = new Feld(16, "Muenchener Strasse", "street");
	static Feld Gemeinschaftsfeld1 = new Feld (17, "Gemeinschaftsfeld", "aktion");
	static Feld Wiener = new Feld (18, "Wiener Strasse", "street");
	static Feld Berliner = new Feld (19, "Berliner Strasse", "street");
	static Feld FreiParken = new Feld (20, "Frei Parken", "aktion");
	static Feld Theater = new Feld (21, "Theaterstrasse", "street");
	static Feld Ereignisfeld3 = new Feld (22, "Ereignisfeld", "aktion");
	static Feld Museum = new Feld (23, "Museumsstrasse", "street");
	static Feld Opernplatz = new Feld (24, "Opernplatz", "street");
	static Feld Nordbahnhof = new Feld (25, "Nordbahnhof", "street");
	static Feld Lessing = new Feld (26, "Lessingstrasse", "street");
	static Feld Schiller = new Feld (27, "Schillerstrasse", "street");
	static Feld Wasserwerke = new Feld (28, "Wasserwerke", "street");
	static Feld Goethe = new Feld (29, "Goethestrasse", "street");
	static Feld GeheInsGefaengnis = new Feld (30, "Gehe ins Gefaengnis!", "aktion");
	static Feld Rathausplatz = new Feld (31, "Rathausplatz", "street");
	static Feld Haupt = new Feld (32, "Hauptstrasse", "street");
	static Feld Gemeinschaftsfeld2 = new Feld (33, "Gemeinschaftsfeld", "aktion");
	static Feld Bahnhof = new Feld (34, "Bahnhofsstrasse", "street");
	static Feld Hauptbahnhof = new Feld (35, "Hauptbahnhof", "street");
	static Feld Ereignisfeld4 = new Feld(36, "Ereignisfeld", "aktion");
	static Feld Park = new Feld (37, "Parkstrasse", "street");
	static Feld Zusatzsteuer = new Feld (38, "Zusatzsteuer", "aktion");
	static Feld Schlossallee = new Feld (39, "Schlossallee", "street");
	
	static Feld[] fields = {Los, Bad, Ereignisfeld1, Turm, Einkommenssteuer, Suedbahnhof, Chausse, Ereignisfeld2, Elisen, 
		Post, Gefaengnis, See,Elektrizitaetswerk,Hafen,Neue,Westbahnhof,Muenchener,Gemeinschaftsfeld1,Wiener,
		Berliner,FreiParken,Theater,Ereignisfeld3,Museum,Opernplatz,Nordbahnhof,Lessing,Schiller,Wasserwerke,
		Goethe,GeheInsGefaengnis,Rathausplatz,Haupt,Gemeinschaftsfeld2,Bahnhof,Hauptbahnhof,Ereignisfeld4,
		Park,Zusatzsteuer, Schlossallee};
}
