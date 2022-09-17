package ua.dragunov.labyrinth.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class LabyrinthWriter {

    public abstract void write(char[][] labyrinth);
}
