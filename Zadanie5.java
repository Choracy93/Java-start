/**
 * Created by Miłosz on 14.05.2022
 */
public class Zadanie5 {
    public Zadanie5() {
    }

    public static void main(String[] args) {
        String a = "2 * (3.4 - (-7)/2)*(a-2)/(b-1)))";
        String b = "2 * (3.4 - (-7/2)*(a-2)/(b-1))";
        char open = 40;
        char close = 41;
        int count = 0;

        int i;
        for(i = 0; i < a.length(); ++i) {
            if (a.charAt(i) == open) {
                ++count;
            }

            if (a.charAt(i) == close) {
                --count;
            }
        }

        System.out.print("Przykład a: ");

        if (count == 0) {
            System.out.print("OK");
        } else {
            System.out.print("Błędne sparowanie nawiasów");
        }

        count = 0;

        for(i = 0; i < b.length(); ++i) {
            if (b.charAt(i) == open) {
                ++count;
            }

            if (b.charAt(i) == close) {
                --count;
            }
        }

        System.out.print("\nPrzykład b: ");

        if (count == 0) {
            System.out.print("OK");
        } else {
            System.out.print("Błędne sparowanie nawiasów");
        }

    }
}
