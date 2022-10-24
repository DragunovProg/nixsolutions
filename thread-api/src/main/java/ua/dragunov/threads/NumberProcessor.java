package ua.dragunov.threads;

public class NumberProcessor {
    private volatile Integer number = 0;
    private int checkingCount = 0;
    private boolean isWrite = false;


    public void generate(Thread thread) throws InterruptedException {
        thread.start();
    }

    public void checking(Thread thread) throws InterruptedException {
            thread.start();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public synchronized int getCheckingCount() {
        return checkingCount;
    }

    public synchronized void increment() {
        checkingCount++;
    }

    public boolean isWrite() {
        return isWrite;
    }

    public void setWrite(boolean write) {
        isWrite = write;
    }
}
