package zl8;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Pair<String, Integer> firstPair = new Pair<>("Książka", 20);
        Pair<String, Integer> secondPair = Pair.of("Książka", 20);

        System.out.println("Getters");
        System.out.print(firstPair.getFirst() + " ");
        System.out.println(firstPair.getSecond());
        System.out.println("Using toString");
        System.out.println(secondPair);
        Pair<Integer, String> swapped = firstPair.swap();
        System.out.println("Swapped");
        System.out.println(swapped);
        System.out.println(firstPair.equals(secondPair));
        System.out.println("Transformation string to integer");
        List<String> list = List.of("1", "2", "3");
        List<Integer> transformed = TransformerUtils.transformAll(list, new StringToInteger());
        System.out.println(transformed);
        System.out.println("Użycie toUpperCase");
        String word = "żabka";
        String upper = new UpperCaseTransformer().transform(word);
        System.out.println(upper);
    }
}
