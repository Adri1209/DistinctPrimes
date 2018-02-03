package main;

import java.util.concurrent.CyclicBarrier;

public class Application {
    private int totalNumberOfPrimes = 0;



    public void execute() {
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(Configuration.instance.numberOfCores);

        Thread task01 = new Thread(new PrimeVector(Configuration.instance.order, this, cyclicBarrier));
        Thread task02 = new Thread(new PrimeVector(Configuration.instance.order, this, cyclicBarrier));
        Thread task03 = new Thread(new PrimeVector(Configuration.instance.order, this, cyclicBarrier));
        Thread task04 = new Thread(new PrimeVector(Configuration.instance.order, this, cyclicBarrier));
        Thread task05 = new Thread(new PrimeVector(Configuration.instance.order, this, cyclicBarrier));
        Thread task06 = new Thread(new PrimeVector(Configuration.instance.order, this, cyclicBarrier));
        Thread task07 = new Thread(new PrimeVector(Configuration.instance.order, this, cyclicBarrier));
        Thread task08 = new Thread(new PrimeVector(Configuration.instance.order, this, cyclicBarrier));


        long runtime = System.currentTimeMillis();

        task01.start();
        task02.start();
        task03.start();
        task04.start();
        task05.start();
        task06.start();
        task07.start();
        task08.start();

        try {
            task01.join();
            task02.join();
            task03.join();
            task04.join();
            task05.join();
            task06.join();
            task07.join();
            task08.join();
        }
        catch (Exception e){
            e.getStackTrace();
        }

        System.out.println();
        System.out.println("runtime (ms)        : " + (System.currentTimeMillis() - runtime));
        System.out.println("totalNumberOfPrimes : " + totalNumberOfPrimes);
    }

    public void updateTotalNumberOfPrimes(int numberOfPrimes) {
        //System.out.println("NumberOfPrimes: " + numberOfPrimes);
        this.totalNumberOfPrimes += numberOfPrimes;
    }

    private int getRandomNumber(){
        MersenneTwisterFast mersenneTwisterFast = new MersenneTwisterFast();
        int number = mersenneTwisterFast.nextInt(100);
        if (number % 2 == 0) number--;
        return number;
    }

    public static void main(String... args) {

        Application application = new Application();
        application.execute();

    }
}
