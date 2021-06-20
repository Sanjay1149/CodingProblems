package leetcode.array;

public class ReverseNumber {
    static int maxValue = Integer.MAX_VALUE;

    public static int reverse(int x) {
        int val=0, mod;
        boolean isNegative = false;
        if ( x < 0 ) {
            isNegative = true;
            x = Math.abs(x);
        }
        while( x > 0 ) {
            mod = x%10;
            val = val * 10 + mod;
            x/=10;
        }
        if ( x < 0)
            return 0;

        if ( isNegative )
            val = -val;
        return val;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1013741824));
    }
}
