package zl8;

@FunctionalInterface
public interface Transformer<T, R> {
    R transform(T input);
}
