package ua.dragunov.stream;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTaskUtil {

    public static String findDigitsInStringArray(String[] rows) {
        return Arrays.stream(rows)
                .flatMap(s -> Stream.of(s.split("")))
                .filter(s -> Character.isDigit(s.charAt(0)))
                .reduce("", String::concat);
    }

    public static Map<LocalDate, List<LocalTime>> findAllLocalTimeForLocalDate(List<LocalDateTime> localDateTimeList) {
        return localDateTimeList.stream()
                .collect(Collectors.groupingBy(LocalDateTime::toLocalDate
                        , Collectors.mapping(LocalDateTime::toLocalTime, Collectors.toList())));
    }


    public static BigDecimal findMostFrequentBigDecimal(List<BigDecimal> numbers) {
        return numbers.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                    .stream()
                    .max(Map.Entry.comparingByValue())
                    .get()
                .getKey();
    }
}
