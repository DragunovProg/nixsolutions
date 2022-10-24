package ua.dragunov.threads;

public class NumberProcessor {
    private volatile Integer number = 0;
    private int checkingCount = 0;


    public synchronized void generate(NumberGenerationThread numberGenerationThread) {
        numberGenerationThread.run();
    }

    public synchronized void checking(NumberPrimeCheckingThread numberPrimeCheckingThread) {
            numberPrimeCheckingThread.run();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public int getCheckingCount() {
        return checkingCount;
    }

    public synchronized void increment() {
        checkingCount++;
    }
}
