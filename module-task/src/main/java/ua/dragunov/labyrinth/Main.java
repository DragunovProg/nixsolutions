package ua.dragunov.labyrinth;


import ua.dragunov.labyrinth.controller.LabyrinthController;
import ua.dragunov.labyrinth.io.LabyrinthConsoleWriter;
import ua.dragunov.labyrinth.io.LabyrinthFileReader;
import ua.dragunov.labyrinth.io.LabyrinthReader;
import ua.dragunov.labyrinth.io.LabyrinthWriter;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hi, enter a path to your file with labyrinth: ");

        Scanner input = new Scanner(System.in);
        LabyrinthReader reader = new LabyrinthFileReader(input.next());
        LabyrinthWriter writer = new LabyrinthConsoleWriter();
        LabyrinthController controller = new LabyrinthController(reader, writer, input);

        controller.getShortestHall();
    }

}
