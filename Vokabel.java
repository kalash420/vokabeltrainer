/**
 * Die Klasse Vokabel stellt Objekte bereit, die Vokabelkarten darstellen sollen. Gespeichert werden
 * die Vokabel und deren Uebersetzung.
 * 
 * @author Henning Ainödhofer
 * @version 16.07.2015
 */
public class Vokabel
{
    /**
     * Attribut zum Speichern der Vokabel.
     */
    private String vokabel;
    
    /**
     * Attribut zum Speichern der Uebersetzung.
     */
    private String uebersetzung;
    
    /**
     * Konstruktor der Klasse Vokabel. Hier werden die uebergebenen Werte den Attributen zugewiesen.
     */
    public Vokabel (String vokabel, String uebersetzung)
    {
        this.vokabel = vokabel;
        this.uebersetzung = uebersetzung;
    }
    
    /**
     * Gibt den Attributwert vom Attribut Vokabel zurück.
     */
    public String gibVokabel()
    {
        return vokabel;
    }
    
    /**
     * Gibt den Attributwert vom Attribut Uebersetzung zurück.
     */
    public String gibUebersetzung()
    {
        return uebersetzung;
    }
}
