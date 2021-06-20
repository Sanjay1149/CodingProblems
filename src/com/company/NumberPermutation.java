package com.company;

import java.util.Scanner;

public class NumberPermutation {

    static int minValue = Integer.MAX_VALUE;

    static int swapNumber(int val, int l, int r) {
        StringBuffer stringBuffer = new StringBuffer(val+"");
        char temp = stringBuffer.charAt(l);
        stringBuffer.setCharAt(l, stringBuffer.charAt(r));
        stringBuffer.setCharAt(r, temp);
        return Integer.parseInt(String.valueOf(stringBuffer));
    }

    public static void permute(int valx, int valy, int l, int r) {
        if ( l == r ) {
            System.out.println("X is " + valx + " and Y is " + valy);
            int diff  = Math.abs(valx - valy);
            if ( diff > 0 && diff < minValue ) {
                System.out.println("New Min value is " + diff);
                minValue = diff;
            }
        } else {
            for ( int i = l ; i <= r; i ++) {
                valx = swapNumber(valx, l ,i);
                valy = swapNumber(valy, l ,i);
                permute(valx, valy,l + 1,r);
                valx = swapNumber(valx, l ,i);
                valy = swapNumber(valy, l ,i);
            }
        }
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the input ");
        int x = in.nextInt();
        int y = in.nextInt();
        permute(x,y,0, String.valueOf(x).length()-1);
        System.out.println("New Min value is " + minValue);
    }
}
