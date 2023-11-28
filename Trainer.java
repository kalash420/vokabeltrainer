import java.io.*;
/**
 * Die Klasse Trainer stellt Objekte bereit, mit denen ein Vokabeltrainer erstellt wird. Dabei kann ein
 * Trainerobjekt mehrere Sprachen verwalten.
 * 
 * @author Henning Ainödhofer
 * @version 16.07.2015
 */
public class Trainer
{
    /**
     * Listobjekt, welches Objekte vom typ Sprache speichern kann.
     */
    private List <Sprache> sprachen;

    /**
     * Konstruktor für Objekte der Klasse Trainer. Hier wird eine Liste erzuegt, die Objekte vom
     * Typ Sprache verwaltet.
     */
    public Trainer()
    {
        sprachen = new List<Sprache>();
        initialisiere();
    }

    private void initialisiere()
    {
        spracheHinzufuegen("Englisch");
        vokabelHinzufuegen("Englisch", new Vokabel("Cat", "Katze"));
        vokabelHinzufuegen("Englisch", new Vokabel("Dog", "Hund"));
        vokabelHinzufuegen("Englisch", new Vokabel("House", "Haus"));
        vokabelHinzufuegen("Englisch", new Vokabel("Lake", "See"));
        vokabelHinzufuegen("Englisch", new Vokabel("Cheese", "Käse"));
        vokabelHinzufuegen("Englisch", new Vokabel("Snow", "Schnee"));
    }

    /**
     * fügt der Liste sprachen eine Sprache mit übergebenen Bezeichner hinzu.
     */
    public void spracheHinzufuegen(String bezeichner)
    {
        sprachen.append(new Sprache(bezeichner));
    }

    /**
     * fügt der passenden Sprache die übergebene Vokabel hinzu. Dazu durchsucht eine Schleife die 
     * Liste sprachen nach der übergebenen Sprache. Ist die Sprache vorhanden, wird die vokabel dem
     * Kasten hinzugefügt. Ist die Sprache nicht vorhanden, passiert nichts.
     */
    public void vokabelHinzufuegen(String sprache, Vokabel vokabel)
    {
        Sprache gefunden = null;
        sprachen.toFirst();
        while(sprachen.hasAccess() && gefunden == null)
        {
            if(sprachen.getContent().gibBezeichnung().equals(sprache))
            {
                gefunden = sprachen.getContent();
            }
            sprachen.next();
        }
        if(gefunden != null)
        {
            gefunden.vokabelEintragen(vokabel);
        }
    }

    /**
     * löscht im Kasten der passenden Sprache die übergebene Vokabel. Dazu durchsucht eine Schleife die 
     * Liste sprachen nach der übergebenen Sprache. Ist die Sprache vorhanden, wird die vokabel im
     * Kasten gelöscht. Ist die Sprache nicht vorhanden, passiert nichts.
     */
    public void vokabelLoeschen(String sprache, Vokabel vokabel)
    {
        Sprache gefunden = null;
        sprachen.toFirst();
        while(sprachen.hasAccess() && gefunden == null)
        {
            if(sprachen.getContent().gibBezeichnung().equals(sprache))
            {
                gefunden = sprachen.getContent();
            }
        }
        if(gefunden != null)
        {
            gefunden.vokabelLoeschen(vokabel);
        }
    }

    /**
     * startet im Kasten der passenden Sprache die Abfrage. Dazu durchsucht eine Schleife die 
     * Liste sprachen nach der übergebenen Sprache. Ist die Sprache vorhanden, wird die Abfrage
     * gestartet. Ist die Sprache nicht vorhanden, passiert nichts.
     */
    public void abfrageStarten(String sprache) throws IOException
    {
        Sprache gefunden = null;
        sprachen.toFirst();
        while(sprachen.hasAccess() && gefunden == null)
        {
            if(sprachen.getContent().gibBezeichnung().equals(sprache))
            {
                gefunden = sprachen.getContent();
            }
        }
        if(gefunden != null)
        {
            gefunden.abfrageStarten();
        }
    }

    /**
     * Erzeugt aufgrund der Eingaben von Vokabel und Übersetzung ein neues Vokabelobjekt und gibt
     * es zurück.
     */
    public Vokabel neueVokabelErzeugen(String vokabel, String uebersetzung)
    {
        return new Vokabel(vokabel, uebersetzung);
    }

    /**
     * Druckt die Prozentzaheln der Vokabeln pro Sprache auf der Konsole
     */
    public void druckeProzentzahlDerVokabelnProKasten()
    {
        sprachen.toFirst();
        int e = 0;
        while(sprachen.hasAccess()){
            Kasten f = sprachen.getContent().gibKasten();
            for(int i = 0; i <= 4; i++){
                Kastenfach akt = f.gibKastenfach(i);
                
                while(vokabeln.hasAccsess()){
                    e= e+1;
                }
            }
        }
        

    }

    /**
     * Gibt die Gesamtzahl an Vokabeln zurück
     * @return Gesamtzahl aller Vokabeln
     */
    public int gibAnzahlVokabelnGesamt()
    {

        
        return 0;
    }

    /**
     * Gibt die gesuchte Vokabel zurück, um sie beispielsweise löschen zu können.
     * @param vok = Vokabel und sprache
     * @return gesuchte Vokabel, ansonsten null
     */
    public Vokabel sucheVokabel(Vokabel vok, String sprache)
    {
        return null;
    }
}
