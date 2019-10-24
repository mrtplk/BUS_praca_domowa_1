package com.company;

import java.io.PrintStream;
import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;
import static java.lang.Math.*;


public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Calculator calculator = new Calculator();
        Random rand = new Random();
        BigInteger b1 = new BigInteger(1024, rand); // (2^4-1) = 15 is the maximum value
        //BigInteger b2 = new BigInteger(1024, rand);
        //BigInteger b2 = new BigInteger("3");
        BigInteger b2 =BigInteger.probablePrime(1024, rand);

        System.out.println("Wpisz mała liczbe nr 1");
        BigInteger l1 = scan.nextBigInteger();
        System.out.println("Wpisz mała liczbe nr 2");
        BigInteger l2 = scan.nextBigInteger();

        BigInteger a =calculator.add(l1,l2);
        BigInteger b =calculator.sub(l1,l2);
        BigInteger c =calculator.mul(l1,l2);
        BigInteger d =calculator.mod(l1,l2);

        BigInteger e =calculator.add(b1,b2);
        BigInteger f =calculator.sub(b1,b2);
        BigInteger g =calculator.mul(b1,b2);
        BigInteger h =calculator.mod(b1,b2);
        /*
        int wybor = menu();

        switch(wybor){
            case 1:
                int a, b;
                System.out.println("Podaj dwie liczby do zsumowania");
                a = in.nextInt();
                b = in.nextInt();

                int wynik = suma(a,b);

                System.out.format("Suma liczb wynosi "+wynik);

                break;

            case 2:
                System.out.println("Podaj liczbę do obliczenia sinusa");
                a = in.nextInt();

                double wynik2 = sinus(a);

                System.out.format("Sinus wynosi "+wynik2);

                break;

            case 3:
                informacja();

        }
        */
        System.out.println("Wynik dodawania: " + a);
        System.out.println("Wynik odejmowania: " + b);
        System.out.println("Wynik mnożenia: " + c);
        System.out.println("Liczenie odwrotności elementu ciała (liczby) modulo duża liczba pierwsza p: " + d);

        System.out.println("Duza liczba nr 1: " + b1);
        System.out.println("Duza liczba nr 2: " + b2);
        System.out.println("Wynik dodawania: " + e);
        System.out.println("Wynik odejmowania: " + f);
        System.out.println("Wynik mnożenia: " + g);
        System.out.println("Liczenie odwrotności elementu ciała (liczby) modulo duża liczba pierwsza p: " + h);


    }

    public static int menu(){
        System.out.println();
        System.out.println("     ****************************************");
        System.out.println("     *                 MENU                 *");
        System.out.println("     ****************************************");
        System.out.println("     1. Suma");
        System.out.println("     2. Sinus");
        System.out.println("     3. Informaja");
        System.out.println("     0. Koniec");

        Scanner in = new Scanner(System.in);
        int w = in.nextInt();

        return w;
    }
}
