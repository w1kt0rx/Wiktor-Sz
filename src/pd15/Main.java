package pd15;

import java.math.BigDecimal;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ProductStorage storage = new ProductStorage();
        // ELECTRONICS
        storage.add(Product.of(1L, "Laptop", ProductCategory.ELECTRONICS, new BigDecimal("3000"), 5, 120, 4.5));
        storage.add(Product.of(2L, "Smartphone", ProductCategory.ELECTRONICS, new BigDecimal("2500"), 3, 200, 4.7));
        storage.add(Product.of(3L, "Headphones", ProductCategory.ELECTRONICS, new BigDecimal("400"), 10, 150, 4.2));
        storage.add(Product.of(4L, "Monitor", ProductCategory.ELECTRONICS, new BigDecimal("800"), 2, 80, 4.3));
        // FOOD
        storage.add(Product.of(5L, "Apple", ProductCategory.FOOD, new BigDecimal("2"), 100, 500, 4.8));
        storage.add(Product.of(6L, "Bread", ProductCategory.FOOD, new BigDecimal("3"), 20, 300, 4.1));
        storage.add(Product.of(7L, "Milk", ProductCategory.FOOD, new BigDecimal("4"), 15, 250, 4.0));
        storage.add(Product.of(8L, "Cheese", ProductCategory.FOOD, new BigDecimal("12"), 8, 180, 4.6));
        // COSMETICS
        storage.add(Product.of(9L, "Shampoo", ProductCategory.COSMETICS, new BigDecimal("15"), 6, 90, 4.3));
        storage.add(Product.of(10L, "Soap", ProductCategory.COSMETICS, new BigDecimal("5"), 50, 400, 4.0));
        storage.add(Product.of(11L, "Cream", ProductCategory.COSMETICS, new BigDecimal("25"), 4, 70, 4.4));
        storage.add(Product.of(12L, "Perfume", ProductCategory.COSMETICS, new BigDecimal("150"), 2, 60, 4.9));
        // BOOKS
        storage.add(Product.of(13L, "Java Basics", ProductCategory.BOOKS, new BigDecimal("40"), 12, 220, 4.7));
        storage.add(Product.of(14L, "Clean Code", ProductCategory.BOOKS, new BigDecimal("60"), 5, 300, 4.9));
        storage.add(Product.of(15L, "Algorithms", ProductCategory.BOOKS, new BigDecimal("80"), 3, 150, 4.6));
        storage.add(Product.of(16L, "Design Patterns", ProductCategory.BOOKS, new BigDecimal("70"), 4, 130, 4.8));
        // CLOTHING
        storage.add(Product.of(17L, "T-Shirt", ProductCategory.CLOTHING, new BigDecimal("30"), 25, 210, 4.2));
        storage.add(Product.of(18L, "Jeans", ProductCategory.CLOTHING, new BigDecimal("120"), 7, 180, 4.5));
        storage.add(Product.of(19L, "Jacket", ProductCategory.CLOTHING, new BigDecimal("250"), 3, 90, 4.6));
        storage.add(Product.of(20L, "Sneakers", ProductCategory.CLOTHING, new BigDecimal("200"), 6, 160, 4.4));

        System.out.println("Top selling:");
        ProductUtils.findTopSellingProducts(storage.getProductList())
                .forEach(System.out::println);

        System.out.println("\nBest category:");
        System.out.println(ProductUtils.findCategoryWithHighestAverageRating(storage.getProductList()));

        System.out.println("\nLow stock:");
        ProductUtils.findLowStockProducts(storage.getProductList())
                .forEach(System.out::println);

        System.out.println("\nCount per category:");
        Map<ProductCategory, Long> count = ProductUtils.countProductsByCategory(storage.getProductList());
        count.forEach((k, v) -> System.out.println(k + ": " + v));

        System.out.println("\nStats per category:");
        ProductUtils.getCategoryPriceStatistics(storage.getProductList())
                .forEach((k, v) -> System.out.println(k + ": " + v));

        System.out.println("\nHigh rated & cheap:");
        ProductUtils.findHighRatedAffordableProducts(storage.getProductList())
                .forEach(System.out::println);

        System.out.println("\nAll ratings valid:");
        System.out.println(ProductUtils.areAllRatingsValid(storage.getProductList()));

        System.out.println("\nMost expensive:");
        System.out.println(ProductUtils.findMostExpensiveProduct(storage.getProductList()));

        System.out.println("\nPartition premium:");
        System.out.println(ProductUtils.partitionProductsByPriceTier(storage.getProductList()));

        System.out.println("\nReport:");
        ProductUtils.generateCategoryTopProductReport(storage.getProductList())
                .forEach(System.out::println);
    }
}
