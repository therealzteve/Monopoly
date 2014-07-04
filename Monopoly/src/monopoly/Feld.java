package monopoly;

/*Bietet Grundfunktionen für alle Monopolyfelder.
 * Überklasse von Aktionsfeld und Street.
 */

public class Feld {
	int id;
	String name;
	String typ;
	
public Feld (int id, String name, String typ){
	this.id = id;
	this.name = name;
	this.typ = typ;
}
public Feld (){
	
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getTyp() {
	return typ;
}
public void setTyp(String typ) {
	this.typ = typ;
}


}
