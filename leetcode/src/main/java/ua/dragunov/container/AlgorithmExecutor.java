package ua.dragunov.container;

import java.util.ArrayList;
import java.util.List;

public class AlgorithmExecutor {

    public static int findContainerWithMostWater(int[] container) {
        int firstCounter = 0;
        int secondCounter = container.length - 1;
        List<Integer> results = new ArrayList<>();

        while (firstCounter != secondCounter) {
            if (container[firstCounter] < container[secondCounter]) {
                results.add(container[firstCounter] * (secondCounter - firstCounter));
                firstCounter++;
            } else {
                results.add(container[secondCounter] * (secondCounter - firstCounter));
                secondCounter--;
            }
        }

        return results.stream()
                .mapToInt(value -> value)
                .max()
                .orElseThrow();
    }

    public static void main(String[] args) {
        System.out.println(AlgorithmExecutor.findContainerWithMostWater(new int[] {4,3,2,1,4}));
    }
}
