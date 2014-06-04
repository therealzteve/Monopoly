package monopoly;

public interface Aktion {
	
	String KartenText;
	
	void Funktion aktion
	static SonderKarten a = new SonderKarten(40,"ZAHLE EINE STRAFE VON € 10 ODER NIMM EINE EREIGNISKARTE.", -10);
	static SonderKarten b = new SonderKarten(41,"DU HAST DEN 2. PREIS IN EINER SCHÖNHEITSKONKURRENZ GEWONNEN. ZIEHE € 10 EIN.", 10);
	static SonderKarten c = new SonderKarten(42,"AUS LAGERVERKÄUFEN ERHÄLTST DU: € 50", 50);
	static SonderKarten d = new SonderKarten(43,"DU ERBST: € 100", 100);
	static SonderKarten e = new SonderKarten(44,"DIE JAHRESRENTE WIRD FALLIG. ZIEHE € 100 EIN.", 100);
	static SonderKarten f = new SonderKarten(45,"ES IST DEIN GEBURTSTAG. ZIEHE VON JEDEM SPIELER € 10 EIN.", 0);
	static SonderKarten g = new SonderKarten(46,"BANK-IRRTUM ZU DEINEN GUNSTEN. ZIEHE € 200 EIN.", 200);
	static SonderKarten h = new SonderKarten(47,"EINKOMMENSTEUER-RÜCKZAHLUNG. ZIEHE € 20 EIN.", 20);
	static SonderKarten i = new SonderKarten(48,"ARZT KOSTEN. ZAHLE: € 50", -50);
	static SonderKarten j = new SonderKarten(49,"DU KOMMST AUS DEM GEFÄNGNIS FREI. Diese Karte musst du behalten, bis du sie benötigst oder verkaufst.", 0);
	static SonderKarten k = new SonderKarten(50,"RÜCKE VOR BIS ZUM NÄCHSTEN BAHNHOF. DER EIGENTÜMER ERHÄLT DAS DOPPELTE DER NORMALEN MIETE. HAT NOCH KEIN SPIELER EINEN BESITZANSPRUCH AUF DIESEN BAHNHOF, SO KANNST DU IHN VON DER BANK KAUFEN.", 0);
	static SonderKarten l = new SonderKarten(51,"DU ERHÄLTST AUF VORZUGS-AKTIEN 7 % DIVIDENDE: € 25", 25);
	static SonderKarten m = new SonderKarten(52,"RÜCKE VOR BIS AUF LOS.", 0);
	static SonderKarten n = new SonderKarten(53,"GEHE ZURÜCK ZUR BADSTRASSE.", 0);
	static SonderKarten o = new SonderKarten(54,"GEHE IN DAS GEFÄNGNIS! BEGIB DICH DIREKT DORTHIN. GEHE NICHT ÜBER LOS. ZIEHE NICHT € 200 EIN.", 0);
	static SonderKarten p = new SonderKarten(55,"ZAHLE AN DAS KRANKENHAUS: € 100", -100);
	static SonderKarten [] gemeinschaftsKarten = {a,b,c,d,e,g,h,i,l,p,f,j,k,m,n,o};

	static SonderKarten aa = new SonderKarten(60,"STRAFE FÜR ZU SCHNELLES FAHREN: €15", -15);
	static SonderKarten bb = new SonderKarten(61,"DU HAST IN EINEM KREUZWORTRÄTSELWETTBEWERB GEWONNEN. ZIEHE € 100 EIN.", 100);
	static SonderKarten cc = new SonderKarten(62,"RÜCKE VOR BIS ZUM OPERNPLATZ. WENN DU ÜBER LOS KOMMST ZIEHE € 200 EIN.", 0);
	static SonderKarten dd = new SonderKarten(63,"DU WIRST ZU STRASSENAUSBESSERUNGS­ARBEITEN HERANGEZOGEN. ZAHLE FÜR DEINE HÄUSER UND HOTELS € 40 JE HAUS € 115 JE HOTEL AN DIE BANK.", 0);
	static SonderKarten ee = new SonderKarten(64,"GEHE IN DAS GEFÄNGNIS! BEGIB DICH DIREKT DORTHIN. GEHE NICHT ÜBER LOS. ZIEHE NICHT € 200 EIN.", 0);
	static SonderKarten ff = new SonderKarten(65,"ZAHLE SCHULGELD: € 150", -150);
	static SonderKarten gg = new SonderKarten(66,"RÜCKE VOR BIS ZUR SCHLOSSALLEE.", 0);
	static SonderKarten hh = new SonderKarten(67,"MIETE UND ANLEIHEZINSEN WERDEN FÄLLIG. DIE BANK ZAHLT DIR € 150", 150);
	static SonderKarten ii = new SonderKarten(68,"RÜCKE VOR BIS ZUR SEESTRASSE. WENN DU ÜBER LOS KOMMST ZIEHE € 200 EIN.", 0);
	static SonderKarten jj = new SonderKarten(69,"DU BIST ZUM VORSTAND GEWÄHLT WORDEN. ZAHLE JEDEM SPIELER € 50", 0);
	static SonderKarten kk = new SonderKarten(70,"RÜCKE VOR BIS AUF LOS.", 0);
	static SonderKarten ll = new SonderKarten(71,"DIE BANK ZAHLT DIR EINE DIVIDENDE: € 50", 50);
	static SonderKarten mm = new SonderKarten(72,"LASSE ALLE DEINE HÄUSER RENOVIEREN! ZAHLE AN DIE BANK: FÜR JEDES HAUS € 25 FÜR JEDES HOTEL € 100", 0);
	static SonderKarten nn = new SonderKarten(73,"MACHE EINEN AUSFLUG ZUM SÜDBAHNHOF. WENN DU ÜBER LOS KOMMST ZIEHE € 200 EIN.", 0);
	static SonderKarten oo = new SonderKarten(74,"DU KOMMST AUS DEM GEFÄNGNIS FREI. Diese Karte musst du behalten, bis du sie benötigst oder verkaufst.", 0);
	static SonderKarten pp = new SonderKarten(75,"GEHE 3 FELDER ZURÜCK.", 0);
	static SonderKarten [] ereignisKarten = {aa,bb,ff,hh,ll,cc,dd,ee,gg,ii,jj,kk,mm,nn,oo,pp};
}
