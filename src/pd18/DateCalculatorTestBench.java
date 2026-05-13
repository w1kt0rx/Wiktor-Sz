package pd18;

import pd18.utils.DateCalculator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class DateCalculatorTestBench {
    public static void main(String[] args) {

        System.out.println("Wiek w latach wynosi : " + DateCalculator.calculateAge(LocalDate.of(2004, 5, 1)));
        System.out.println("Ostatni dzień roboczy : " + DateCalculator.nextPayDay(LocalDate.of(2026, 5, 1)));
        LocalDate date1 = LocalDate.of(2025, 2, 10);
        LocalDate date2 = LocalDate.of(2026, 2, 10);
        System.out.printf("Ilość dni roboczych między %s a %s wynosi: %d dni%n", date1, date2, DateCalculator.businessDaysBetween(date1, date2));

        ZonedDateTime dateTime = ZonedDateTime.now();
        String zone = "Asia/Tokyo";
        System.out.printf("Czas: %s przekonwertowany na strefę %s to: %s%n", dateTime, zone, DateCalculator.convertTimezone(dateTime, zone));
        System.out.printf("Przekonwertowana data na lokalną: %s%n", DateCalculator.formatForLocal(LocalDateTime.now(), "en-US"));

        String pattern = "dd.MM.yyyy";
        String date = "30.04.2026";
        System.out.println("Czy '" + date + "' jest poprawna? " +
                DateCalculator.isValidDate(date, pattern));

        date = "12.30.2026";
        System.out.println("Czy '" + date + "' jest poprawna? " +
                DateCalculator.isValidDate(date, pattern)); // false
    }
}
