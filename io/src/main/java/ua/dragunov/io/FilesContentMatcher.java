package ua.dragunov.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class FilesContentMatcher {
    public List<File> getFiles(String path) throws IOException {
        List<File> files = new ArrayList<>();
        Files.walkFileTree(Path.of(path).normalize() , new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.toFile().isFile()) {
                    files.add(file.toFile());
                }

                return FileVisitResult.CONTINUE;
            }
        });

        return files;
    }


    public String findLinesInFilesByRegExp(String path, String regExp) throws IOException {
        Pattern compile = Pattern.compile(regExp);
        StringBuilder pathBuilder = new StringBuilder();

        getFiles(path).forEach(file -> {
            try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
                pathBuilder.append(reader.lines()
                        .filter(s -> compile.matcher(s).find())
                        .map(s -> compile.matcher(s).replaceAll("[$0]"))
                        .reduce("", (current, converted) ->
                                String.format("%s%s\n", current, converted)));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        return pathBuilder.toString();
    }

}
