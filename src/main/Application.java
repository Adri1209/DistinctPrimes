package main;

import java.util.concurrent.CyclicBarrier;

public class Application {
    private int totalNumberOfPrimes = 0;


    public void execute() {
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(Configuration.instance.numberOfCores);

        Thread[] threads = new Thread[Configuration.instance.numberOfCores];

        long runtime = System.currentTimeMillis();

        for (int i = 0; i < threads.length; i++) {

            threads[i] = new Thread(new PrimeVector(Configuration.instance.order, this, cyclicBarrier));
            threads[i].start();
        }

        for (int j = 0; j < threads.length; j++) {
            try {
                threads[j].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println();
        System.out.println("runtime (ms)        : " + (System.currentTimeMillis() - runtime));
        System.out.println("totalNumberOfPrimes : " + totalNumberOfPrimes);
    }

    public void updateTotalNumberOfPrimes(int numberOfPrimes) {
        this.totalNumberOfPrimes += numberOfPrimes;
    }

    public static void main(String... args) {

        Application application = new Application();
        application.execute();

    }
}
