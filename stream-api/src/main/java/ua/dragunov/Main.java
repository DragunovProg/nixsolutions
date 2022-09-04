package ua.dragunov;

import ua.dragunov.stream.StreamTaskUtil;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String[] array = {"string 1 text", "2 string 3 text", "45"};
        List<BigDecimal> numbers = List.of(new BigDecimal(10), new BigDecimal(10), new BigDecimal(10)
                , new BigDecimal(12321), new BigDecimal(12321), new BigDecimal(11), new BigDecimal(11)
                , new BigDecimal(11), new BigDecimal(11));

        Map<LocalDate, List<LocalTime>> allLocalTimeForDefinedLocalDate = StreamTaskUtil.findAllLocalTimeForLocalDate(List.of(LocalDateTime.of(2022, 9, 03, 14, 00)
                , LocalDateTime.of(2022, 9, 03, 16, 40)
                , LocalDateTime.of(2022, 9, 02, 10, 00)
                , LocalDateTime.of(2022, 9, 02, 21, 00)
                , LocalDateTime.of(2022, 9, 02, 23, 15)));

        System.out.println(StreamTaskUtil.findMostFrequentBigDecimal(numbers));
        System.out.println(StreamTaskUtil.findDigitsInStringArray(array));
        allLocalTimeForDefinedLocalDate.forEach((localDate, localTimes) -> {
            System.out.printf("For Date: %s\n", localDate.format(DateTimeFormatter.ISO_DATE));
            localTimes.forEach(localTime -> System.out.printf("Time: %s\n", localTime.format(DateTimeFormatter.ISO_TIME)));
        });
    }
}
