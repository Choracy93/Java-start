package wypozyczalniaKsiazek;


public class Ksiazki {
    private String autor;
    private String tytul;
    private String gatunek;
    private String wydawnictwo;
    private int rokWydania;
    private boolean wypozyczenieKsiazki = false;

    public Ksiazki(String autor, String tytul, String gatunek, String wydawnictwo, int rokWydania) {
        this.autor = autor;
        this.tytul = tytul;
        this.gatunek = gatunek;
        this.wydawnictwo = wydawnictwo;
        this.rokWydania = rokWydania;
    }


    public String getAutor() {
        return autor;
    }

    public String getTytul() {
        return tytul;
    }

    public String getGatunek() {
        return gatunek;
    }

    public String getWydawnictwo() {
        return wydawnictwo;
    }

    public int getRokWydania() {
        return rokWydania;
    }

    public boolean isWypozyczenieKsiazki() {
        return wypozyczenieKsiazki;
    }

    public void setWypozyczenieKsiazki(boolean wypozyczenieKsiazki) {
        this.wypozyczenieKsiazki = wypozyczenieKsiazki;
    }

    @Override
    public String toString() {
        return "Ksiazki{" +
                ", autor='" + autor + '\'' +
                ", tytul='" + tytul + '\'' +
                ", gatunek='" + gatunek + '\'' +
                ", wydawnictwo='" + wydawnictwo + '\'' +
                ", rokWydania=" + rokWydania +
                ", wypozyczenieKsiazki=" + wypozyczenieKsiazki +
                '}';
    }
}
