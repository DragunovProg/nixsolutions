package ua.dragunov.threads;

import java.util.concurrent.ThreadLocalRandom;

public class NumberGenerationThread implements Runnable{
    private final NumberProcessor numberProcessor;

    public NumberGenerationThread(NumberProcessor numberProcessor) {
        this.numberProcessor = numberProcessor;
    }

    @Override
    public void run() {
        numberProcessor.setNumber(ThreadLocalRandom.current().nextInt(2000));
    }


}
