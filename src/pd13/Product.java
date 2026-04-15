package pd13;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Objects;

@AllArgsConstructor(staticName = "of")
@ToString
@Getter
public class Product implements Comparable<Product>{
    private final Long id;
    private final String name;
    private final String category;
    @Setter
    private BigDecimal price;
    @Setter
    private int quantity;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public int compareTo(Product o) {
        return this.name.compareTo(o.name);
    }
}
