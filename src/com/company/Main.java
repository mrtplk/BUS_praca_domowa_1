package com.company;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.Scanner;
import static java.lang.Math.*;


public class Main {

    public static void main(String[] args) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, IOException {

        Scanner scan = new Scanner(System.in);
        Calculator calculator = new Calculator();
        Random rand = new Random();

        Boolean carryOn = true;

        while(carryOn) {
            int choice = menu();
            switch (choice) {
                case 0:
                    carryOn=false;

                    break;
                case 1:
                    System.out.println("Wpisz mała liczbe nr 1");
                    BigInteger l1 = scan.nextBigInteger();
                    System.out.println("Wpisz mała liczbe nr 2");
                    BigInteger l2 = scan.nextBigInteger();

                    BigInteger a = calculator.add(l1, l2);
                    BigInteger b = calculator.sub(l1, l2);
                    BigInteger c = calculator.mul(l1, l2);
                    BigInteger d = calculator.mod(l1, l2);

                    System.out.println("Wynik dodawania: " + a);
                    System.out.println("Wynik odejmowania: " + b);
                    System.out.println("Wynik mnożenia: " + c);
                    System.out.println("Liczenie odwrotności elementu ciała (liczby) modulo duża liczba pierwsza p: " + d);

                    break;

                case 2:
                    BigInteger b1 = new BigInteger(1024, rand); // (2^4-1) = 15 is the maximum value
                    BigInteger b2 = BigInteger.probablePrime(1024, rand);

                    BigInteger e = calculator.add(b1, b2);
                    BigInteger f = calculator.sub(b1, b2);
                    BigInteger g = calculator.mul(b1, b2);
                    BigInteger h = calculator.mod(b1, b2);

                    System.out.println("Duza liczba nr 1: " + b1);
                    System.out.println("Duza liczba nr 2: " + b2);
                    System.out.println("Wynik dodawania: " + e);
                    System.out.println("Wynik odejmowania: " + f);
                    System.out.println("Wynik mnożenia: " + g);
                    System.out.println("Liczenie odwrotności elementu ciała (liczby) modulo duża liczba pierwsza p: " + h);

                    break;

                case 3:
                    //Encryption ee = new Encryption();
                    //byte[] e1 = ee.encrypt();
                    //ee.decrypt(e1);
                    final String secretKey = "ssshhhhhhhhhhh!!!!";


                    String originalString = readingFromFile("/Users/marta/IdeaProjects/BUS_praca_domowa_1/src/com/company/message.txt");
                    System.out.print(originalString);

                    String encryptedString = AES.encrypt(originalString, secretKey) ;
                    String decryptedString = AES.decrypt(encryptedString, secretKey) ;

                    //System.out.println(originalString);
                    System.out.println("Zaszyforwane dane: " + encryptedString);
                    System.out.println("Odszyfrowane dane " + decryptedString);
                    carryOn=false;
                    break;
                case 4:
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
        }
    }

    public static int menu(){
        System.out.println();
        System.out.println("     ****************************************");
        System.out.println("     *                 MENU                 *");
        System.out.println("     ****************************************");
        System.out.println("     1. Zad 1");
        System.out.println("     2. Zad 2");
        System.out.println("     3. Zad 3");
        System.out.println("     4. Zad 4");
        System.out.println("     0. Koniec");

        Scanner in = new Scanner(System.in);
        int w = in.nextInt();

        return w;
    }
    public static String readingFromFile(String path) throws IOException {
        FileInputStream file = new FileInputStream(path);
        BufferedReader bf = new BufferedReader(new InputStreamReader(file));
        StringBuilder str = new StringBuilder();
        String line = bf.readLine();
        while (line != null){
            str.append(line);
            str.append(System.lineSeparator());
            line = bf.readLine();
        }
        String result = str.toString();
        return result;
    }

}
