package ua.dragunov.threads;

public class NumberPrimeCheckingThread implements Runnable {
    private final NumberProcessor numberProcessor;

    public NumberPrimeCheckingThread(NumberProcessor numberProcessor) {
        this.numberProcessor = numberProcessor;
    }


    @Override
    public void run() {
        boolean isPrime = true;
        Integer number = numberProcessor.getNumber();
        for (int i = 2; i < number / 2; i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }

        if (isPrime) System.out.printf("%d is prime\n", number);
        numberProcessor.increment();
    }

}


