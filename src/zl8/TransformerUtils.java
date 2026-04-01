package zl8;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TransformerUtils {

    public static <T, R> List<R> transformAll(List<T> input, Transformer<T, R> transformer) {
        List<R> result = new ArrayList<>();

        for (var element : input) {
            result.add(transformer.transform(element));
        }
        return result;
    }
}
