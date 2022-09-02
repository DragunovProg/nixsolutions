package ua.dragunov.agregation;

import java.util.Arrays;

public class DistinctAggregator<T> implements Aggregator<Long, T>{

    @Override
    public Long aggregate(T[] items) {
        return Arrays.stream(items)
                .distinct()
                .count();
    }
}
