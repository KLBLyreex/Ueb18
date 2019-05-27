package Aufgabe2;

/**
 * Statische Klasse zum Prüfen von Bedingungen
 */
public class Validator {

    /**
     * Wenn die Bedingung erfüllt ist wird eine Exception (IllegalArgumentException) geworfen
     * @param bedingung die zu prüfende Bedingung
     * @param msg Die Fehlermeldung die angezeigt wird
     */
    public static void check(boolean bedingung, String msg){
        if(bedingung){
            throw new IllegalArgumentException(msg);
        }
    }
}
