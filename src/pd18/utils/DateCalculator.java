package pd18.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DateCalculator {

    public static int calculateAge(LocalDate birthDate) {
        if (birthDate == null) {
            throw new IllegalArgumentException("Data urodzenia nie może być pusta");
        }

        LocalDate currentDate = LocalDate.now();
        if (currentDate.isBefore(birthDate)) {
            throw new IllegalArgumentException("Data urodzenia nie może być z przyszłości");
        }

        return Period.between(birthDate, currentDate).getYears();
    }

    public static LocalDate nextPayDay(LocalDate from) {
        LocalDate lastDayOfMonth = from.with(TemporalAdjusters.lastDayOfMonth());
        DayOfWeek dayOfWeek = lastDayOfMonth.getDayOfWeek();

        if (dayOfWeek.equals(DayOfWeek.SATURDAY)) {
            return lastDayOfMonth.minusDays(1);
        }
        if (dayOfWeek.equals(DayOfWeek.SUNDAY)) {
            return lastDayOfMonth.minusDays(2);
        }
        return lastDayOfMonth;
    }

    public static long businessDaysBetween(LocalDate from, LocalDate to) {
        long amountOfBusinessDays = 0;
        LocalDate currentDate = from.plusDays(1);

        while (currentDate.isBefore(to)) {
            DayOfWeek dayOfWeek = currentDate.getDayOfWeek();
            if (dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY) {
                amountOfBusinessDays++;
            }
            currentDate = currentDate.plusDays(1);
        }
        return amountOfBusinessDays;
    }

    public static ZonedDateTime convertTimezone(ZonedDateTime dt, String targetZone) {
        return dt.withZoneSameInstant(ZoneId.of(targetZone));
    }

    public static String formatForLocal(LocalDateTime dt, String languageTag) {
        Locale local = Locale.forLanguageTag(languageTag);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy", local);
        return dt.format(formatter);
    }

    public static boolean isValidDate(String input, String pattern) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            LocalDate.parse(input, formatter);
            return true;
        } catch (DateTimeParseException | IllegalArgumentException e) {
            return false;
        }
    }

}
