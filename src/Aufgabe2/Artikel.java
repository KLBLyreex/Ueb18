package Aufgabe2;

/**
 * Die Klasse Artikel verwaltet Informationen ueber einen Artikel.
 *
 * @author Jan Ehrhardt / Aaron Betzholz
 * @version 27.05.2019
 */
public class Artikel{
    private int artikelNummer;
    private String artikelBezeichnung;
    private int artikelAnzahl;
    private double artikelPreis;

    private static final String ERROR_ARTIKELNR_UNGUELTIG = "Artikelnummer muss eine 4-stellige positive Zahl sein!";
    private static final String ERROR_ARTIKELBEZ_LEER = "Artikel Bezeichnung darf nicht leer sein!";
    private static final String ERROR_ARTIKELANZ_NEGATIV = "Anzahl der Artikel darf nicht negativ sein1";
    private static final String ERROR_ARTIKELPREIS_NULL = "Der Preis des Artikels muss groesser 0 sein!";
    private static final String ERROR_NEGATIVER_ZUGANG = "Es kann kein negativer Zugang gebucht werden!";
    private static final String ERROR_NEGATIVER_ABGANG = "Es kann kein negativer Abgang gebucht werden!";
    private static final String ERROR_KEIN_BESTAND = "Es ist kein Bestand des Artikels vorhanden, es kann also keine Abgang gebucht werden!";
    private static final String ERROR_ZU_HOHER_ABGANG = "Es können nicht mehr Artikel abgehen, als existieren!";

    
    public Artikel(int artikelNummer, String artikelBezeichnung, double artikelPreis, int artikelAnzahl){
        Validator.check(artikelNummer >= 10000 || artikelNummer <= 999, ERROR_ARTIKELNR_UNGUELTIG);
        Validator.check(artikelBezeichnung.trim().isEmpty(), ERROR_ARTIKELBEZ_LEER);
        Validator.check(artikelAnzahl <= 0, ERROR_ARTIKELANZ_NEGATIV);
        Validator.check(artikelPreis <= 0, ERROR_ARTIKELPREIS_NULL);
        this.artikelNummer = artikelNummer;
        this.artikelBezeichnung = artikelBezeichnung;
        this.artikelAnzahl = artikelAnzahl;
        this.artikelPreis = artikelPreis;
    }
    
    public Artikel(int artikelNummer, String artikelBezeichnung, double artikelPreis){
        this(artikelNummer, artikelBezeichnung, artikelPreis, 0);
    }
    
    public int getNummer(){
        return artikelNummer;
    }


    public String getBeschreibung(){
        return artikelBezeichnung;
    }

    public int getAnzahl(){
       return artikelAnzahl;
    }

    public double getArtikelPreis(){
        return artikelPreis;
    }

    public void setAnzahl(int artikelAnzahl){
        Validator.check(artikelAnzahl <= 0, ERROR_ARTIKELANZ_NEGATIV);
        this.artikelAnzahl = artikelAnzahl;
    }

    public void setBezeichnung(String artikelBezeichnung){
        Validator.check(artikelBezeichnung.isEmpty(), ERROR_ARTIKELBEZ_LEER);
        this.artikelBezeichnung = artikelBezeichnung;
    }
    
    public void setPreis(double artikelPreis){
        Validator.check(artikelPreis <= 0, ERROR_ARTIKELPREIS_NULL);
        this.artikelPreis = artikelPreis;
    }

    public void bucheZugang(int Anzahl){
        Validator.check(Anzahl <= 0, ERROR_NEGATIVER_ZUGANG);
        artikelAnzahl = artikelAnzahl + Anzahl;
    }

    public void bucheAbgang(int Anzahl){
        Validator.check(Anzahl <= 0, ERROR_NEGATIVER_ABGANG);
        Validator.check(artikelAnzahl <= 0, ERROR_KEIN_BESTAND);
        Validator.check(artikelAnzahl < Anzahl, ERROR_ZU_HOHER_ABGANG);
        artikelAnzahl = artikelAnzahl - Anzahl;
    }

    public String toString(){
        return artikelNummer + "\t" + getBeschreibung() + "\t" + artikelPreis + "\t" + artikelAnzahl + "\t" +
                (artikelAnzahl*artikelPreis);
    }
}
