package ua.dragunov;


import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Util class executing a concurrency algorithm to feeding all philosophers  around the table
 * */
public class DiningPhilosophersHandler {
    private Lock forks[] = new Lock[5];
    private Semaphore semaphore = new Semaphore(4);

    public DiningPhilosophersHandler() {
        for (int i = 0; i < 5; i++)
            forks[i] = new ReentrantLock();
    }


    public void dining(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException
    {
        int leftFork = philosopher;
        int rightFork = (philosopher + 4) % 5;

        forks[leftFork].lock();
        forks[rightFork].lock();
        pickLeftFork.run();
        pickRightFork.run();

        semaphore.acquire();

        eat.run();

        putRightFork.run();
        putLeftFork.run();
        forks[rightFork].unlock();
        forks[leftFork].unlock();

        semaphore.release();
    }
}
