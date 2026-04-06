package zl8;

public class StringToInteger implements Transformer<String, Integer> {

    @Override
    public Integer transform(String input) {
        return input != null ? Integer.parseInt(input) : null;
    }
}
