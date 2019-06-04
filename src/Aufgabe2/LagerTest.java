package Aufgabe2;

import java.util.function.Predicate;

/**
 * Test Klasse fuer das Lager.
 *
 * @author Jan Ehrhardt / Aaron Betzholz
 * @version 03.05.2019
 */
public class LagerTest {
    private Lager store = new Lager(30, "HTW Saar");

    public static void main(String[] args) {
        new LagerTest().test();
    }

    private void test(){
        store.addArtikel(new Artikel(1000, "Apfel", 1.23, 1));
        store.addArtikel(new Artikel(1001, "Banane",  1.23, 5));
        store.addArtikel(new Artikel(1002, "Mango", 1.23, 15));
        store.addArtikel(new Artikel(1003, "Kiwi", 1.23, 2));
     //   store.addArtikel(new Video(1004, "GoT: Staffel 1",  21.23, 15, "Game of Thrones: Season 1", 300, 2011));
      //  store.addArtikel(new CD(1005, "My Little Pony 2",  10.23, 15, "My Little Pony", "Dos", 15));
      //  store.addArtikel(new Video(1006, "GoT: Staffel 3",  21.23, 15, "Game of Thrones: Season 3", 300, 2011));
       // store.addArtikel(new Video(1007, "GoT: Staffel 4", 21.23, 11, "Game of Thrones: Season 4", 300, 2011));
       // store.addArtikel(new Video(1008, "GoT: Staffel 5",  21.23, 15, "Game of Thrones: Season 5", 300, 2011));
        //store.addArtikel(new Video(1009, "GoT: Staffel 6", 21.23, 15, "Game of Thrones: Season 6", 300, 2011));
     //   store.addArtikel(new CD(1010, "My Little Pony",  11.23, 15, "My Little Pony", "Uno", 15));
     //   store.addArtikel(new Video(1011, "GoT: Staffel 8", 21.23, 15, "Game of Thrones: Season 8", 300, 2011));
        store.addArtikel(new Artikel(1012, "Laptop",  1000.23, 66));
        store.addArtikel(new Artikel(1013, "Birne",  1.67, 9));
        store.addArtikel(new Artikel(1014, "Paprika", 2.87, 62));
        store.addArtikel(new Artikel(1015, "Smartphone",  850.34, 2));
        store.addArtikel(new Artikel(1016, "Sonnenbrille", 56.23, 9));
        store.addArtikel(new Artikel(1017, "Glas",  0.69, 95));
        store.addArtikel(new Artikel(1018, "T-Shirt",  10.99, 75));
        store.addArtikel(new Artikel(1019, "Pfanne",  59.25, 185));
        store.addArtikel(new Artikel(1020, "Pfirsisch", 2.03, 54));

        //System.out.println(store.filter(filterArtikelNummer));
        store.getSorted(Lager.sortBestand);
        System.out.println(store.doAusgabe());
    }

    static Predicate<Artikel> filterArtikelNummer = t -> {return t.getAnzahl() < 30;};
//TODO Testcases nach Aufgabenblatt erstellen!
}
