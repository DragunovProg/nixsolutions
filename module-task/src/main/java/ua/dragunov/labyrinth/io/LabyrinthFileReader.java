package ua.dragunov.labyrinth.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LabyrinthFileReader extends LabyrinthReader{
    private String path;

    public LabyrinthFileReader(String path) {
        this.path = path;
    }

    @Override
    public char[][] read() {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String[] fullText = bufferedReader.lines().toArray(String[]::new);
            int length = fullText[0].length();
            char[][] labyrinth = new char[fullText.length][fullText[0].length()];

            for (int i = 0; i < labyrinth.length; i++) {
                labyrinth[i] = fullText[i].toCharArray();
            }

            return labyrinth;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
