package com.company;

import java.io.*;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class Encryption {
    public Encryption() {
    }
    //byte[] key = new BigInteger("011001111010010101111111111111111111111");
    String str_key = "01100111101001010111111111111111";
    byte[] key = str_key.getBytes();
    BigInteger text = new BigInteger("000111011111011110111000111100001000001100010111010111110001110000100111110000100101111110010011100101011001111110010101110110110111");
    String str = "hello";
    byte[] byteArr = str.getBytes();
    String key1 = "hi";
    //BigInteger text_after;
    public byte[] encrypt() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher c = Cipher.getInstance("AES");
        SecretKeySpec k = new SecretKeySpec(key, "AES");
        c.init(Cipher.ENCRYPT_MODE, k);
        byte[] encryptedData = c.doFinal(str.getBytes());
        System.out.println("Encrypted data"+encryptedData);
        return encryptedData;

    }
    public void decrypt(byte[] encryptedData) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher c = Cipher.getInstance("AES");
        SecretKeySpec k = new SecretKeySpec(key, "AES");
        c.init(Cipher.DECRYPT_MODE, k);
        byte[] data = c.doFinal(encryptedData);
        String data_ti_string = data.toString();
        System.out.println("Decrypted data" + data_ti_string);
    }


    /*
    public BigInteger getPublicKey() throws FileNotFoundException {
        File file = new File("key.txt");
    BufferedReader br = new BufferedReader(new FileReader(file));
        String key = " ";
        try {

            key = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(key);
        BigInteger result = new BigInteger(key);
        return result;
    }
     */
}

