package Aufgabe3;

/**
 * Berchnung der Fakultaet als Top-Level-Klasse
 */
public class FakultaetKlasse{
    /**
     * Berechnung der Fakultaet
     * @param x wert
     * @return Fakultaet
     */
    public static int FakultaetBerechnen(int x) {
        int ergebnis = 1;
        for (int i = 1; i <= x; i++) {
            ergebnis *= i;
        }
        return ergebnis;
    }
}