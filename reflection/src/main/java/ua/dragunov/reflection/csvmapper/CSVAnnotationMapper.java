package ua.dragunov.reflection.csvmapper;

import ua.dragunov.reflection.csvparser.model.CSVCell;
import ua.dragunov.reflection.csvparser.model.CSVRow;
import ua.dragunov.reflection.csvparser.model.CSVTable;
import ua.dragunov.reflection.exception.CSVMappingException;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.*;

public class CSVAnnotationMapper implements CSVMapper{

    @Override
    public <T> List<T> map(CSVTable table, Class<T> type) throws CSVMappingException {
        try {
            List<CSVRow> rows = table.getRows();
            List<T> results = new ArrayList<>(rows.size());
            Constructor<T> constructor = type.getConstructor();
            Field[] declaredFields = type.getDeclaredFields();
            Map<String, Field> columnToField = new HashMap<>(declaredFields.length);

            for (Field declaredField : declaredFields) {
                CSVColumn column = declaredField.getAnnotation(CSVColumn.class);
                if (column != null && declaredField.trySetAccessible()) {
                    columnToField.put(column.value(), declaredField);
                }
            }

            for (CSVRow row : rows) {

                T instance = constructor.newInstance();

                for (Map.Entry<String, Field> e : columnToField.entrySet()) {
                    String columnName = e.getKey();
                    Field field = e.getValue();

                    int index = table.getColumnIndex(columnName);

                    CSVCell cell = row.get(index);

                    Class<?> fieldType = field.getType();

                    if (fieldType.equals(String.class)) {
                        field.set(instance, cell.get());
                    } else if (fieldType.equals(Integer.class) || fieldType.equals(int.class)) {
                        field.setInt(instance, cell.getInt());
                    } else if (fieldType.equals(Boolean.class) || fieldType.equals(boolean.class)) {
                        field.setBoolean(instance, cell.getBoolean());
                    } else if (fieldType.equals(Double.class) || fieldType.equals(double.class)) {
                        field.setDouble(instance, cell.getDouble());
                    } else if (fieldType.equals(Long.class) || fieldType.equals(long.class)) {
                        field.setLong(instance, cell.getLong());
                    } else if (fieldType.isEnum()) {
                        Object[] constants = fieldType.getEnumConstants();
                        for (Object constant : constants) {
                            if (String.valueOf(constant).equalsIgnoreCase(cell.get())) {
                                field.set(instance, constant);
                                break;
                            }
                        }
                    }
                }

                results.add(instance);
            }

            return results;
        } catch (Exception e) {
            throw new CSVMappingException(e);
        }
    }
}
