package pd9;

@FunctionalInterface
public interface Transformer<T> {
    T transform(T input);

    default Transformer<T> and(Transformer<T> other) {
        return input -> other.transform(this.transform(input));
    }
}
