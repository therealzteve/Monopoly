package monopoly;

public class Street extends Feld {
 Spieler owner;
 int id;
 int [] miete = new int [5];
 int price;
 int stufe;
 String name;
 
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
//Baupreis!
public Street (int id, String name, int kaufPreis, int miete, int mieteHaus, int mieteHaus2, int mieteHaus3, int mieteHaus4, int mieteHotel, int stufe){
	 super();
	 this.name = name;
	 this.price = kaufPreis;
	 this.miete[0] = miete;
	 this.miete[1] = mieteHaus;
	 this.miete[2] = mieteHaus2;
	 this.miete[3] = mieteHaus3;
	 this.miete[4] = mieteHaus4;
	 this.miete[5] = mieteHotel;
	 this.stufe = stufe;	
	 
 }
}
