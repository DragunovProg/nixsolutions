package ua.dragunov.reflection.csvmapper;

import ua.dragunov.reflection.csvparser.model.CSVTable;
import ua.dragunov.reflection.exception.CSVMappingException;

import java.util.List;

public interface CSVMapper {

    <T> List<T> map(CSVTable table, Class<T> type) throws CSVMappingException;
}
