package pd15;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ProductUtils {

    public static List<Product> getTop5Products(List<Product> products) {
        return products.stream()
                .sorted(Comparator.comparing(product -> product.getPrice().multiply(BigDecimal.valueOf(product.getSold()))))
                .limit(5)
                .toList();
    }

    public static List<Product> getLowStock(List<Product> products) {
        return products.stream()
                .filter(product -> product.getStock() < 10)
                .sorted(Comparator.comparing(Product::getStock))
                .toList();
    }

    public static List<Product> filterByAverageRatingAndPrice(List<Product> products) {
        return products.stream()
                .filter(product -> product.getRating() >= 4.5)
                .filter(product -> product.getPrice().compareTo(BigDecimal.valueOf(500)) < 0)
                .sorted(Comparator.comparing(Product::getPrice))
                .toList();
    }

    public static boolean areAllRatingPositive(List<Product> products) {
        return products.stream()
                .allMatch(product -> product.getRating() > 0.0);
    }

    public static Product getHighestPriceProduct(List<Product> products){
        return products.stream()
                .max(Comparator.comparing(Product::getPrice)).orElse(null);
    }

}
