package Aufgabe3;

/**
 * Klasse Function zur Ausfuerung verschiedener Funktionen mit Hilfe des Interfaces MyFunktion, auf verschiedene weisen
 * implementiert.
 */
public class Function {

    private int i;
    private int j;

    /**
     * Konstruktor fuer Function
     * @param i INTEGER Untere-Grenze
     * @param j INTEGER Obere.Grenze
     */
    public Function(int i, int j) {
        this.i = i;
        this.j = j;
    }

    /**
     * NestedClass zur Berechnung der Fakulteat
     */
    public static class FakultaetNestedClass {
        public static int FakultaetBerechnen(int x) {
            int ergebnis = 1;
            for (int i = 1; i <= x; i++) {
                ergebnis *= i;
            }
            return ergebnis;
        }
    }

    /**
     * applyAndPrint ruft die Uebergebene Funktion fuer alle Werte zwischen i und j auf und gibt diese ueber die Konsole
     * aus.
     * @param myFunction Auszufuehrende Funktion
     * @param i Untere-Grenze
     * @param j Obere-Grenze
     */
    private void applyAndPrint(MyFunction myFunction, int i, int j) {
        for (int x = i; x <= j; x++) {
            System.out.println(x + ": " + myFunction.apply(x));
        }
    }
}
