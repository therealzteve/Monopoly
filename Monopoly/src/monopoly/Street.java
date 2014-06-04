package monopoly;

public class Street extends Feld {
 Spieler owner;
 int id;
 int [] miete = new int [5];
 int price;
 int stufe;
 String name;
 
 public Street (String name, int kaufPreis, int miete, int mieteHaus, int mieteHaus2, int mieteHaus3, int mieteHaus4, int mieteHotel, int stufe,Spieler owner){
	 this.name = name;
	 this.price = kaufPreis;
	 this.miete[0] = miete;
	 this.miete[1] = mieteHaus;
	 this.miete[2] = mieteHaus2;
	 this.miete[3] = mieteHaus3;
	 this.miete[4] = mieteHaus4;
	 this.miete[5] = mieteHotel;
	 this.stufe = stufe;	
	 this.owner = owner;
 }
}
