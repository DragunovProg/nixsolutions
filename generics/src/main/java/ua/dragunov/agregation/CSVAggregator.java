package ua.dragunov.agregation;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class CSVAggregator<T> implements Aggregator<String, T> {

    @Override
    public String aggregate(T[] items) {
        return Arrays.stream(items)
                .map(Objects::toString)
                .collect(Collectors.joining(","));
    }

}
