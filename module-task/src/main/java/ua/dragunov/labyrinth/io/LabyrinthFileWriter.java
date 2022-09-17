package ua.dragunov.labyrinth.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LabyrinthFileWriter extends LabyrinthWriter{
    private String path;

    public LabyrinthFileWriter(String path) {
        this.path = path;
    }

    @Override
    public void write(char[][] labyrinth) {
        try(PrintWriter writer = new PrintWriter(new FileWriter(path))) {
            for (char[] chars : labyrinth) {
                writer.println(chars);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
