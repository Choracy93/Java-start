package wypozyczalniaKsiazek;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Glowna {

    public static void main(String[] args) {

        Biblioteka biblioteka = new Biblioteka();
        BazaUzytkownikow bazaUzytkownikow = new BazaUzytkownikow();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Wybierz: 1 - książki, pozostałe - użytkownicy ");
        int wybor = scanner.nextInt();

        if (wybor == 1) {

            String operacja;
            do {
                operacja = wyswietl("opcje: dodaj, wczytaj, wyswietl, wypożycz, zwrot, pokaż dostępne, wyjdz");
                if ("dodaj".equalsIgnoreCase(operacja)) {
                    dodajKsiazke(biblioteka);
                } else if ("wczytaj".equalsIgnoreCase(operacja)){
                    wczytaj(biblioteka);
                    // biblioteka.Wczytaj();
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
        } else {

            String dzialanie;
            do {
                dzialanie = wyswietlUzytkownika("Opcje: dodaj, wczytaj, wyswietl, usun, wyjdz");
                if ("dodaj".equalsIgnoreCase(dzialanie)){
                    dodajUzytkownika(bazaUzytkownikow);
                } else if ("wczytaj".equalsIgnoreCase(dzialanie)){
                        wczytajUzytkownika(bazaUzytkownikow);
                }else if("wyswietl".equalsIgnoreCase(dzialanie)){
                    bazaUzytkownikow.listaUzytkownikow();
                } else if ("usun".equalsIgnoreCase(dzialanie)) {
                    System.out.println("Opcja w przygorowaniu ");
                } else if ("!wyjdz".equalsIgnoreCase(dzialanie)){
                    System.out.println("Nieprawidlowy wybór");
                }
            } while(!"wyjdz".equalsIgnoreCase(dzialanie));
        }

       /* Biblioteka biblioteka = new Biblioteka();

        String operacja;
        do {
            operacja = wyswietl("opcje: dodaj, wczytaj, wyswietl, wypożycz, zwrot, pokaż dostępne, wyjdz");
            if ("dodaj".equalsIgnoreCase(operacja)) {
                dodajKsiazke(biblioteka);
            } else if ("wczytaj".equalsIgnoreCase(operacja)){
                Wczytaj(biblioteka);
                // biblioteka.Wczytaj();
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

*/
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
        PrintWriter zapis = null;
        try {
            zapis = new PrintWriter("src/ksiazki.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        zapis.println(ksiazki);
        zapis.close();

    }

    private static void wczytaj(Biblioteka biblioteka) {
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


    private static void dodajUzytkownika(BazaUzytkownikow bazaUzytkownikow) {
        String imie = wyswietlUzytkownika(" imie ");
        String nazwisko = wyswietl(" nazwisko ");


        Uzytkownik uzytkownik = new Uzytkownik(imie, nazwisko);

        bazaUzytkownikow.dodawanieUzytkownika(uzytkownik);
        PrintWriter zapisUzytkownika = null;
        try {
            zapisUzytkownika = new PrintWriter("src/uz.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        zapisUzytkownika.println(uzytkownik);
        zapisUzytkownika.close();

    }

    private static void wczytajUzytkownika(BazaUzytkownikow bazaUzytkownikow) {
        System.out.println("Wczytano: ");
        File file = new File("src/uz.txt");
        Scanner in = null;
        try {
            in = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String nazwa = in.nextLine();
        System.out.println(nazwa);
    }


    private static String wyswietlUzytkownika(String wyswietlanieU) {
        System.out.println("");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wybierz" + wyswietlanieU);
        String informacja = scanner.nextLine();
        System.out.println("Wybrano : " + informacja);
        return informacja;
    }

}