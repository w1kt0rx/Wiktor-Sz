package zl8;

public class IntegerToString implements Transformer<Integer, String> {

    @Override
    public String transform(Integer input) {
        return input != null ? String.valueOf(input) : null;
    }
}
