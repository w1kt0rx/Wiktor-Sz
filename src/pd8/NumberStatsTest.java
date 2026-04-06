package pd8;

import java.math.BigDecimal;

public class NumberStatsTest {
    static void main(String[] args) {
        NumberStats<Integer> intStats = new NumberStats<>();
        intStats.add(5);
        intStats.add(2);
        intStats.add(9);
        System.out.println("Statystyki tablicy integerów: " + intStats);
        System.out.println(intStats.getMin());
        System.out.println(intStats.getMax());
        System.out.println(intStats.getSum());
        System.out.println(intStats.getAverage());
        System.out.println(intStats.getCount());
        System.out.println(intStats.getSorted());

        NumberStats<Double> doubleStats = new NumberStats<>();
        doubleStats.add(2.5);
        doubleStats.add(7.2);
        doubleStats.add(1.3);
        System.out.println("Statystyki tablicy double'ow: " + doubleStats);
        System.out.println(doubleStats.getMin());
        System.out.println(doubleStats.getMax());
        System.out.println(doubleStats.getSum());
        System.out.println(doubleStats.getAverage());
        System.out.println(doubleStats.getCount());
        System.out.println(doubleStats.getSorted());

        NumberStats<BigDecimal> decimalStats = new NumberStats<>();
        decimalStats.add(new BigDecimal("10.5"));
        decimalStats.add(new BigDecimal("3.2"));
        decimalStats.add(new BigDecimal("7.8"));
        System.out.println("Statystyki tablicy BigDecimal: " + decimalStats);
        System.out.println(decimalStats.getMin());
        System.out.println(decimalStats.getMax());
        System.out.println(decimalStats.getSum());
        System.out.println(decimalStats.getAverage());
        System.out.println(decimalStats.getSorted());

    }
}
