package pd17;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(Path file) throws IOException {
        productRepository = new ProductRepository(file);
    }

    public BigDecimal calculateIncome() {
        return productRepository.getAll().stream()
                .map(Product::getIncome)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<Product> getTop3ByIncome() {
        return productRepository.getAll().stream()
                .sorted(Comparator.comparing(Product::getIncome).reversed())
                .limit(3)
                .toList();
    }

    public List<CategoryStats> getCategoryStatistics() {
        return productRepository.getAll().stream()
                .collect(Collectors.groupingBy(Product::category))
                .entrySet().stream()
                .map(entry -> {
                    String category = entry.getKey();
                    List<Product> products = entry.getValue();

                    BigDecimal totalIncome = products.stream()
                            .map(Product::getIncome)
                            .reduce(BigDecimal.ZERO, BigDecimal::add);

                    BigDecimal avgPrice = products.stream()
                            .map(Product::price)
                            .reduce(BigDecimal.ZERO, BigDecimal::add)
                            .divide(BigDecimal.valueOf(products.size()), 2, RoundingMode.HALF_UP);

                    return new CategoryStats(category, totalIncome, avgPrice);
                })
                .sorted(Comparator.comparing(CategoryStats::totalIncome).reversed())
                .collect(Collectors.toList());
    }

    public void saveToTheFile(Path file) throws IOException {
        Files.writeString(file, "Kategoria, Przychód, Średnia cena\n");
        getCategoryStatistics().forEach(statistics -> {
            try {
                Files.writeString(file, statistics.category + "," + statistics.totalIncome + "," + statistics.averagePrice + "\n", StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public record CategoryStats(
            String category,
            BigDecimal totalIncome,
            BigDecimal averagePrice
    ) {
    }

}
