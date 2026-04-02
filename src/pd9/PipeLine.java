package pd9;

import java.util.List;
import java.util.stream.Collectors;

public class PipeLine {

    public static <T> List<T> process(List<T> input, Transformer<T> transformer) {
        return input.stream()
                .map(transformer::transform)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        List<String> listOfString = List.of("Wielkie Jabłko", "Banan bez ogonka", "Mango jakieś");

        Transformer<String> removeSpaces = input -> input.replace(" ", "");

        Transformer<String> toUpper = String::toUpperCase;

        Transformer<String> cutTo5 = input -> input.length() > 5 ? input.substring(0, 5) : input;

        Transformer<String> addPrefix = input -> "Pref" + input;

        Transformer<String> pipeline = removeSpaces
                .and(toUpper)
                .and(cutTo5)
                .and(addPrefix);

        System.out.println(process(listOfString, pipeline));
    }
}
