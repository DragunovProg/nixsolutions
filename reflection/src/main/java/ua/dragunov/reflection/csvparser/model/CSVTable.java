package ua.dragunov.reflection.csvparser.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVTable {

    private Map<String, Integer> header;
    private List<CSVRow> rows;

    public CSVTable(CSVRow header) {
        int headerColumns = header.size();
        this.header = new HashMap<>(headerColumns);

        for (int i = 0; i < headerColumns; i++) {
            this.header.put(header.get(i).get(), i);
        }

        this.rows = new ArrayList<>();
    }

    public CSVRow getRow(int index) {
        return rows.get(index);
    }

    public List<CSVRow> getRows() {
        return rows;
    }

    public void addRow(CSVRow row) {
        rows.add(row);
    }

    public CSVCell getCell(int index, String column) {
        return rows.get(index).get(header.get(column));
    }

    public int getColumnIndex(String column) {
        return header.get(column);
    }
}
