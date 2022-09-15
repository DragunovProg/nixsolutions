package ua.dragunov.io;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        FilesContentMatcher filesContentMatcher = new FilesContentMatcher();

        System.out.println(filesContentMatcher.findLinesInFilesByRegExp(input.next(), input.next()));
    }
}
