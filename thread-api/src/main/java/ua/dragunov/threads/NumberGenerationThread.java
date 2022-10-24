package ua.dragunov.threads;

import java.util.concurrent.ThreadLocalRandom;

public class NumberGenerationThread implements Runnable{
    private final NumberProcessor numberProcessor;

    public NumberGenerationThread(NumberProcessor numberProcessor) {
        this.numberProcessor = numberProcessor;
    }

    @Override
    public void run() {
        synchronized (numberProcessor) {
            while (numberProcessor.getCheckingCount() < 10) {
                if (numberProcessor.isWrite() == false) {
                    numberProcessor.setNumber(ThreadLocalRandom.current().nextInt(2000));
                    numberProcessor.setWrite(true);
                    numberProcessor.notify();
                } else {
                    try {
                        numberProcessor.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }


}
