package ua.dragunov.io;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        FilesContentMatcher filesContentMatcher = new FilesContentMatcher();

        System.out.println(filesContentMatcher.findLinesInFilesByRegExp("D:/IdeaProjects/JavaCore/files", "(\\d)|(apple)|(is|of)"));
    }
}
