package ua.dragunov.agregation;

public interface Aggregator<A, T> {
    A aggregate(T[] items);
}
