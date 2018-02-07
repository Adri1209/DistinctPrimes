package main;

import java.util.Arrays;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class PrimeVector implements Runnable {

    private int[] vector;
    private CyclicBarrier cyclicBarrier;
    private Application application;
    private int result;


    public PrimeVector(int order, Application application, CyclicBarrier cyclicBarrier) {
        if (order % 2 == 0) order--;
        vector = new int[order];
        this.application = application;
        this.cyclicBarrier = cyclicBarrier;
        result = 0;
    }

    public void fillPrimeVector() {
        MersenneTwisterFast randomGenerator = new MersenneTwisterFast();
        int index = 0;
        while (index < vector.length) {
            int prime = randomGenerator.nextInt(1000);
            if (isPrime(prime)) {
                vector[index] = prime;
                index++;
            }
        }
        System.out.println(hashCode()+ " " + Arrays.toString(vector));


    }

    public void execute() {

        for (int i = 3; i <= vector.length; i += 2) {
            int max = i;

            for (int j = 0; j < vector.length - (i - 1); j++) {

                int number = 0;
                for (int k = j; k < max; k++) {
                    number += vector[k];
                }
                if (isPrime(number)) {
                    result++;
                }
                max++;
            }
        }
        application.updateTotalNumberOfPrimes(result);
    }

    public boolean isPrime(int number) {
        if (number % 2 == 0)
            return false;

        for (int i = 3; i * i <= number; i += 2)
            if (number % i == 0)
                return false;

        return true;
    }

    public void run() {
        fillPrimeVector();
        execute();
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }
}
