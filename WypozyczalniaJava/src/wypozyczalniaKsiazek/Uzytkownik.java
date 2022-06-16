package wypozyczalniaKsiazek;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class Uzytkownik {
    private String imie;
    private String nazwisko;
    private boolean czyWypozyczyl;

    public Uzytkownik(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }
}



  /*  public static void main(String[] args) throws IOException {

        int count =0;
        try{
            File myObj = new File ("src/uz.txt");
            Scanner Reader= new Scanner(myObj);
            while(Reader.hasNextLine()){
                String data = Reader.nextLine();
                System.out.println(data);
            }
            Reader.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Błąd");
            e.printStackTrace();
        }

    }
}*/

