package ua.dragunov.agregation;

import java.util.Arrays;
import java.util.stream.IntStream;

public class AvgAggregator<T extends Number> implements Aggregator<Double, T> {
    @Override
    public Double aggregate(T[] items) {
        return Arrays.stream(items)
                .mapToDouble(value -> value.doubleValue())
                .average()
                .orElse(Double.NaN);
    }
}
