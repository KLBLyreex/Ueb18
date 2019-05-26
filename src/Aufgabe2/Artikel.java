package Aufgabe2;

/**
 * Die Klasse Artikel verwaltet Informationen ueber einen Artikel.
 *
 * @author Jan Ehrhardt / Luca Schneider
 * @version 22.01.2019
 */
public class Artikel{
    private int artikelNummer;
    private String artikelBezeichnung;
    private int artikelAnzahl;
    private double artikelPreis;

    public Artikel(){}
    
    public Artikel(int artikelNummer, String artikelBezeichnung, double artikelPreis, int artikelAnzahl){
        checkArtNr(artikelNummer);
        checkArtBez(artikelBezeichnung);
        checkArtAnz(artikelAnzahl);
        checkPreis(artikelPreis);
        this.artikelNummer = artikelNummer;
        this.artikelBezeichnung = artikelBezeichnung;
        this.artikelAnzahl = artikelAnzahl;
        this.artikelPreis = artikelPreis;
    }
    
    public Artikel(int artikelNummer, String artikelBezeichnung, double artikelPreis){
        this(artikelNummer, artikelBezeichnung, artikelPreis, 0);
    }
        
    private static void check(boolean bedingung, String msg){
        if (!bedingung)
            throw new IllegalArgumentException(msg);
    }

    private static void checkArtNr(int artikelNummer){
     check(artikelNummer >=1000 && artikelNummer <= 9999, "Artikelnummer muss eine 4-stellige Zahl sein!");
    }

    private static void checkArtBez(String artikelBezeichnung){
        check(artikelBezeichnung != null && !artikelBezeichnung.trim().isEmpty(), "Artikelbezeichnung darf nicht leer sein!");
    }
    
    private static void checkArtAnz(int artikelAnzahl){
        check(artikelAnzahl >= 0, "Anzahl der Artikel darf nicht negativ sein!");
    }

    private void checkPreis(double artikelPreis){
        check(artikelPreis > 0, "Der Preis des Artikels muss größer 0 sein!");
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
        checkArtAnz(artikelAnzahl);
        this.artikelAnzahl = artikelAnzahl;
    }

    public void setBezeichnung(String artikelBezeichnung){
        checkArtBez(artikelBezeichnung);
        this.artikelBezeichnung = artikelBezeichnung;
    }
    
    public void setPreis(double artikelPreis){
        checkPreis(artikelPreis);
        this.artikelPreis = artikelPreis;
    }

    public void bucheZugang(int Anzahl){
        check(Anzahl > 0, "Es kann kein negativer Zugang gebucht werden!");
        artikelAnzahl = artikelAnzahl + Anzahl;
    }

    public void bucheAbgang(int Anzahl){
        check(artikelAnzahl > 0, "Es ist kein Bestand des Artikels vorhanden, es kann also keine Abgang gebucht werden!");
        check(Anzahl > 0, "Es kann kein negativer Abgang gebucht werden!");
        check(artikelAnzahl >= Anzahl, "Es können nicht mehr Artikel abgehen, als existieren!");
        artikelAnzahl = artikelAnzahl - Anzahl;
    }

    public String toString(){
        return artikelNummer + "\t" + getBeschreibung() + "\t" + artikelPreis + "\t" + artikelAnzahl + "\t" +
                (artikelAnzahl*artikelPreis);
    }
}
