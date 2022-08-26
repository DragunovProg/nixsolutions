package ua.dragunov.exception;

@FunctionalInterface
public interface Block {
    void run() throws NullPointerException;
}
