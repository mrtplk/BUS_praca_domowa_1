package com.company;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.Scanner;
import static java.lang.Math.*;

public class Calculator {


    public Calculator(){
    }

    public BigInteger add(BigInteger a, BigInteger b){
        return a.add(b);
    }
    public BigInteger sub(BigInteger a, BigInteger b) { return a.subtract(b); }
    public BigInteger mul(BigInteger a, BigInteger b){
        return a.multiply(b);
    }
    public BigInteger mod(BigInteger a, BigInteger b) { return a.modInverse(b); }

    //~Calculator();
}
