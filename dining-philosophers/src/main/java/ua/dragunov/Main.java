package ua.dragunov;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        DiningPhilosophersHandler diningPhilosophers = new DiningPhilosophersHandler();
        int n = 2;

        Runnable pickUpLeftFork = () -> {
            System.out.println("picked up left fork by " + Thread.currentThread().getName());
        };
        Runnable pickUpRightFork = () -> {
            System.out.println("picked up right fork by " + Thread.currentThread().getName());
        };

        Runnable eat = () -> {
            System.out.println("eat by " + Thread.currentThread().getName());

        };

        Runnable putDownLeftFork = () -> {
            System.out.println("put down left fork by " + Thread.currentThread().getName());
        };

        Runnable putDownRightFork = () -> {
            System.out.println("put down right fork by " + Thread.currentThread().getName());
        };


        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            int philosopher = i;
            executorService.execute(() -> {
                try {
                    diningPhilosophers.dining(philosopher,
                            pickUpLeftFork,
                            pickUpRightFork,
                            eat,
                            putDownLeftFork,
                            putDownRightFork);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executorService.shutdown();
    }
}
