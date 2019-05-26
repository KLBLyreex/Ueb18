package Aufgabe2;

/**
 * @author Jan Ehrhardt / Luca Schneider
 * @version 22.01.2019
 */
public class Video extends Artikel{
    private String titel;
    private int dauer;
    private int erscheinungsjahr;

    public Video(int artikelNummer, String artikelBezeichnung, double artikelPreis, int artikelAnzahl, String titel,
                 int dauer, int erscheinungsjahr){
        super(artikelNummer, artikelBezeichnung, artikelPreis, artikelAnzahl);
        this.titel = titel;
        this.dauer = dauer;
        this.erscheinungsjahr = erscheinungsjahr;
    }

    @Override
    public String getBeschreibung(){
        return titel;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public int getDauer() {
        return dauer;
    }

    public void setDauer(int dauer) {
        this.dauer = dauer;
    }

    public int getErscheinungsjahr() {
        return erscheinungsjahr;
    }

    public void setErscheinungsjahr(int erscheinungsjahr) {
        this.erscheinungsjahr = erscheinungsjahr;
    }
}

