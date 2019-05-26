package Aufgabe2;

/**
 * @author Jan Ehrhardt / Luca Schneider
 * @version 22.01.2019
 */
public class CD extends Artikel {

    private String interpret;
    private String titel;
    private int anzTitel;

    public CD(int artikelNummer, String artikelBezeichnung, double artikelPreis, int artikelAnzahl, String interpret,
              String titel, int anzTitel){
        super(artikelNummer, artikelBezeichnung, artikelPreis, artikelAnzahl);
        this.interpret = interpret;
        this.titel = titel;
        this.anzTitel = anzTitel;
    }

    @Override
    public String getBeschreibung(){
        return interpret + ": " + titel;
    }

    public String getInterpret() {
        return interpret;
    }

    public void setInterpret(String interpret) {
        this.interpret = interpret;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public int getAnzTitel() {
        return anzTitel;
    }

    public void setAnzTitel(int anzTitel) {
        this.anzTitel = anzTitel;
    }
}
