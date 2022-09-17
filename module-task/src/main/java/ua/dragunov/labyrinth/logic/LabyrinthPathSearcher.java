package ua.dragunov.labyrinth.logic;

import ua.dragunov.labyrinth.model.Point;

import java.util.*;

public class LabyrinthPathSearcher {
    private static final int[] POSSIBLE_SHIFTING_BY_X = {-1, 0, 0, 1};
    private static final int[] POSSIBLE_SHIFTING_BY_Y = {0, -1, 1, 0};

    private static boolean checkShortestPathExistence(char[][] labyrinth, Point startPoint, Point endPoint, Map<Point, Point> path) {

        boolean[][] visited = new boolean[labyrinth.length][labyrinth[0].length];
        Queue<Point> queue = new ArrayDeque<>();

        visited[startPoint.getXPoint()][startPoint.getYPoint()] = true;
        queue.add(startPoint);
        path.put(startPoint, null);

        while (!queue.isEmpty()) {
            Point newPoint = queue.poll();
            int currentX = newPoint.getXPoint();
            int currentY = newPoint.getYPoint();

            if (currentX == endPoint.getXPoint() && currentY == endPoint.getYPoint()) {
                return true;
            }

            for (int i = 0; i < 4; i++)
            {

                if (isValid(labyrinth, visited, currentX + POSSIBLE_SHIFTING_BY_X[i]
                        , currentY + POSSIBLE_SHIFTING_BY_Y[i])) {

                    Point point = new Point(currentX + POSSIBLE_SHIFTING_BY_X[i], currentY + POSSIBLE_SHIFTING_BY_Y[i]);
                    visited[currentX + POSSIBLE_SHIFTING_BY_X[i]][currentY + POSSIBLE_SHIFTING_BY_Y[i]] = true;
                    path.put(point, newPoint);
                    queue.add(new Point(currentX + POSSIBLE_SHIFTING_BY_X[i], currentY + POSSIBLE_SHIFTING_BY_Y[i]));
                }
            }

        }
        return false;
    }


    public static char[][] getShortestPath(char[][] labyrinth, Point start, Point end) {
        Map<Point, Point> path = new LinkedHashMap<>();

        if (!checkShortestPathExistence(labyrinth, start, end, path)) {
            System.out.println("Path not exist");

            System.exit(1);
        }

        List<Point> points = new ArrayList<>();
        Point point = path.get(end);

        points.add(end);

        while (point != null) {
            points.add(point);
            point = path.get(point);
        }

        points.forEach(current -> labyrinth[current.getXPoint()][current.getYPoint()] = '#');

        return labyrinth;
    }
    private static boolean isValid(char[][] labyrinth, boolean[][] visited, int row, int column) {
        return (row >= 0) && (row < labyrinth.length) && (column >= 0) && (column < labyrinth[0].length)
                 && labyrinth[row][column] == '+' && !visited[row][column];
    }
}
