package wypozyczalniaKsiazek;

import java.util.HashMap;

public class BazaUzytkownikow {

    private HashMap<String, Uzytkownik> uzytkownicy = new HashMap<>();

    public void dodawanieUzytkownika(Uzytkownik uzytkownik) {
        uzytkownicy.put(uzytkownik.getNazwisko(), uzytkownik);
    }

    public void listaUzytkownikow() {
        System.out.println("Lista użytkowników");
        for (Uzytkownik uzytkownik: uzytkownicy.values()) {
            System.out.println(uzytkownik);
        }
    }
}
