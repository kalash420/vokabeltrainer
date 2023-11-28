import java.io.*;
/**
 * Die Klasse Sprache stellt Objekte bereit, um verschiedene Sprachen im Vokabeltrainer zu verwalten.
 * 
 * @author Henning Ainödhofer
 * @version 16.07.2015
 */
public class Sprache
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    /**
     * Bezeichner der Sprache: bspw. Englisch
     */
    private String bezeichnung;
   
    /**
     * Verweis auf den Kasten für die Vokabeln die zur Sprache gehören
     */
    private Kasten kasten;

    /**
     * Konstruktor für Objekte der Klasse Sprache. Hier wird ein neuer Kasten angelegt und der
     * übergebene Bezeichner gesetzt.
     */
    public Sprache(String bezeichnung)
    {
        kasten = new Kasten();
        this.bezeichnung = bezeichnung;
    }
    
    /**
     * Gibt den Attributwert vom Attribut Bezeichner zurück.
     */
    public String gibBezeichnung()
    {
        return bezeichnung;
    }
    
    /**
     * fügt eine übergebene Vokabel dem Kasten hinzu. (Delegation)
     */
    public void vokabelEintragen(Vokabel vokabel)
    {
        kasten.fuegeVokabeldemErstenKastenfachHinzu(vokabel);
    }
    
    /**
     * löscht eine übergebe Vokabel aus dem Kasten. (Delegation)
     */
    public void vokabelLoeschen(Vokabel vokabel)
    {
        kasten.vokabelLoeschen(vokabel);
    }
    
    /**
     * startet die Abfrage auf dem Kasten. (Delegation)
     */
    public void abfrageStarten() throws IOException
    {
        kasten.abfrageStarten();
    }
    
    public Kasten gibKasten()
    {
        return kasten;
    }
}
