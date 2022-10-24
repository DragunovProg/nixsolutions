package ua.dragunov.threads;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        var scanner = new Scanner(System.in);
        NumberProcessor numberProcessor = new NumberProcessor();
        NumberGenerationThread numberGenerationThread = new NumberGenerationThread(numberProcessor);
        NumberPrimeCheckingThread numberPrimeCheckingThread = new NumberPrimeCheckingThread(numberProcessor);

        while (numberProcessor.getCheckingCount() < 10) {
            numberProcessor.generate(numberGenerationThread);
            numberProcessor.checking(numberPrimeCheckingThread);
        }
    }
}
