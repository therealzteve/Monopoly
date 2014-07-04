package monopoly;

/*Interface definiert Methoden für alle Ereignis- und Gemeinschaftsfelderaktionen.
 * 
 */

public interface Aktion {
	public String kartenText = "";
	
	
	public void fuehreAktionAus (int id);
	public String getKartenText ();
		
	
}
