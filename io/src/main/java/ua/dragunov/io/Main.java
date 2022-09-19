package ua.dragunov.io;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        FilesContentMatcher filesContentMatcher = new FilesContentMatcher();

        System.out.println(filesContentMatcher.findLinesInFilesByRegExp(input.next(), input.next()));
    }
}
