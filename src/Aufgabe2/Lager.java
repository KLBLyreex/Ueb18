package Aufgabe2;

/**
 * Die Klasse Lager gibt die Möglichkeit, Artikel zu speichern und zu verwalten.
 *
 * @author Jan Ehrhardt / Aaron Betzholz
 * @version 27.05.2019
 */
public class Lager {

    private Artikel[] lager;
    private Artikel[] lagerNew;
    private int zeiger;
    private String lagerort;

    private static final String ERROR_LAGER_LEER = "Das Lager ist noch leer!";
    private static final String ERROR_KEIN_LAGER = "Es wurde noch kein Lager angelegt!";
    private static final String ERROR_LAGER_VOLL = "Es können keine weiteren Artikel gespeichert werden! Lager voll!";
    private static final String ERROR_ARTIKEL_NICHT_VORHANDEN = "Artikel ist im Lager nicht vorhanden!";
    private static final String ERROR_ARTIKEL_ID_VORHANDEN = "Die Artikelnummer ist bereits vergeben!";
    private static final String ERROR_NEUE_LAGER_GROESSE = "Das neue Lager muss groesser sein, als das Alte!";

    /**
     * Konstruktor Lager legt ein neus Lager mit der Groesse groesse an und setzt den zeiger auf 0.
     *
     * @param groesse Integer Wert, legt die Groesse des Lagers fest
     */
    public Lager(int groesse, String lagerort) {
        lager = new Artikel[groesse];
        this.lagerort = lagerort;
        zeiger = 0;
    }

    /**
     * Methode addArtikel fügt einen Artikel zum Lager hinzu
     *
     * @param artikel Artikel von Dialog/Nutzer übergeben
     */
    public void addArtikel(Artikel artikel) {
        Validator.check(lager == null, ERROR_KEIN_LAGER);
        Validator.check(zeiger >= lager.length, ERROR_LAGER_VOLL);
        Validator.check(doSearchNewArt(artikel.getNummer()) != -1, ERROR_ARTIKEL_ID_VORHANDEN);
        lager[zeiger] = artikel;
        zeiger++;
    }

    /**
     * Methode deleteArtikel loescht ein Artikel anhand der Artikelnummer, ohne dass eine Luecke im Lager entsteht.
     *
     * @param artikel Integer-Wert, Artikelnummer, des zu loeschenden Artikels
     */
    public void deleteArtikel(int artikel) {
        int stelle = doSearch(artikel);
        if (stelle == zeiger - 1) {
            zeiger--;
        } else {
            for (int i = stelle; i < zeiger; i++) {
                if (i + 1 < lager.length) {
                    lager[i] = lager[i + 1];
                }
            }
            zeiger--;
        }
    }

    /**
     * Methode abgangBuchen bucht einen Artikelabgang anhand der Artikelnummer
     *
     * @param artikel Artikelnummer, INTEGER
     * @param anzahl  Aenderungswert, INTEGER
     */
    public void abgangBuchen(int artikel, int anzahl) {
        int stelle = doSearch(artikel);
        lager[stelle].bucheAbgang(anzahl);
    }

    /**
     * Methode abgangBuchen bucht einen Artikelzugang anhand der Artikelnummer
     *
     * @param artikel Artikelnummer, INTEGER
     * @param anzahl  Aenderungswert, INTEGER
     */
    public void zugangBuchen(int artikel, int anzahl) {
        int stelle = doSearch(artikel);
        lager[stelle].bucheZugang(anzahl);
    }

    /**
     * Methode preisKorrektur aendert die Preise aller Artikel im Lager um einen mitgegebenen Prozentsatz
     *
     * @param prozentsatz double-Wert, positiver oder negativer Prozentsatz (z.B. 0,5)
     */
    public void preisKorrektur(double prozentsatz) {
        double preis;
        for (int i = 0; i < zeiger; i++) {
            preis = lager[i].getArtikelPreis();
            preis = preis + (preis * prozentsatz);
            lager[i].setPreis(preis);
        }
    }

    /**
     * Methode doAusgabe gibt das Lager als String aus, dabei wird ueberprueft, ob Artikel im Lager vorhanden sind
     *
     * @return Inhalt des Lagers als STRING
     */
    public String doAusgabe() {
        Validator.check(zeiger == 0, ERROR_LAGER_LEER);
        String ausgabe = "";
        ausgabe += "Lagerort: " + lagerort + "\n\n";
        ausgabe += "ArtNr \t Beschreibung \t Preis \t Bestand \t Gesamt \n";
        ausgabe += "---------------------------------------------\n";
        for (int i = 0; i < zeiger; i++) {
            ausgabe += lager[i].toString() + "\n";
        }
        ausgabe += "---------------------------------------------\n";
        ausgabe += "\t\t\t\t\t Gesamtwert: " + getGesamtwert() + "\n";
        return ausgabe + "Lagergroesse: " + lager.length;
    }

    /**
     * Methode lagerErweitern erweitert das Lager um einen angegebenen Wert groesse. Dabei wird das vorhandene Lager in
     * ein groesseres Lager uebertragen und das alte Lager durch das neue ersetzt. Es wird ueberprueft, ob das neue Lager
     * wirklich groesser ist.
     *
     * @param groesse INTEGER, Groesse des neuen Lagers
     */
    public void lagerErweitern(int groesse) {
        Validator.check(groesse <= lager.length, ERROR_NEUE_LAGER_GROESSE);
        lagerNew = new Artikel[groesse];
        for (int i = 0; i < zeiger; i++) {
            lagerNew[i] = lager[i];
        }
        lager = lagerNew;
    }

    /**
     * Methode doSearch  Sucht ein Artikel im Lager anhand der Artikelnummer und gibt die Stelle im Array zurueck.
     * Es wird geprüft, ob der Artikel existiert.
     *
     * @param artikelNummer INTEGER, artikelNummer
     * @return INTEGER, Postition im Array
     */
    private int doSearch(int artikelNummer) {
        int stelle = -1;
        for (int i = 0; i < zeiger; i++) {
            if (lager[i].getNummer() == artikelNummer) {
                stelle = i;
            }
        }
        Validator.check(stelle == -1, ERROR_ARTIKEL_NICHT_VORHANDEN);
        return stelle;
    }

    /**
     * Methode doSearch  Sucht ein Artikel im Lager anhand der Artikelnummer und gibt die Stelle im Array zurueck.
     *
     * @param artikelNummer INTEGER, artikelNummer
     * @return INTEGER, Postition im Array
     */
    private int doSearchNewArt(int artikelNummer) {
        int stelle = -1;
        for (int i = 0; i < zeiger; i++) {
            if (lager[i].getNummer() == artikelNummer) {
                stelle = i;
            }
        }
        return stelle;
    }

    /**
     * Methode getGesamtwert gibt den Gesamtwert, der im Lager gespeicherten Artikel zurueck.
     *
     * @return Gesamtwert der Artikel
     */
    private double getGesamtwert() {
        double gesamtwert = 0;
        for (int i = 0; i < zeiger; i++) {
            gesamtwert += lager[i].getArtikelPreis() * lager[i].getAnzahl();
        }
        return gesamtwert;
    }
}
