package hackerrank;

import java.util.Scanner;

public class JavaOneDArray {
    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
        boolean hasReached = false;
        int i = 0;
        while (i != game.length - 1) {
            if ((i + leap > game.length - 1) || i + leap < game.length && game[i + leap] == 0) {
                i += leap;
            } else if (i + leap == game.length - 1 && game[i + leap] == 1) {
                i += leap;
            } else if (i + 1 < game.length) {
                if (game[i + 1] == 0) {
                    i += 1;
                } else if (game[i+1] == 1) {
                    game[i] = -1;
                    i -= 1;
                } else {
                    hasReached = false;
                    break;
                }
            }

            if (i >= game.length - 1) {
                hasReached = true;
            }
        }
        return hasReached;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println((canWin(leap, game)) ? "YES" : "NO");
        }
        scan.close();
    }
}
