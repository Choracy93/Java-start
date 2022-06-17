package wypozyczalniaKsiazek;


import java.util.HashMap;
import java.util.Scanner;

public class BazaUzytkownikow {

    private HashMap<String, Uzytkownik> uzytkownicy = new HashMap<>();

    public void dodajUzytkownika(Uzytkownik uzytkownik) {
        uzytkownicy.put(uzytkownik.getNazwisko(), uzytkownik);

    }
}
