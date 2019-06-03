package Aufgabe1;

/**
 * Die Klasse Iteration fuert die Berechnung einer Funktion mit einem Startwert und einer Iterationszahl
 *
 * @author Aaron Betzholz / Jan Ehrhardt
 * @version 03.06.2019
 */
public class Iteration {

    private static String TRENNZEICHEN = "###################################";

    /**
     * iterate wendet die Funktion function n-mal wei folgt an: xi+1=f(xi).
     * @param start Startwert double
     * @param n Iterationszahl int
     * @param function Funktion
     * @return Ergebnis double
     */
    private static double iterate(double start, int n, IterateInterface function) {
        double ergebnis = start;

        for (int i = 0; i < n; i++) {
            ergebnis = function.berechnen(ergebnis);
            System.out.println("Zwischen Ergebnis: " + ergebnis);
        }

        return ergebnis;
    }

    /**
     * Implementierung fuer Iterate mit
     * a) f(x) = 2x
     * b) f(x) = 0.5x
     * c) f(x) = ax(x-1), fuer a e (0,1)
     * @param args
     */
    public static void main(String[] args){
        IterateInterface function1 = (double x) -> 2 * x;
        IterateInterface function2 = (double x) -> 0.5 * x;
        IterateInterface function3 = (double x) -> 0.2 * x - (x-1);
        System.out.println("Endergebnis: " + iterate(1, 10, function1));
        System.out.println(TRENNZEICHEN);
        System.out.println("Endergebnis: " + iterate(1, 10, function2));
        System.out.println(TRENNZEICHEN);
        System.out.println("Endergebnis: " + iterate(1, 10, function3));
    }
}
