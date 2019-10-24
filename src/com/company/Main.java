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
        System.out.print("Wynik dodawania: ");
        System.out.println(sum);


    }
}
