package wypozyczalniaKsiazek;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Glowna {

    public static void main(String[] args) {

        Biblioteka biblioteka = new Biblioteka();

        String operacja;
        do {
            operacja = wyswietl("opcje to - dodaj, wyswietl, wypożycz, zwrot, pokaż dostępne, wyjdz");
            if ("dodaj".equalsIgnoreCase(operacja)) {
                dodajKsiazke(biblioteka);
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

    private static void dodajKsiazke(Biblioteka biblioteka) {
        String autor = wyswietl(" autora ");
        String tytul = wyswietl(" tytul ");
        String gatunek = wyswietl(" gatunek ");
        String wydawnictwo = wyswietl(" wydawnictwo ");
        String rokWydania = wyswietl(" rok wydania ");

        Ksiazki ksiazki = new Ksiazki(autor, tytul, gatunek, wydawnictwo,
                Integer.valueOf(rokWydania));

        biblioteka.dodawanieKsiazek(ksiazki);
    }

    private static String wyswietl(String dane) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Napisz co chcesz zrobić : " + dane);
        String tresc = scanner.nextLine();
        System.out.println("Dodano książki : " + tresc);

        PrintWriter zapis = null;
        try {
            zapis = new PrintWriter("src/ksiazki.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        zapis.println("Ala ma kota, a kot ma Alę");
        zapis.close();

        return tresc;
    }
}
