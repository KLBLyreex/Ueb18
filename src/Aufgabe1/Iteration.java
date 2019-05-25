package Aufgabe1;

public class Iteration {

    private static String TRENNZEICHEN = "###################################";

    private static double iterate(double start, int n, IterateInterface function) {
        double ergebnis = start;

        for (int i = 0; i < n; i++) {
            ergebnis = function.berechnen(ergebnis);
            System.out.println("Zwischen Ergebnis: " + ergebnis);
        }

        return ergebnis;
    }

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
