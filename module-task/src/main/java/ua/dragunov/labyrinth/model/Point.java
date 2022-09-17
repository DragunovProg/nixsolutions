package ua.dragunov.labyrinth.model;

import java.util.Objects;

public class Point {
    private int xPoint;
    private int yPoint;

    public Point(int xPoint, int yPoint) {
        this.xPoint = xPoint;
        this.yPoint = yPoint;
    }

    public int getXPoint() {
        return xPoint;
    }

    public int getYPoint() {
        return yPoint;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point point)) return false;
        return xPoint == point.xPoint && yPoint == point.yPoint;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xPoint, yPoint);
    }

    @Override
    public String toString() {
        return "Point{" +
                "xPoint=" + xPoint +
                ", yPoint=" + yPoint +
                '}';
    }
}
