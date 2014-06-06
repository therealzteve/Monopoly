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
	Monopoly monopoly;
public Spieler (int id, String name, boolean isAdmin){
	this.Guthaben = 2000;
	this.position = 0;
	this.name = name;
	this.isAdmin = isAdmin;
	this.id = id;
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

public int getGuthaben() {
	return Guthaben;
}

public void setGuthaben(int guthaben) {
	Guthaben = guthaben;
}

public boolean isAdmin() {
	return isAdmin;
}

public void setAdmin(boolean isAdmin) {
	this.isAdmin = isAdmin;
}

public int getPosition() {
	return position;
}
public void setSimplePosition (int position) {
	this.position = position;
}
public void setPosition(int position, int i) {
	if (monopoly.players.get(i).getPosition() > position){
		monopoly.players.get(i).setGuthaben(monopoly.players.get(i).getGuthaben() + 200);
	}
	this.position = position;
}

public List getOwnedStreets() {
	return ownedStreets;
}

public void setOwnedStreets(List ownedStreets) {
	this.ownedStreets = ownedStreets;
}
}
