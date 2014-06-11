package monopoly;

import java.util.ArrayList;
import java.util.List;

public class Spieler {
	int id;
	String name;
	int guthaben;
	boolean isAdmin;
	int position;
	int userState = -1; //Gibt an, ob Spieler am Zug ist, wuerfeln muss, oder Zug beenden muss
	ArrayList<Street> ownedStreets = new ArrayList<Street>();
	Monopoly monopoly;
	
public Spieler (int id, String name, boolean isAdmin){
	this.guthaben = 2000;
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
	return guthaben;
}

public void setGuthaben(int guthaben) {
	this.guthaben = guthaben;
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
public void setPosition(int position) {
	
	this.position = this.position + position;
	
	if(this.position >= 44){
		this.position = this.position - 44;
		this.guthaben = this.guthaben +  200;
	}
}

public ArrayList<Street> getOwnedStreets() {
	return ownedStreets;
}

public void setOwnedStreets(ArrayList<Street> ownedStreets) {
	this.ownedStreets = ownedStreets;
}

public int getUserState() {
	return userState;
}

public void setUserState(int userState) {
	this.userState = userState;
}
}
