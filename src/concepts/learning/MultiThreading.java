package concepts.learning;

import java.util.concurrent.ExecutionException;

public class MultiThreading {

    public static int factorial(int num) {
        if (num == 1)
            return num;
        return num * factorial(num-1);
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int number = 2;
        System.out.println("Factorial of " + 10 + " is: " + factorial(10));

        Thread newThread = new Thread(() -> {
            System.out.println("Factorial of " + number + " is: " + factorial(number));
        });
        newThread.start();
//        Thread.sleep(1000);

        System.out.println("Factorial of " + 11 + " is: " + factorial(11));

        Thread newThread2 = new Thread(() -> {
            System.out.println("Factorial of " + 3 + " is: " + factorial(3));
        });
        newThread2.start();


        System.out.println("Factorial of " + 12 + " is: " + factorial(12));

        Thread newThread3 = new Thread(() -> {
            System.out.println("Factorial of " + 4 + " is: " + factorial(4));
        });
        newThread3.start();
    }
}
