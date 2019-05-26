package Aufgabe2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Die Klasse LagerDialog ist das Interface zwsichen dem User und der Klasse Lager.
 *
 * @author Jan Ehrhardt / Luca Schneider
 * @version 22.01.2019
 */
public class LagerDialog {
    private Scanner input;
    private Lager lager;

    //statische Variabeln
    private static final int ANLEGEN = 1;
    private static final int HINZUFUEGEN = 2;
    private static final int LOESCHEN = 3;
    private static final int ZUGANG = 4;
    private static final int ABGANG = 5;
    private static final int PREISKORREKTUR = 6;
    private static final int AUSGABE = 7;
    private static final int ERWEITERN = 8;
    private static final int ENDE = 0;
    private static final String ANLEGENstring = "Neues Lager anlegen";
    private static final String HINZUFUEGENstring = "Artikel anlegen";
    private static final String LOESCHENstring = "Artikel löschen";
    private static final String ZUGANGstring = "Zugang für Artikel buchen";
    private static final String ABGANGstring  = "Abgang für Artikel buchen";
    private static final String PREISKORREKTURstring = "Artikel Preiskorrektur";
    private static final String AUSGABEstring = "Lager anzeigen";
    private static final String ERWEITERNstring = "Lager vergroessern";
    private static final String ENDEstring = "ENDE";

    /**
     * Konstruktor, initialisiert den Scanner.
     */
    public LagerDialog(){
        input = new Scanner(System.in);
    }

    /**
     * Methode main Ruft die Methode start auf.
     *
     * @param args Ein Parameter
     */
    public static void main(String[] args){
        new LagerDialog().start();
    }

    /**
     * Methode start enthällt die Ausnahmebehandlung, sie ruft die Methode einlesenFunktion auf und übergibt die
     * von Nutzer gewählte Funktion an die Methode ausführen.
     *
     */
    private void start(){
        int funktion = -1;

        while(funktion != ENDE){
            try {
                funktion = einlesenFunktion();
                ausfuehren(funktion);
            } catch (InputMismatchException mismatchException){
                System.out.println("Ihre Eingabe hat einen Fehler im Program ausgelöst. Bitte überprüfen Sie Ihre Eingabe " +
                        "und versuchen Sie es erneut.");
                input.nextLine();
            } catch (Exception e){
                System.out.println(e.getMessage());
                input.nextLine();
            }
        }
    }

    /**
     * Methode einlesenFunktion Zeigt dem Nutzer eine Auswahl an Funktionen und ließt seine Wahl ein.
     *
     * @return Der Rückgabewert, Funktionswahl des Nutzers
     */
    private int einlesenFunktion(){
        System.out.println("================");
        System.out.println(ANLEGEN + ":  " + ANLEGENstring);
        System.out.println(HINZUFUEGEN + ":  " + HINZUFUEGENstring);
        System.out.println(LOESCHEN + ":  " + LOESCHENstring);
        System.out.println(ZUGANG + ":  " + ZUGANGstring);
        System.out.println(ABGANG + ":  " + ABGANGstring);
        System.out.println(PREISKORREKTUR + ":  " + PREISKORREKTURstring);
        System.out.println(AUSGABE + ":  " + AUSGABEstring);
        System.out.println(ERWEITERN + ":  " + ERWEITERNstring);
        System.out.println(ENDE + ":  " + ENDEstring);
        return input.nextInt();
    }

    /**
     * Methode ausfuehren Bekommt die vom Nutzer gewählte Funktion von der Methode start übergeben
     * und führt die zur Funktion gehörige Methode aus.
     *
     * @param funktion Funktionswahl des Nutzers
     */
    private void ausfuehren(int funktion){
        switch (funktion){
            case ANLEGEN: lagerAnlegen();
                break;
            case HINZUFUEGEN: addArtikel();
                break;
            case LOESCHEN: deleteArtikel();
                break;
            case ZUGANG: bucheZugang();
                break;
            case ABGANG: bucheAbgang();
                break;
            case PREISKORREKTUR: preisKorrektur();
                break;
            case AUSGABE: System.out.println(lager.doAusgabe());
                break;
            case ERWEITERN: doLagerErweitern();
                break;
            case ENDE: System.out.print("ENDE!");
                break;
            default: System.out.println("Funktion steht nicht zur Wahl!");

        }
    }

    /**
     * Methode lagerAnlegen ermoeglicht dem Nutzer ein neues Lager anzugelegn, wobei abgefragt wird, ob bereits ein Lager
     * vorhanden ist, und dieses ggf. ueberschrieben werden soll.
     */
    private void lagerAnlegen(){
        int entscheidung;
        String lagerort;
        if (lager == null) {
            input.nextLine();
            System.out.print("Lagerort angeben: ");
            lagerort = input.nextLine();
            System.out.print("Groeße des Lagers eingeben: ");
            lager = new Lager(input.nextInt(), lagerort);
        } else {
            System.out.println("Es existiert bereits ein Lager! Moechten Sie das vorhandene Lager ersetzen? " +
                    "Ja = 1; Nein = 0");
            entscheidung = input.nextInt();
            if (entscheidung == 1){
                input.nextLine();
                System.out.print("Lagerort angeben: ");
                lagerort = input.nextLine();
                System.out.print("Groeße des Lagers eingeben: ");
                lager = new Lager(input.nextInt(), lagerort);
            }
        }
    }

    /**
     * Methode artikelAnlegen Fragt den Nutzer nach Artikelnummer, Bezeichnung, Artikelanzahl und Preis und speichert
     * den angelegten Artikel im Lager.
     */
    private void addArtikel(){
        System.out.print("Typ waehlen [1: Buch; 2: CD; 3: Video]: ");
        int wahl = input.nextInt();
        switch(wahl) {
            case 1:
                addBuch();
                break;
            case 2:
                addCD();
                break;
            case 3:
                addVideo();
                break;
            default:
                System.out.println("Fehler bei Eingabe: Der gewaehlte Typ steht nicht zur Verfuegung!");
        }
    }

    private void addBuch(){
        int artikelNummer;
        String artikelBezeichnung;
        double artikelPreis;
        int artikelAnzahl;
        String buchTitel;
        String buchAutor;
        String buchVerlang;
        Artikel artikel;
        System.out.print("Artikelnummer: ");
        artikelNummer = input.nextInt();
        input.nextLine();
        System.out.print("Bezeichnung: ");
        artikelBezeichnung = input.nextLine();
        System.out.print("Preis: ");
        artikelPreis = input.nextDouble();
        System.out.print("Artikelanzahl: ");
        artikelAnzahl = input.nextInt();
        input.nextLine();
        System.out.print("Titel: ");
        buchTitel = input.nextLine();
        System.out.print("Autor: ");
        buchAutor = input.nextLine();
        System.out.print("Verlag: ");
        buchVerlang = input.nextLine();
        artikel = new Buch(artikelNummer, artikelBezeichnung, artikelPreis, artikelAnzahl, buchTitel, buchAutor, buchVerlang);
        lager.addArtikel(artikel);
    }

    private void addCD(){
        int artikelNummer;
        String artikelBezeichnung;
        double artikelPreis;
        int artikelAnzahl;
        String cdInterpret;
        String cdTitel;
        int cdAnzTitel;
        Artikel artikel;
        System.out.print("Artikelnummer: ");
        artikelNummer = input.nextInt();
        input.nextLine();
        System.out.print("Bezeichnung: ");
        artikelBezeichnung = input.nextLine();
        System.out.print("Preis: ");
        artikelPreis = input.nextDouble();
        System.out.print("Artikelanzahl: ");
        artikelAnzahl = input.nextInt();
        input.nextLine();
        System.out.print("Interpret: ");
        cdInterpret = input.nextLine();
        System.out.print("Titel: ");
        cdTitel= input.nextLine();
        System.out.print("Anzahl Titel: ");
        cdAnzTitel = input.nextInt();
        artikel = new CD(artikelNummer, artikelBezeichnung, artikelPreis, artikelAnzahl, cdInterpret, cdTitel, cdAnzTitel);
        lager.addArtikel(artikel);
    }

    private void addVideo(){
        int artikelNummer;
        String artikelBezeichnung;
        double artikelPreis;
        int artikelAnzahl;
        String videoTitel;
        int videoDauer;
        int videoJahr;
        Artikel artikel;
        System.out.print("Artikelnummer: ");
        artikelNummer = input.nextInt();
        input.nextLine();
        System.out.print("Bezeichnung: ");
        artikelBezeichnung = input.nextLine();
        System.out.print("Preis: ");
        artikelPreis = input.nextDouble();
        System.out.print("Artikelanzahl: ");
        artikelAnzahl = input.nextInt();
        input.nextLine();
        System.out.print("Titel: ");
        videoTitel = input.nextLine();
        System.out.print("Videodauer: ");
        videoDauer = input.nextInt();
        System.out.print("Jahr der Veroeffentlichung: ");
        videoJahr = input.nextInt();
        artikel = new Video(artikelNummer, artikelBezeichnung, artikelPreis, artikelAnzahl, videoTitel, videoDauer, videoJahr);
        lager.addArtikel(artikel);
    }

    /**
     * Methode deleteArtikel fragt vom Nutzer die Artikelnummer ab und uebergibt diese an die Methode deleteArtikel
     * des Lagers
     */
    private void deleteArtikel(){
        System.out.print("Artikelnummer eingeben: ");
        lager.deleteArtikel(input.nextInt());
    }

    /**
     * Methode bucheZugang fragt vom Nutzer die Artikelnummer und die Anzahl ab und uebergibt diese an die Methode
     * zugangBuchen des Lagers
     */
    private void bucheZugang(){
        int artikelNummer;
        int anzahl;
        System.out.print("Artikelnummer: ");
        artikelNummer = input.nextInt();
        System.out.print("Anzahl: ");
        anzahl = input.nextInt();
        lager.zugangBuchen(artikelNummer, anzahl);
    }

    /**
     * Methode bucheZugang fragt vom Nutzer die Artikelnummer und die Anzahl ab und uebergibt diese an die Methode
     * abgangBuchen des Lagers
     */
    private void bucheAbgang(){
        int artikelNummer;
        int anzahl;
        System.out.print("Artikelnummer: ");
        artikelNummer = input.nextInt();
        System.out.print("Anzahl: ");
        anzahl = input.nextInt();
        lager.abgangBuchen(artikelNummer, anzahl);
    }

    /**
     * Methode preisKorrektur fragt vom Nutzer den Prozentsatz ab und uebergibt diese an die Methode preisKorrektur
     * des Lagers
     */
    private void preisKorrektur(){
        double prozent;
        System.out.print("Prozentsatz: ");
        prozent = input.nextDouble();
        lager.preisKorrektur(prozent);
    }

    /**
     * Methode doLagerErweitern fragt vom Nutzer die neue Groesse ab und uebergibt diese an die Methode lagerErweitern
     * des Lagers
     */
    private void doLagerErweitern(){
        System.out.print("Neue Groesse eingeben: ");
        lager.lagerErweitern(input.nextInt());

    }
}
