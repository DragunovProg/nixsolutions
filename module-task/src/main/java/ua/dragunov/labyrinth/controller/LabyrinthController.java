package ua.dragunov.labyrinth.controller;

import ua.dragunov.labyrinth.io.LabyrinthReader;
import ua.dragunov.labyrinth.io.LabyrinthWriter;
import ua.dragunov.labyrinth.logic.LabyrinthPathSearcher;
import ua.dragunov.labyrinth.model.Point;

import java.util.Scanner;

public class LabyrinthController {
    private final LabyrinthReader reader;
    private final LabyrinthWriter writer;
    private final Scanner input;
    public LabyrinthController(LabyrinthReader reader, LabyrinthWriter writer, Scanner input) {
        this.reader = reader;
        this.writer = writer;
        this.input = input;
    }



    public void getShortestHall() {
        char[][] labyrinth = reader.read();

        if (isEmpty(labyrinth)) {
            System.out.println("Labyrinth content is empty or null");
            System.exit(1);
        }
        System.out.println("Ok, enter start point and end point in (x,y) coordinate in format x y with space between them");

        System.out.println("Start point: ");
        Point start = new Point(input.nextInt(), input.nextInt());

        System.out.println("End point: ");
        Point end = new Point(input.nextInt(), input.nextInt());

        if (!isHall(labyrinth, start, end)) {
            System.out.println("Damn, start and end points aren't hall. It's wall bro!");
            System.exit(1);
        }


         writer.write(LabyrinthPathSearcher.getShortestPath(labyrinth, start, end));
    }


    public boolean isHall(char[][] labyrinth, Point start, Point end) {
        return labyrinth[start.getXPoint()][start.getYPoint()] == '+'
                && labyrinth[end.getXPoint()][end.getYPoint()] == '+';
    }

    public boolean isEmpty(char[][] labyrinth) {
        return labyrinth == null || labyrinth.length == 0;
    }
}
