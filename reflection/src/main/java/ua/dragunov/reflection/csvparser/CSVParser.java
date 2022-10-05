package ua.dragunov.reflection.csvparser;

import ua.dragunov.reflection.exception.CSVParsingException;
import ua.dragunov.reflection.csvparser.model.CSVTable;

public interface CSVParser<T> {

    CSVTable parse(T source) throws CSVParsingException;
}
