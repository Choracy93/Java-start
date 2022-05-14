package com.ap.student;

public class Zadanie3 {

    public static void main(String[] args) {

        String abc = new String("kajak");

        StringBuilder reverseText = new StringBuilder(abc);

        reverseText.reverse();

        if (abc.contentEquals(reverseText)) {
            System.out.println("Podany znak to palindrom");
        } else {
            System.out.println("Podany znak to nie jest palindrom");
        }



    }
}
