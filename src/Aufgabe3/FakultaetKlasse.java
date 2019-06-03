package Aufgabe3;

/**
 * Berchnung der Fakultaet als Top-Level-Klasse
 *
 * @author Aaron Betzholz / Jan Ehrhardt
 * @version 03.06.2019
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