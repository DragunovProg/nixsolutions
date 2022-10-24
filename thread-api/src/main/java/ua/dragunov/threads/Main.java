package ua.dragunov.threads;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        var scanner = new Scanner(System.in);
        NumberProcessor numberProcessor = new NumberProcessor();
        NumberGenerationThread numberGenerationThread = new NumberGenerationThread(numberProcessor);
        NumberPrimeCheckingThread numberPrimeCheckingThread = new NumberPrimeCheckingThread(numberProcessor);

        Thread generationThread = new Thread(numberGenerationThread);
        Thread checkingThread = new Thread(numberPrimeCheckingThread);

        numberProcessor.generate(generationThread);
        numberProcessor.checking(checkingThread);

    }
}
