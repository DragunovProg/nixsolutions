package ua.dragunov.exception;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Retry retry = new Retry();
        retry.retry(1000, 4, () -> {
            Scanner scanner = new Scanner(System.in);
            System.out.println(scanner.nextInt() / scanner.nextInt());
        });
    }
}
