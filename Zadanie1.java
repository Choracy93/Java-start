package com.ap.student;

public class Zadanie1 {

    public static void main(String[] args) {

        String abc = new String("Abrakadabra");

        int last = abc.length();
        char lastchar = abc.charAt(last -1);

        int count = 0;

        for (int i = 0; i < last ; i++) {
            if(abc.charAt(i) == lastchar){
               count++;
            }
        }

        System.out.println(count);
    }
}
