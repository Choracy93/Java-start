package wypozyczalniaKsiazek;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class Biblioteka {

    private HashMap<String, Ksiazki> ksiazkiHashMap = new HashMap<>(); //https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html; https://cupofcodes.pl/co-powinienes-wiedziec-o-hash-map/

    public void dodawanieKsiazek(Ksiazki ksiazki) {
        ksiazkiHashMap.put(ksiazki.getTytul(), ksiazki);
    }

    public void listaKsiazek(){
        System.out.println("Lista ksiazek: ");
        for (Ksiazki ksiazki: ksiazkiHashMap.values()) {
            System.out.println(ksiazki);
          /* PrintWriter zapis = null;
            try {
                zapis = new PrintWriter("src/ksiazki.txt");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            zapis.println(ksiazki);
            zapis.close();*/
        }
    }

    /*public void Wczytaj() {
        System.out.println("Wczytano: ");

        Path path = Paths.get("src/ksiazki.txt");
        try {
            List<String> lines = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

  /* public void Wczytaj() {
        System.out.println("Wczytano: ");
        File file = new File("src/ksiazki.txt");
        Scanner in = null;
        try {
            in = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String zdanie = in.nextLine();
        System.out.println(zdanie);
    } */

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
