package com.company;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, IOException {

        Scanner scan = new Scanner(System.in);
        Calculator calculator = new Calculator();
        Random rand = new Random();

        boolean carryOn = true;

        while(carryOn) {
            int choice = menu();
            switch (choice) {
                case 0:
                    carryOn=false;
                    break;

                case 1:
                    System.out.println("Wpisz mała liczbe nr 1");
                    BigInteger l1 = scan.nextBigInteger();
                    System.out.println("Wpisz mała liczbe nr 2 (musi to być liczba pierwsza, np 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 itd.)");
                    BigInteger l2 = scan.nextBigInteger();

                    BigInteger a = calculator.add(l1, l2);
                    BigInteger b = calculator.sub(l1, l2);
                    BigInteger c = calculator.mul(l1, l2);
                    BigInteger d = calculator.mod(l1, l2);

                    System.out.println("Wynik dodawania: " + a);
                    System.out.println("Wynik odejmowania: " + b);
                    System.out.println("Wynik mnożenia: " + c);
                    System.out.println("Liczenie odwrotności elementu ciała (liczby) modulo duża liczba pierwsza p: " + d);

                    carryOn=false;
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

                    carryOn=false;
                    break;

                case 3:
                    String secretKey = readingFromFile("key.txt");
                    String secretKey2 = readingFromFile("key2.txt");
                    System.out.println("Nasz klucz: " + secretKey);

                    byte[] data = fileToBytes("piesek.jpg");
                    System.out.println("Nasz plik przed zaszyfrowaniem:");
                    System.out.println(Arrays.toString(data));

                    System.out.println("Nasz plik po zaszyfrowaniu: ");
                    byte[] encryptedBytes = AES.encrypt_bytes(data, secretKey);

                    //ODKOMENTOWAC PODPUNKT 2 - BLAD W PLIKU ZASZYFROWAYM
                    //encryptedBytes[5]=112;

                    System.out.println(Arrays.toString(encryptedBytes));
                    System.out.println("Nasz plik po odszyfrowaniu: ");
                    byte[] decryptedBytes = AES.decrypt_bytes(encryptedBytes, secretKey2);

                    //ZAKOMENTOWAC PODPUNKT 2
                    saveBytesAsInage("piesek2.jpg",decryptedBytes);
                    System.out.println(Arrays.toString(decryptedBytes));

                    carryOn=false;
                    break;
                case 4:
                    String originalString = readingFromFile("message.txt");
                    System.out.print(originalString);

                    byte [] msg = originalString.getBytes();
                    //ODKOMENTOWAC PODPUNKT 2
                    //msg[2] = 105;
                    System.out.println("Wiadomosc do obliczenia funkcji skrótu: ");
                    System.out.println(Arrays.toString(msg));
                    MessageDigest md = MessageDigest.getInstance("SHA-256");
                    md.update(msg);
                    byte [] digest = md.digest();
                    System.out.println("Skrót wiadomości: ");
                    System.out.println(Arrays.toString(digest));

                    StringBuffer hexString = new StringBuffer();
                    for(int i = 0; i<digest.length; i++)
                    {
                        hexString.append(Integer.toHexString(0xFF & digest[i]));
                    }
                    System.out.println("Hex format: "+ hexString.toString());

                    carryOn=false;
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

    public static byte[] fileToBytes(String filename) throws IOException {
            BufferedImage bImage = ImageIO.read(new File(filename));
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ImageIO.write(bImage, "jpg", bos);
            byte [] data = bos.toByteArray();
            return data;
        }

    public static void saveBytesAsInage(String filename, byte[] what) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(what);
        BufferedImage image = ImageIO.read(bis);
        ImageIO.write(image, "jpg", new File(filename));
    }
}
