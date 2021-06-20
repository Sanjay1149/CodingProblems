package com.company;

public class PowerOf2Bits {
    static int countSetBits(int n)
    {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

    // driver program
    public static void main(String args[])
    {
        int i = 16;
        int noOfCounts = countSetBits(i);
        if ( noOfCounts == 1 ) {
            System.out.println("Power of 2");
        } else {
            System.out.println("Not Power of 2");
        }
    }
}
