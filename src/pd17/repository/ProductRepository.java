package pd17.repository;

import pd17.utils.CsvParser;
import pd17.model.Product;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ProductRepository {
    private final Map<Long, Product> productMap = new HashMap<>();

    public ProductRepository(Path file) {
        try {
            CsvParser.loadProducts(file).forEach(product -> productMap.put(product.id(), product));
        } catch (IOException e) {
            System.err.println("Repository initialization failed");
        }
    }

    public Optional<Product> getById(Long id) {
        return Optional.ofNullable(productMap.get(id));
    }

    public void save(Product product) {
        productMap.put(product.id(), product);
    }

    public void delete(Product product) {
        productMap.remove(product.id());
    }

    public List<Product> getAll() {
        return productMap.values().stream().toList();
    }
}
