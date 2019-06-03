package Aufgabe2;

import java.util.Scanner;

/**
 * Die Klasse ArtikelTest ist eine Dialog Klasse, die dem Nutzer erlaubt, einen Artikel zu verwalten.
 *
 * @author Jan Ehrhardt / Aaron Betzholz
 * @version 22.01.2019
 */
public class ArtikelDialog
{
    private Scanner input = new Scanner(System.in);
    private Artikel artikel1;

    //statische Variabeln
    private static final int ANLEGEN = 1;
    private static final int ANLEGEN2 = 2;
    private static final int ZUGANG = 3;
    private static final int ABGANG = 4;
    private static final int SET_BEZ = 5;
    private static final int INFO = 6;
    private static final int ENDE = 0;

    /**
     * Methode main Ruft die Methode start auf.
     *
     * @param args Ein Parameter
     */
    public static void main(String[] args){
        new ArtikelDialog().start();
    }

    /**
     * Methode start Legt einen leeren Artikel (artikel1) an, führt die Funktion aus,
     * die vom Nutzer in der Methode einlesenFunktion gewählt wurde.
     * Sollte der Nutzer eine falsche Eingabe machen, wird diese hier gefangen.
     *
     */
    private void start(){
        artikel1 = null;
        int funktion = -1;

        while(funktion != ENDE){
            try {
                funktion = einlesenFunktion();
                ausfuehren(funktion);
            } catch (Exception e){
                //noinspection ThrowablePrintedToSystemOut
                System.out.println(e);
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
        System.out.println(ANLEGEN + ": Artikel anlegen,  " + ANLEGEN2 + ": Artikel anlegen (ohne Bestand),   " +
                ZUGANG + ": Zugang buchen,  " + ABGANG +
                ": Abgang buchen,  " + SET_BEZ + ": Bezeichnung ändern,  " + INFO + ": Info anzeigen,  " + ENDE + ": ENDE");
        return input.nextInt();
    }

    /**
     * Methode ausfuehren Bekommt die vom Nutzer gewählte Funktion von der Methode start übergeben
     * und führt die zur Funktion gehörige Methode aus.
     *
     * @param funktion Funktionswahl des Nutzers
     */
    private void ausfuehren(int funktion){
        if (funktion == ANLEGEN){
            artikel1 = artikelAnlegen();
        }else
        if (funktion == ANLEGEN2){
            artikel1 = artikelAnlegen2();
        }else
        if (funktion == ZUGANG){
            bucheZugang();
        }else
        if (funktion == ABGANG){
            bucheAbgang();
        }else
        if (funktion == SET_BEZ){
            setBezeichnung();
        }else
        if (funktion == INFO){
            System.out.println(artikel1.toString());
        }else{
            System.out.println("Funktion steht nicht zur wahl!");
        }
    }

    /**
     * Methode doZugang Bucht die eingegebene Anzahl der Objekte zum Artikel hinzu
     *
     */
    private void bucheZugang(){
        System.out.print("Anzahl der zu buchenden Objekte: ");
        artikel1.bucheZugang(input.nextInt());
    }

    /**
     * Methode doAbgang Zieht die eingebene Anzahl der Objekte vom Artikel ab
     *
     */
    private void bucheAbgang(){
        System.out.print("Anzahl der abzubuchenden Objekte: ");
        artikel1.bucheAbgang(input.nextInt());
    }

    /**
     * Methode setBezeichnung Aendert die Bezeichnung eines Artikels dur den eingegebenen String.
     *
     */
    private void setBezeichnung(){
        input.nextLine();
        System.out.print("Neue Bezeichnung: ");
        artikel1.setBezeichnung(input.nextLine());
    }

    /**
     * Methode artikelAnlegen Fragt den Nutzer nach Artikelnummer, Bezeichnung und Artikelanzahl und gibt einen
     * Artikel mit den eingegebenen Atributenzurück.
     *
     * @return Gibt den erstellten Artikel zurück
     */
    private Artikel artikelAnlegen(){
        int artikelNummer;
        String artikelBezeichnung;
        int artikelAnzahl;
        double artikelPreis;
        System.out.print("Artikelnummer: ");
        artikelNummer = input.nextInt();
        input.nextLine();
        System.out.print("Bezeichnung: ");
        artikelBezeichnung = input.nextLine();
        System.out.print("Preis: ");
        artikelPreis = input.nextDouble();
        System.out.print("Artikelanzahl: ");
        artikelAnzahl = input.nextInt();
        return new Artikel(artikelNummer, artikelBezeichnung, artikelPreis, artikelAnzahl);
    }

    /**
     * Methode artikelAnlegen2 Fragt den Nutzer nach Artikelnummer, Bezeichnung und gibt einen
     * Artikel mit den eingegebenen Atributenzurück, wobei die Artikelanzahl 0 ist.
     *
     * @return Gibt den erstellten Artikel zurück
     */
    private Artikel artikelAnlegen2(){
        int artikelNummer;
        String artikelBezeichnung;
        double artikelPreis;
        System.out.print("Artikelnummer: ");
        artikelNummer = input.nextInt();
        input.nextLine();
        System.out.print("Bezeichnung: ");
        artikelBezeichnung = input.nextLine();
        System.out.print("Preis: ");
        artikelPreis = input.nextDouble();
        return new Artikel(artikelNummer, artikelBezeichnung, artikelPreis);
    }
}
