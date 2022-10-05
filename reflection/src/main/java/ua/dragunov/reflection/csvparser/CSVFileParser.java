package ua.dragunov.reflection.csvparser;

import ua.dragunov.reflection.exception.CSVParsingException;
import ua.dragunov.reflection.csvparser.model.CSVRow;
import ua.dragunov.reflection.csvparser.model.CSVTable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CSVFileParser implements CSVParser<Path> {

    @Override
    public CSVTable parse(Path source) throws CSVParsingException {
        try(BufferedReader reader = Files.newBufferedReader(source)) {
            String header = reader.readLine();
            if (header == null) {
                throw new CSVParsingException("Can't parse CSV, file is empty");
            }
            CSVTable table = new CSVTable(new CSVRow(List.of(header.split(","))));
            String line;
            while ((line = reader.readLine()) != null) {
                table.addRow(new CSVRow(List.of(line.split(","))));
            }
            return table;
        } catch (Exception e) {
            throw new CSVParsingException(e);
        }
    }

    public CSVTable parse(Reader source) throws CSVParsingException {
        try(BufferedReader reader = new BufferedReader(source)) {
            String header = reader.readLine();

            if (header == null) {
                throw new CSVParsingException("Can't parse CSV, file is empty");
            }
            CSVTable table = new CSVTable(new CSVRow(List.of(header.split(","))));
            String line;
            while ((line = reader.readLine()) != null) {
                table.addRow(new CSVRow(List.of(line.split(","))));
            }
            return table;
        } catch (Exception e) {
            throw new CSVParsingException(e);
        }
    }
}
