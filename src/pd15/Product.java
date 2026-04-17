package pd15;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Setter
@Getter
@ToString
public class Product {
    private final Long id;
    private final String name;
    private final ProductCategory category;
    private BigDecimal price;
    private int stock;
    private int sold;
    private final double rating;

    private Product(Long id, String name, ProductCategory category, BigDecimal price, int stock, int sold, double rating) {
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be 1-5");
        }
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
        this.sold = sold;
        this.rating = rating;
    }
    public static Product of(Long id, String name, ProductCategory category, BigDecimal price, int stock, int sold, double rating){
        return new Product(id, name, category, price, stock, sold, rating);
    }
}
