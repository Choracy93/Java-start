package com.ap.student;

public class Obiekty {

    public static void main(String[] args) {
        String obiekt1 = new String("cos");
        String obiekt2 = new String("cos");
        if(obiekt1.equals(obiekt2)) {
            System.out.println("eq");
        } else {
            System.out.println("ne");
        }
    }

    static int sumujLiczby(int a, int b) {
        return a + b;
    }

    static double sumujLiczby(double a, double b) {
        return a + b;
    }

    static int sumujLiczby(int a, int b, int c) { //przeładowanie metody, zmiana ilości lub typów parametrów
        return a + b + c;
    }
}
