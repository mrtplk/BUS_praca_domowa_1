package com.company;

import java.io.PrintStream;
import java.math.BigInteger;
import java.util.Scanner;
import static java.lang.Math.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Wpisz mała liczbe nr 1");
        BigInteger l1 = scan.nextBigInteger();
        System.out.println("Wpisz mała liczbe nr 2");
        BigInteger l2 = scan.nextBigInteger();

        BigInteger sum = l1.add(l2);
        BigInteger sub = l1.subtract(l2);
        BigInteger mul= l1.multiply(l2);
        BigInteger mod = l1.modInverse(l2);

        System.out.println("Wynik dodawania: " + sum);
        System.out.println("Wynik odejmowania: " + sub);
        System.out.println("Wynik mnożenia: " + mul);
        System.out.println("Liczenie odwrotności elementu ciała (liczby) modulo duża liczba pierwsza p: " + mod);

        BigInteger bigL = BigInteger(1024,)
    }
}
