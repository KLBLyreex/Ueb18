package Aufgabe2;

/**
 * Die Klasse Lager gibt die Möglichkeit, Artikel zu speichern und zu verwalten.
 *
 * @author Jan Ehrhardt / Luca Schneider
 * @version 22.01.2019
 */
public class Lager {
    private Artikel[] lager;
    private Artikel[] lagerNew;
    private int zeiger;
    private String lagerort;

    /**
     * Konstruktor Lager legt ein neus Lager mit der Groesse groesse an und setzt den zeiger auf 0.
     * @param groesse Integer Wert, legt die Groesse des Lagers fest
     */
    public Lager(int groesse, String lagerort){
        lager = new Artikel[groesse];
        this.lagerort = lagerort;
        zeiger = 0;
    }

    /**
     * Methode addArtikel fügt einen Artikel zum Lager hinzu
     * @param artikel Artikel von Dialog/Nutzer übergeben
     */
    public void addArtikel(Artikel artikel){
        checkLager();
        checkAdd();
        checkArtikelDouble(artikel);
        lager[zeiger] = artikel;
        zeiger++;
    }

    /**
     * Methode deleteArtikel loescht ein Artikel anhand der Artikelnummer, ohne dass eine Luecke im Lager entsteht.
     * @param artikel Integer-Wert, Artikelnummer, des zu loeschenden Artikels
     */
    public void deleteArtikel(int artikel){
        int stelle = doSearch(artikel);
        if (stelle == zeiger-1){
            zeiger--;
        } else {
        for (int i=stelle; i < zeiger; i++){
            if (i+1 < lager.length){
                lager[i]=lager[i+1];
            }
        }
        zeiger--;
        }
    }

    /**
     * Methode abgangBuchen bucht einen Artikelabgang anhand der Artikelnummer
     * @param artikel Artikelnummer, INTEGER
     * @param anzahl  Aenderungswert, INTEGER
     */
    public void abgangBuchen(int artikel, int anzahl){
        int stelle = doSearch(artikel);
        lager[stelle].bucheAbgang(anzahl);
    }

    /**
     * Methode abgangBuchen bucht einen Artikelzugang anhand der Artikelnummer
     * @param artikel Artikelnummer, INTEGER
     * @param anzahl  Aenderungswert, INTEGER
     */
    public void zugangBuchen(int artikel, int anzahl){
        int stelle = doSearch(artikel);
        lager[stelle].bucheZugang(anzahl);
    }

    /**
     * Methode preisKorrektur aendert die Preise aller Artikel im Lager um einen mitgegebenen Prozentsatz
     * @param prozentsatz double-Wert, positiver oder negativer Prozentsatz (z.B. 0,5)
     */
    public void preisKorrektur(double prozentsatz){
        double preis;
        for (int i=0; i < zeiger; i++){
            preis = lager[i].getArtikelPreis();
            preis = preis + (preis * prozentsatz);
            lager[i].setPreis(preis);
        }
    }

    /**
     * Methode doAusgabe gibt das Lager als String aus, dabei wird ueberprueft, ob Artikel im Lager vorhanden sind
     * @return  Inhalt des Lagers als STRING
     */
    public String doAusgabe(){
        checkAusgabe();
        String ausgabe = "";
        ausgabe += "Lagerort: " + lagerort + "\n\n";
        ausgabe += "ArtNr \t Beschreibung \t Preis \t Bestand \t Gesamt \n";
        ausgabe += "---------------------------------------------\n";
        for (int i=0; i < zeiger; i++){
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
     * @param groesse   INTEGER, Groesse des neuen Lagers
     */
    public void lagerErweitern(int groesse){
        checkErweitern(groesse);
        lagerNew = new Artikel[groesse];
        for (int i=0; i < zeiger; i++){
            lagerNew[i] = lager[i];
        }
        lager = lagerNew;
    }

    /**
     * Methode doSearch  Sucht ein Artikel im Lager anhand der Artikelnummer und gibt die Stelle im Array zurueck.
     * Es wird geprüft, ob der Artikel existiert.
     * @param artikelNummer INTEGER, artikelNummer
     * @return  INTEGER, Postition im Array
     */
    public int doSearch(int artikelNummer){
        int stelle = -1;
        for (int i=0; i < zeiger; i++){
            if (lager[i].getNummer() == artikelNummer ){
                stelle = i;
            }
        }
        checkSearch(stelle);
        return stelle;
    }

    /**
     * Methode doSearch  Sucht ein Artikel im Lager anhand der Artikelnummer und gibt die Stelle im Array zurueck.
     * @param artikelNummer INTEGER, artikelNummer
     * @return  INTEGER, Postition im Array
     */
    public int doSearchNewArt(int artikelNummer){
        int stelle = -1;
        for (int i=0; i < zeiger; i++){
            if (lager[i].getNummer() == artikelNummer ){
                stelle = i;
            }
        }
        return stelle;
    }

    /**
     * Methode getGesamtwert gibt den Gesamtwert, der im Lager gespeicherten Artikel zurueck.
     * @return  Gesamtwert der Artikel
     */
    public double getGesamtwert (){
        double gesamtwert = 0;
        for (int i=0; i < zeiger; i++){
            gesamtwert += lager[i].getArtikelPreis() * lager[i].getAnzahl();
        }
        return gesamtwert;
    }

    private static void check(boolean bedingung, String msg){
        if (!bedingung)
            throw new IllegalArgumentException(msg);
    }

    private void checkAdd(){
        check(zeiger < lager.length, "Es können keine weiteren Artikel gespeichert werden! Lager voll!");
    }

    private void checkArtikelDouble(Artikel artikel){
        check(doSearchNewArt(artikel.getNummer()) == -1, "Die eingegebene Artikelnummer wurde bereits verwendet!");
    }

    private void checkSearch(int stelle){
        check(stelle != -1, "Der eingegebene Artikel existiert nicht!");
    }

    private void checkAusgabe(){
        check(zeiger != 0, "Das Lager ist leer!");
    }

    private void checkErweitern(int groesse){
        check(lager.length < groesse, "Das neue Lager muss groesser sein, als das Alte!");
    }

    private void checkLager(){
        check(lager != null, "Es wurde noch kein Lager angelegt!");
    }
}
