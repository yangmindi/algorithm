package com.ymd.hdu.test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class test {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int count = 1;
            int temp = n;
            while(n>0){
                BigInteger a = scanner.nextBigInteger();
                BigInteger b = scanner.nextBigInteger();
                System.out.println("Case "+count+":");
                System.out.println(a+" + "+b+" = "+a.add(b));
                if(count!=temp){
                    System.out.println();
                }
                count++;
                n--;
            }
        }
    }

}
