package ua.dragunov.container;

public class AlgorithmExecutor {

    public static int findContainerWithMostWater(int[] container) {
        int firstCounter = 0;
        int secondCounter = container.length - 1;
        int maxContainerWithWater = 0;

        while (firstCounter != secondCounter) {
            int currentArea = Math.min(container[firstCounter],
                    container[secondCounter]) * (secondCounter - firstCounter);
            maxContainerWithWater = Math.max(maxContainerWithWater, currentArea);

            if (container[firstCounter] < container[secondCounter]) {
                firstCounter++;
            } else {
                secondCounter--;
            }
        }

        return maxContainerWithWater;
    }

    public static void main(String[] args) {
        System.out.println(AlgorithmExecutor.findContainerWithMostWater(new int[] {4,3,2,1,4}));
    }
}
