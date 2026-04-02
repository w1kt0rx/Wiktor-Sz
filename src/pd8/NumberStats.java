package pd8;

import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberStats<T extends Number & Comparable<T>> {

    List<T> listOfNumbers = new ArrayList<>();
    private T max;
    private T min;
    private Double sum;
    private Double average;
    private List<T> sorted;

    public void add(T number) {
        listOfNumbers.add(number);
        clearCache();
    }

    private void clearCache() {
        max = null;
        min = null;
        sum = null;
        average = null;
        sorted = null;
    }

    public T getMin() {
        if (min == null && !listOfNumbers.isEmpty()) {
            return Collections.min(listOfNumbers);
        }
        return min;
    }

    public T getMax() {
        if (max == null && !listOfNumbers.isEmpty()) {
            return Collections.max(listOfNumbers);
        }
        return max;
    }

    public double getSum() {
        if (sum == null) {
            sum = 0.0;
            for (T number : listOfNumbers) {
                sum += number.doubleValue();
            }
        }
        return sum;
    }

    public double getAverage() {
        if (average == null) {
            if (listOfNumbers.isEmpty()) {
                return 0.0;
            }
            return getSum() / getCount();
        }
        return average;
    }

    public int getCount() {
        return listOfNumbers.size();
    }

    public List<T> getSorted() {
        if (sorted == null) {
            sorted = new ArrayList<>(listOfNumbers);
            Collections.sort(sorted);
        }
        return new ArrayList<>(sorted);
    }

    @Override
    public String toString() {
        return listOfNumbers.toString();
    }
}
