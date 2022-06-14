package wypozyczalniaKsiazek;

import java.util.HashMap;

/**
 * Created by Miłosz on 04.06.2022
 */
public class Biblioteka {

    private HashMap<String, Ksiazki> ksiazkiHashMap = new HashMap<>(); //https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html; https://cupofcodes.pl/co-powinienes-wiedziec-o-hash-map/

    public void dodawanieKsiazek(Ksiazki ksiazki) {
        ksiazkiHashMap.put(ksiazki.getTytul(), ksiazki);
    }

    public void listaKsiazek(){
        System.out.println("Lista ksiazek: ");
        for (Ksiazki ksiazki: ksiazkiHashMap.values()) {
            System.out.println(ksiazki);
        }
    }

    public void pokazDostepneKsiazki() {
        System.out.println("Lista dostęnych ksiazek: ");
        for (Ksiazki ksiazki : ksiazkiHashMap.values())
            if(!ksiazki.isWypozyczenieKsiazki()) {
                System.out.println(ksiazki);
            }
    }


    public void wypozyczenie(String tytul) {
        ksiazkiHashMap.get(tytul).setWypozyczenieKsiazki(true);
        System.out.println("Książka o numerze " + tytul+ " została wypożyczona");
    }

    public void zwrot(String tytul) {
        ksiazkiHashMap.get(tytul).setWypozyczenieKsiazki(false);
        System.out.println("Książka o numerze " + tytul + " została zwrócona");
    }
}
