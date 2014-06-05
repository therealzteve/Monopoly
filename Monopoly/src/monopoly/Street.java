package monopoly;

public class Street extends Feld {
 Spieler owner;
 int id;
 int [] miete = new int [5];
 int price;
 int stufe;
 String name;
 int preisHaus;
 int preisHotel;
 String typ;
 
//Baupreis!, Konstruktor mit strasse übergeben
public Street (int id, String name, int kaufPreis, int miete, int mieteHaus, int mieteHaus2, int mieteHaus3, int mieteHaus4, int mieteHotel){
	 super();
	 this.typ = "street";
	 this.name = name;
	 this.price = kaufPreis;
	 this.miete[0] = miete;
	 this.miete[1] = mieteHaus;
	 this.miete[2] = mieteHaus2;
	 this.miete[3] = mieteHaus3;
	 this.miete[4] = mieteHaus4;
	 this.miete[5] = mieteHotel;
	 this.stufe = 0;	
	 if (id > 0 & id < 10){
		 this.preisHaus = 200;
		 this.preisHotel = 300;
	 }
	 else if(id > 10 & id < 20){
		 this.preisHaus = 300;
		 this.preisHotel = 400;
	 }
	 else if (id > 20 & id < 30){
		 this.preisHaus = 400;
		 this.preisHotel = 500;
	 }
	 else {
		 this.preisHaus = 500;
		 this.preisHotel = 600;
	 }
	 
	 
 }
public Spieler getOwner() {
	return owner;
}

public void setOwner(Spieler owner) {
	this.owner = owner;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public int[] getMiete() {
	return miete;
}

public void setMiete(int[] miete) {
	this.miete = miete;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}

public int getStufe() {
	return stufe;
}

public void setStufe(int stufe) {
	this.stufe = stufe;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}
}
