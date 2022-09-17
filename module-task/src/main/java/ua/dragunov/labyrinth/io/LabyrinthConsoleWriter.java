package ua.dragunov.labyrinth.io;

public class LabyrinthConsoleWriter extends LabyrinthWriter{
    @Override
    public void write(char[][] labyrinth) {
        for (char[] chars : labyrinth) {
            for (char aChar : chars) {
                System.out.printf("%c", aChar);
            }
            System.out.println();
        }
    }
}
