package pd15;

import jdk.jfr.Category;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ProductUtils {

    public static List<Product> findTopSellingProducts(List<Product> products) {
        return products.stream()
                .sorted(Comparator.comparing(product -> product.getPrice().multiply(BigDecimal.valueOf(product.getSold()))))
                .limit(5)
                .toList();
    }

    public static ProductCategory findCategoryWithHighestAverageRating(List<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(
                                Product::getCategory,
                                Collectors.averagingDouble(Product::getRating)
                        )
                ).entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public static List<Product> findLowStockProducts(List<Product> products) {
        return products.stream()
                .filter(product -> product.getStock() < 10)
                .sorted(Comparator.comparing(Product::getStock))
                .toList();
    }

    public static Map<ProductCategory, Long> countProductsByCategory(List<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(
                                Product::getCategory,
                                Collectors.counting()
                        )
                );
    }

    public static Map<ProductCategory, DoubleSummaryStatistics> getCategoryPriceStatistics(List<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.summarizingDouble(product -> product.getPrice().doubleValue() * product.getSold())
                ));
    }

    public static List<Product> findHighRatedAffordableProducts(List<Product> products) {
        return products.stream()
                .filter(product -> product.getRating() >= 4.5)
                .filter(product -> product.getPrice().compareTo(BigDecimal.valueOf(500)) < 0)
                .sorted(Comparator.comparing(Product::getPrice))
                .toList();
    }

    public static boolean areAllRatingsValid(List<Product> products) {
        return products.stream()
                .allMatch(product -> product.getRating() > 0.0);
    }

    public static Product findMostExpensiveProduct(List<Product> products) {
        return products.stream()
                .max(Comparator.comparing(Product::getPrice)).orElse(null);
    }

    public static Map<Boolean, Long> partitionProductsByPriceTier(List<Product> products) {
        return products.stream()
                .collect(Collectors.partitioningBy(
                        p -> p.getPrice().compareTo(BigDecimal.valueOf(1000)) > 0,
                        Collectors.counting()
                ));
    }

    public static List<String> generateCategoryTopProductReport(List<Product> products) {
        Map<ProductCategory, Optional<Product>> topPerCategory = products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.maxBy(Comparator.comparing(Product::getSold))
                ));
        return topPerCategory.entrySet().stream()
                .map(e -> {
                    Product p = e.getValue().orElse(null);
                    return e.getKey() + ": " +
                            (p != null ? p.getName() + " (sold: " + p.getSold() + ")" : "brak");
                })
                .toList();
    }


}
