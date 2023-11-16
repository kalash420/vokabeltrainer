import java.io.*;

/**
 * Die Klasse Kasten stellt Objekte bereit, welches fünf Fächer beinhaltet,
 * indem die Vokabel einer Sprache gespeichert werden. Der Kasten führt auch
 * die eigentliche Abfrage aus.
 * 
 * @author Henning Ainödhofer
 * @version 16.07.2015
 */
public class Kasten
{
    /**
     * Array zum Speichern der Kastenfächer.
     */
    private Kastenfach [] faecher;

    /**
     * Wahrheitswert zur Steuerung der Abfrage.
     */
    private boolean abfrageBeenden;

    /**
     * Konstruktor der Klasse Kaste. Hier wird das Array Kasenfach erzeugt und
     * initialisiert. Vorgegeben sind 5 Kastenfächer. Außerdem wird der Wahrheitswert
     * zum Attribut abfrageBeenden auf false gesetzt.
     */
    public Kasten()
    {
        faecher = new Kastenfach[5];
        faecher[0] = new Kastenfach();
        faecher[1] = new Kastenfach();
        faecher[2] = new Kastenfach();
        faecher[3] = new Kastenfach();
        faecher[4] = new Kastenfach();
        abfrageBeenden = false;
    }

    /**
     * Gibt das Kastenfach mit dem übergebenen Index zurück.
     * @return Kastenfach
     */
    public Kastenfach gibKastenfach(int i)
    {
        return faecher[i];
    }

    /**
     * fügt eine übergebene Vokabel dem übergebenen Kastenfach hinzu. (Delegation)
     */
    public void fuegeVokabelKastenfachHinzu(Vokabel vokabel, int fach)
    {
        faecher[fach].haengeVokabelAn(vokabel);
    }

    /**
     * fügt eine übergebene Vokabel dem ersten Kastenfach hinzu. (Delegation)
     */
    public void fuegeVokabeldemErstenKastenfachHinzu(Vokabel vokabel)
    {
        faecher[0].haengeVokabelAn(vokabel);
    }

    /**
     * Diese Methode gibt die erste Vokabel des Kastens mit der übergebenen Nummer zurück.
     * 
     * @return Vokabel
     */
    private Vokabel gibVokabel(int fachindex)
    {
        return faecher[fachindex].gibErsteVokabel();
    }

    /**
     * startet die Abfrage. Diese Methode läuft solange, bis das Attribut abfrageBeenden auf
     * true gesetzt wird.
     */
    public void abfrageStarten() throws IOException
    {
        int indexAktuellerKasten = gibKleinstesKastenfachMitVokabeln();
        int zaehler = 0;
        InputStreamReader isr = new InputStreamReader(System.in); // Eingabestrom von Eingaben auf der Tastatur 
        BufferedReader br = new BufferedReader(isr); // Lesen der Eingaben von der Tastatur
        System.out.println("!!! Achtung, die Abfrage startet !!!");
        System.out.println("!!! Nach 10 Vokabeln habe Sie die Möglichkeit den Trainer zu beenden !!!");
        System.out.println("!!! Viel Erfolg !!!");
        while(abfrageBeenden != true && indexAktuellerKasten != -1)
        {
            System.out.println("------------------------------------");
            System.out.println("Vokabel: "+gibVokabel(indexAktuellerKasten).gibVokabel());
            System.out.print("Uebersetzung: ");
            String eingabe = br.readLine();

            if(eingabe.equalsIgnoreCase(gibVokabel(indexAktuellerKasten).gibUebersetzung()))
            {
                System.out.println(":-) Das war richtig, super! :-)");
                // Verschiebe die Vokabel in den nächsten Kasten. Wenn es schon der letzte ist, dann ans Ende des selbigen.
                Vokabel aktuell = gibVokabel(indexAktuellerKasten);
                vokabelLoeschen(aktuell);
                if(indexAktuellerKasten == 4)
                {
                    fuegeVokabelKastenfachHinzu(aktuell, 4);
                }
                else
                {
                    fuegeVokabelKastenfachHinzu(aktuell, indexAktuellerKasten+1);
                }
            }
            else
            {
                System.out.println(":-( Leider falsch! Hoffentlich beim nächsten Mal! :-(");
                System.out.println("Richtig wäre "+gibVokabel(indexAktuellerKasten).gibUebersetzung()+" gewesen");
                // Verschiebe die Vokabel an das Ende des ersten Kastens.
                Vokabel aktuell = gibVokabel(indexAktuellerKasten);
                vokabelLoeschen(aktuell);
                fuegeVokabeldemErstenKastenfachHinzu(aktuell);
            }

            indexAktuellerKasten = gibKleinstesKastenfachMitVokabeln();

            zaehler = zaehler + 1;
            if(zaehler == 10)
            {
                zaehler = 0;
                System.out.println("Möchten Sie die Abfrage beenden?");
                eingabe = br.readLine();
                if(eingabe.equalsIgnoreCase("ja"))
                {
                    abfrageBeenden = true;
                }
            }
            
        }
        System.out.println("Auf Wiedersehen!");
    }

    /**
     * löscht eine übergebene Vokabel aus dem Kasten. Dazu durchläuft eine Schleife den
     * gesamten Kasten und ruft in jedem Kastenfach die Methode loescheVokabel auf. (Delegation)
     */
    public void vokabelLoeschen(Vokabel vokabel)
    {
        for (int i = 0; i < faecher.length; i++)
        {
            if(!faecher[i].istLeer())
            {
                faecher[i].loescheVokabel(vokabel);
            }
        }
    }

    /**
     * sucht aus allen Kastenfächern dasjenige heraus, welches als erstes Vokabeln besitzt. 
     * Es wird der Index des Kastenfaches zurückgegeben. Ist in keinem Fach eine
     * Vokabel, gibt die Methode -1 zurück.
     * 
     * @return Kleinste FachID, in der noch Vokabeln vorhanden sind.
     */
    private int gibKleinstesKastenfachMitVokabeln()
    {
        for(int i = 0; i < faecher.length; i++)
        {
            if(!faecher[i].istLeer())
            {
                return i;
            }
        }
        return -1;
    }
}
