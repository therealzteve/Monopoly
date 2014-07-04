package monopoly;

import java.util.ArrayList;
import java.util.Collections;


/*Im Konstruktor werden den jeweiligen Aktionsfeldern id, name und typ zugeordnet.
 * Außerdem wird der Arraylist aktionen die Ereignis- und Gemeinschaftsfelderaktionen zugeordnet und gemischt.
 * 
 * In der Methode "fuehreKarteAus" wird zunächst bestimmt ob die id auf ein Ereignis- und Gemeinschaftsfeld hinweist 
 * oder auf eine der anderen Aktionsfelder.
 * Je nachdem wird eine Aktion ausgeführt.
 * Ereignis- und Gemeinschaftsfeld: Ziehe das 0-te Element und fügt es an letzter Stelle wieder ein.
 * */

public class Aktionsfeld extends Feld {
	
	Monopoly monopoly;
	ArrayList<Aktion> aktionen = new ArrayList<Aktion>();
	
	
	public Aktionsfeld (int id, String name, String typ, Monopoly monopoly){
		this.id = id;
		this.name = name;
		this.typ = typ;
		this.monopoly = monopoly;
		
		
		aktionen.add(new GK1(monopoly));
		aktionen.add(new GK2(monopoly));
		aktionen.add(new GK3(monopoly));
		aktionen.add(new GK4(monopoly));
		aktionen.add(new GK5(monopoly));
		aktionen.add(new GK6(monopoly));
		aktionen.add(new GK7(monopoly));
		aktionen.add(new GK8(monopoly));
		aktionen.add(new GK9(monopoly));
		aktionen.add(new GK11(monopoly));
		aktionen.add(new GK12(monopoly));
		aktionen.add(new GK13(monopoly));
		aktionen.add(new GK14(monopoly));
		aktionen.add(new GK15(monopoly));
		aktionen.add(new GK16(monopoly));
		aktionen.add(new GK17(monopoly));
		aktionen.add(new GK18(monopoly));
		aktionen.add(new GK19(monopoly));
		aktionen.add(new GK20(monopoly));
		aktionen.add(new GK21(monopoly));
		aktionen.add(new GK22(monopoly));
		aktionen.add(new GK23(monopoly));
		aktionen.add(new GK24(monopoly));
		aktionen.add(new GK25(monopoly));
		aktionen.add(new GK26(monopoly));
		aktionen.add(new GK27(monopoly));
		aktionen.add(new GK28(monopoly));
		aktionen.add(new GK29(monopoly));
		aktionen.add(new GK30(monopoly));
		aktionen.add(new GK31(monopoly));
		aktionen.add(new GK32(monopoly));
		
		Collections.shuffle(aktionen);
	}
	
	public String fuehreKarteAus (int idSpieler){
		if (this.getId() == 2 || this.getId() == 7 || this.getId() == 18 || 
			this.getId() == 22 || this.getId() == 33 || this.getId() == 36){
			aktionen.get(0).fuehreAktionAus(idSpieler);
			String text = aktionen.get(0).getKartenText();
			Aktion hilf = aktionen.get(0);
			aktionen.remove(0);
			aktionen.add(hilf);
			return text;
		}
		else if (this.getId() == 4){
			monopoly.players.get(idSpieler).setGuthaben(monopoly.players.get(idSpieler).getGuthaben() -200);
			return "Einkommenssteuer: Zahle 200!";
		}
		else if (this.getId() == 38){
			monopoly.players.get(idSpieler).setGuthaben(monopoly.players.get(idSpieler).getGuthaben() -100);
			return "Zusatzsteuer: Zahle 100";
		}
		return "";
	}

	

	
}
