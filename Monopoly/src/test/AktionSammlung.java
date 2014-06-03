package test;

import java.util.ArrayList;

public class AktionSammlung {

	
	ArrayList<Aktion> meineAktionen;
	
	public void machIrgendwas(){
		
		Aktion1 a = new Aktion1();
		
		meineAktionen.add(a);
		
		
		meineAktionen.get(0).fuehreAktionAus();
	}
}
