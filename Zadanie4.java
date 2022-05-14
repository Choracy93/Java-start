package com.ap.student;

public class Zadanie4 {

    public static void main(String[] args) {

        String text = new String("Ala ma 1 psa i 2 koty. Jola ma 10 rybek i 2 papugi");

       int suma = 0;

        for (int i = 0; i < suma; i++) {
           if (Character.isDigit(text.charAt(i))) {
               suma += Character.getNumericValue(text.charAt(i));
           }

        }

    }
}
