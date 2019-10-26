package com.company;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class AES {
    private static SecretKeySpec secretKey; //1
    private static byte[] key;

    public static void setKey(String myKey)
    {
        MessageDigest sha = null; //2
        try {
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1"); //3 - Returns a MessageDigest object that implements the specified digest algorithm
            key = sha.digest(key); //4 - Performs a final update on the digest using the specified array of bytes, then completes the digest computation.
            key = Arrays.copyOf(key, 16); //It copies the specified array, truncating or padding with false (if necessary) so the copy has the specified length.
            secretKey = new SecretKeySpec(key, "AES"); //5- Constructs a secret key from the given byte array.
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    public static String encrypt(String strToEncrypt, String secret)
    {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding"); //This class provides the functionality of a cryptographic cipher for encryption and decryption.
            //In order to create a Cipher object, the application calls the Cipher's getInstance method, and passes the name of the requested transformation to it. Optionally, the name of a provider may be specified.
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8"))); //static methods for obtaining encoders and decoders for the Base64 encoding scheme.
            //Finishes a multiple-part encryption or decryption operation, depending on how this cipher was initialized. - doFinal
        }
        catch (Exception e)
        {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }

    public static byte[] encrypt_bytes(byte[] byteToEncrypt, String secret)
    {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding"); //This class provides the functionality of a cryptographic cipher for encryption and decryption.
            //In order to create a Cipher object, the application calls the Cipher's getInstance method, and passes the name of the requested transformation to it. Optionally, the name of a provider may be specified.
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return cipher.doFinal(byteToEncrypt); //static methods for obtaining encoders and decoders for the Base64 encoding scheme.
            //Finishes a multiple-part encryption or decryption operation, depending on how this cipher was initialized. - doFinal
        }
        catch (Exception e)
        {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }

    public static String decrypt(String strToDecrypt, String secret)
    {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        }
        catch (Exception e)
        {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }

    public static byte[] decrypt_bytes(byte[] byteToDecrypt, String secret)
    {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return cipher.doFinal(byteToDecrypt);
        }
        catch (Exception e)
        {
            System.out.println("Error while decrypting: " + e.toString());
        }
        System.out.println("Zły klucz!!!!!");
        return null;
    }

}
