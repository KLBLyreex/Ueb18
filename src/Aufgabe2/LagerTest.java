package Aufgabe2;

public class LagerTest {
    private Lager store = new Lager(20, "HTW Saar");

    public static void main(String[] args) {

    }

    private void test(){
        store.addArtikel(new Artikel(1000, "Apfel", "Obst", 1.23, 15));
        store.addArtikel(new Artikel(1001, "Banane", "Obst", 1.23, 15));
        store.addArtikel(new Artikel(1002, "Mango", "Obst", 1.23, 15));
        store.addArtikel(new Artikel(1003, "Kiwi", "Obst", 1.23, 15));
        store.addArtikel(new Artikel(1004, "GoT: Staffel 1", "DVD", 21.23, 15));
        store.addArtikel(new Artikel(1005, "My Little Pony 2", "CD", 10.23, 15));
        store.addArtikel(new Artikel(1006, "GoT: Staffel 3", "DVD", 21.23, 15));
        store.addArtikel(new Artikel(1007, "GoT: Staffel 4", "DVD", 21.23, 11));
        store.addArtikel(new Artikel(1008, "GoT: Staffel 5", "DVD", 21.23, 15));
        store.addArtikel(new Artikel(1009, "GoT: Staffel 6", "DVD", 21.23, 15));
        store.addArtikel(new Artikel(1010, "My Little Pony", "CD", 11.23, 15));
        store.addArtikel(new Artikel(1011, "GoT: Staffel 8", "DVD", 21.23, 15));
        store.addArtikel(new Artikel(1012, "Laptop", "Elektro", 1000.23, 15));
        store.addArtikel(new Artikel(1013, "Birne", "Obst", 1.67, 15));
        store.addArtikel(new Artikel(1014, "Paprika", "Gemüse", 2.87, 85));
        store.addArtikel(new Artikel(1015, "Smartphone", "Elektro", 850.34, 11));
        store.addArtikel(new Artikel(1016, "Sonnenbrille", "Bekleidung", 56.23, 19));
        store.addArtikel(new Artikel(1017, "Glas", "Haushalt", 0.69, 95));
        store.addArtikel(new Artikel(1018, "T-Shirt", "Bekleidung", 10.99, 35));
        store.addArtikel(new Artikel(1019, "Pfanne", "Haushalt", 59.25, 185));
        store.addArtikel(new Artikel(1020, "Pfirsisch", "Obst", 2.03, 54));

        store.sa
    }
}
