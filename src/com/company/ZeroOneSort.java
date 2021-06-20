package com.company;

import java.util.Scanner;

public class ZeroOneSort {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution.
        *   7
        *   B R R B B R B
        * */
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String[] inputValues = in.nextLine().split(" ");
        n = n - 1;
        for ( int i = 0; i < n; i++ ) {
            while(inputValues[i].equals("R") && i < n) {
                i++;
            }
            while(inputValues[n].equals("B") && i < n) {
                n--;
            }
            if ( i < n ) {
                inputValues[i] = "R";
                inputValues[n] = "B";
            } else {
                break;
            }
        }
        for ( int i = 0; i < inputValues.length; i++ ) {
            System.out.print(inputValues[i]+ " ");
        }
    }
}
