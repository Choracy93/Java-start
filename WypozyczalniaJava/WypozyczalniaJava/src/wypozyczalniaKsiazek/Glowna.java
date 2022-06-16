package wypozyczalniaKsiazek;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Glowna {

    public static void main(String[] args) {

        Biblioteka biblioteka = new Biblioteka();

        String operacja;
        do {
            operacja = wyswietl("opcje: dodaj, wyswietl, wypożycz, zwrot, pokaż dostępne, wyjdz, wczytaj");
            if ("dodaj".equalsIgnoreCase(operacja)) {
                dodajKsiazke(biblioteka);
            } else if (!"wczytaj".equalsIgnoreCase(operacja)){
                biblioteka.Wczytaj();
            } else if ("wyswietl".equalsIgnoreCase(operacja)) {
                biblioteka.listaKsiazek();
            } else if ("wypożycz".equalsIgnoreCase(operacja)) {
                String tytul = wyswietl("tytul");
                biblioteka.wypozyczenie(tytul);
            } else if("zwrot".equalsIgnoreCase(operacja)) {
                String tytul = wyswietl("tytul");
                biblioteka.zwrot(tytul);
            } else if ("pokaż dostępne".equalsIgnoreCase(operacja)){
                biblioteka.pokazDostepneKsiazki();
            } else if (!"wyjdz".equalsIgnoreCase(operacja)){
                System.out.println("Nieprawidłowy wybór ");
            }
        } while(!"wyjdz".equalsIgnoreCase(operacja));


    }

    public static void dodajKsiazke(Biblioteka biblioteka) {
        String autor = wyswietl(" autora ");
        String tytul = wyswietl(" tytul ");
        String gatunek = wyswietl(" gatunek ");
        String wydawnictwo = wyswietl(" wydawnictwo ");
        String rokWydania = wyswietl(" rok wydania ");

        Ksiazki ksiazki = new Ksiazki(autor, tytul, gatunek, wydawnictwo,
                Integer.valueOf(rokWydania));

        biblioteka.dodawanieKsiazek(ksiazki);
         PrintWriter zapis = null;
        try {
            zapis = new PrintWriter("src/ksiazki.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        zapis.println(ksiazki);
        zapis.close();

    }

    private static String wyswietl(String dane) {
        System.out.println("");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj/Wybierz " + dane);
        String tresc = scanner.nextLine();
        System.out.println("Wybrano : " + tresc);

       /* PrintWriter zapis = null;
        try {
            zapis = new PrintWriter("src/ksiazki.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        zapis.println();
        zapis.close(); */

        return tresc;
    }
}
