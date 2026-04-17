package pd13;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();

        warehouse.addProduct(Product.of(1L, "Laptop", "Electronics", new BigDecimal("3000"), 3));
        warehouse.addProduct(Product.of(2L, "Mouse", "Electronics", new BigDecimal("50"), 10));
        warehouse.addProduct(Product.of(3L, "Keyboard", "Electronics", new BigDecimal("120"), 4));

        warehouse.addProduct(Product.of(4L, "Apple", "Food", new BigDecimal("2"), 50));
        warehouse.addProduct(Product.of(5L, "Bread", "Food", new BigDecimal("3"), 2));
        warehouse.addProduct(Product.of(6L, "Milk", "Food", new BigDecimal("4"), 6));

        warehouse.addProduct(Product.of(7L, "Shampoo", "Cosmetics", new BigDecimal("15"), 1));
        warehouse.addProduct(Product.of(8L, "Soap", "Cosmetics", new BigDecimal("5"), 20));
        warehouse.addProduct(Product.of(9L, "Cream", "Cosmetics", new BigDecimal("25"), 3));

        warehouse.addProduct(Product.of(10L, "TV", "Electronics", new BigDecimal("2000"), 2));
        warehouse.addProduct(Product.of(11L, "Cheese", "Food", new BigDecimal("12"), 8));
        warehouse.addProduct(Product.of(12L, "Juice", "Food", new BigDecimal("6"), 4));

        warehouse.addProduct(Product.of(13L, "Perfume", "Cosmetics", new BigDecimal("150"), 2));
        warehouse.addProduct(Product.of(14L, "Monitor", "Electronics", new BigDecimal("800"), 7));
        warehouse.addProduct(Product.of(15L, "Banana", "Food", new BigDecimal("3"), 3));

        System.out.println("Low stock");
        warehouse.getLowStockReport().forEach(System.out::println);

        System.out.println("\nElectronics sorted by price");
        warehouse.findByCategory("Electronics").forEach(System.out::println);

        System.out.println("\nStats");
        System.out.println(warehouse.getCategoryStats());

        System.out.println("\nExport by price");
        System.out.println(warehouse.exportSortedByPrice());

    }
}
