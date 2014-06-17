package monopoly;

import java.util.ArrayList;
import java.util.List;

public class Spieler {
	int id;
	String name;
	int guthaben;
	boolean isAdmin;
	String icon;
	int position;
	int userState = -1; //Gibt an, ob Spieler am Zug ist, wuerfeln muss, oder Zug beenden muss
	ArrayList<Street> ownedStreets = new ArrayList<Street>();
	Monopoly monopoly;
	boolean hasLost; //True, wenn der Spieler verloren oder aufgegeben hat
	private static int playerId = 0;
	
public Spieler (int id, String name, boolean isAdmin){
	this.guthaben = 2000;
	this.position = 0;
	this.name = name;
	this.isAdmin = isAdmin;
	this.id = id;
}

public static int getPlayerId (){
	return playerId++;
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
	
	this.position = position;
	
	if(this.position >= 40){
		this.position = this.position - 40;
		this.guthaben = this.guthaben +  200;
	}
}

public void addPosition(int position){
	this.setPosition(this.getPosition()+position);
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

public String getIcon() {
	return icon;
}

public void setIcon(String icon) {
	this.icon = icon;
}

public boolean getHasLost() {
	return hasLost;
}

public void setHasLost(boolean hasLost) {
	this.hasLost = hasLost;
}
}
