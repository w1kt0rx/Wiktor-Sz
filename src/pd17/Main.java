package pd17;

import java.io.IOException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        Path file = Path.of("src", "pd17", "sales.csv");
        ProductService productService = new ProductService(file);
        System.out.println("Całkowity przychód: " + productService.calculateIncome());
        System.out.println("Top 3 produktów:");
        productService.getTop3ByIncome().forEach(System.out::println);
        productService.saveToTheFile(Path.of("src", "pd17", "summary.csv"));
    }
}
