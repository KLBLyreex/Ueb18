package Aufgabe2;

/**
 * @author Jan Ehrhardt / Luca Schneider
 * @version 22.01.2019
 */
public class Buch extends Artikel{

    private String titel;
    private String autor;
    private String verlag;

    public Buch (int artikelNummer, String artikelBezeichnung, double artikelPreis, int artikelAnzahl, String titel,
                 String autor, String verlag){
        super(artikelNummer, artikelBezeichnung, artikelPreis, artikelAnzahl);
        this.titel = titel;
        this.autor = autor;
        this.verlag = verlag;
    }

    @Override
    public String getBeschreibung(){
        return autor + ": " + titel;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getVerlag() {
        return verlag;
    }

    public void setVerlag(String verlag) {
        this.verlag = verlag;
    }
}
