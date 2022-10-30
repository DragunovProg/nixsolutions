package ua.dragunov;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Util class executing a concurrency algorithm to feeding all philosophers  around the table
 * */
public class DiningPhilosophersHandler {
    private Lock leftForkLock = new ReentrantLock();
    private Lock rightForkLock = new ReentrantLock();

    public void dining(int philosopher,
                       Runnable pickLeftFork,
                       Runnable pickRightFork,
                       Runnable eat,
                       Runnable putLeftFork,
                       Runnable putRightFork) throws InterruptedException {


        while(true) {
            if(leftForkLock.tryLock()) {
                try {
                    pickLeftFork.run();

                    if (rightForkLock.tryLock()) {
                        try {
                            pickRightFork.run();
                            eat.run();
                            putRightFork.run();

                            return;
                        } finally {
                            rightForkLock.unlock();
                        }
                    }


                } finally {
                    putLeftFork.run();
                    leftForkLock.unlock();
                }
            }
        }
    }
}
