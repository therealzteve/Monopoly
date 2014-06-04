package monopoly;

import java.util.ArrayList;
import java.util.List;

public class Spieler {
	int id;
	String name;
	int Guthaben;
	boolean isAdmin;
	int position;
	List ownedStreets = new ArrayList<Street>();
	
public Spieler (int id, String name, boolean isAdmin){
	this.Guthaben = 2000;
	this.position = 0;
	this.name = name;
	this.isAdmin = isAdmin;
	this.id = id;
}
}
