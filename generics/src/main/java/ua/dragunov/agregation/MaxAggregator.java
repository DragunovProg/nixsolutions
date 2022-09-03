package ua.dragunov.agregation;

import java.util.Arrays;

public class MaxAggregator<T extends Comparable<T>> implements Aggregator<T, T>{
    @Override
    public T aggregate(T[] items) {
        return Arrays.stream(items)
                .max(Comparable::compareTo)
                .get();
    }

}
