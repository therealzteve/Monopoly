package monopoly;

public class Street extends Feld {
 Spieler owner;
 int [] miete = new int [6];
 int preis;
 int stufe;
 int preisHaus;
 int preisHotel;
 Monopoly monopoly;
 
public Street (int id, String name, String typ){
	
	this.id = id;
	this.name = name;
	this.typ = typ;
	if (typ == "bahnhof"){
		this.preis = 150;
		
	}
	else if (typ == "werk"){
		this.preis = 100;
		
	}
}
public Street (int id, String name, int kaufPreis, int miete, int mieteHaus, int mieteHaus2, int mieteHaus3, int mieteHaus4, int mieteHotel){
	 super();
	 this.id = id;
	 this.typ = "street";
	 this.name = name;
	 this.preis = kaufPreis;
	 this.miete[0] = miete;
	 this.miete[1] = mieteHaus;
	 this.miete[2] = mieteHaus2;
	 this.miete[3] = mieteHaus3;
	 this.miete[4] = mieteHaus4;
	 this.miete[5] = mieteHotel;
	 this.stufe = 0;	
	 if (id > 0 & id < 10){
		 this.preisHaus = 50;
		 this.preisHotel = 75;
	 }
	 else if(id > 10 & id < 20){
		 this.preisHaus = 100;
		 this.preisHotel = 150;
	 }
	 else if (id > 20 & id < 30){
		 this.preisHaus = 150;
		 this.preisHotel = 200;
	 }
	 else {
		 this.preisHaus = 200;
		 this.preisHotel = 300;
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

public int getCurrentMiete(){
	return this.miete[this.stufe];
}

public int getPrice() {
	return preis;
}

public void setPrice(int preis) {
	this.preis = preis;
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
