package ua.dragunov.io;

import java.io.*;
import java.util.Arrays;
import java.util.regex.Pattern;

public class FilesContentMatcher {
    private File[] getFiles(String path) {
        File file = new File(path);

        if (file.isDirectory()) {
            return file.listFiles();
        }

        return new File[] {file};
    }


    public String findLinesInFilesByRegExp(String path, String regExp) {
        return Arrays.stream(getFiles(path))
                .flatMap(file -> {
                    try {
                        return new BufferedReader(new FileReader(file)).lines();
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                })
                .filter(s -> Pattern.compile(regExp).matcher(s).find())
                .map(s -> Pattern.compile(regExp).matcher(s).replaceAll("[$0]"))
                .reduce("", (current, converted) -> String.valueOf(new StringBuilder(current)
                        .append(converted)
                        .append("\n")));
    }
}
