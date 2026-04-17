package pd13;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Warehouse {
    private final Map<Long, Product> inventory = new HashMap<>();
    private final Map<String, Set<Product>> productsByCategory = new HashMap<>();
    private final PriorityQueue<Product> lowStockQueue = new PriorityQueue<>(Comparator.comparing(Product::getQuantity));

    public void addProduct(Product product) {
        inventory.put(product.getId(), product);
        productsByCategory
                .computeIfAbsent(product.getCategory(), k -> new HashSet<>())
                .add(product);
        if (product.getQuantity() < 5) {
            lowStockQueue.add(product);
        }

    }

    public void removeProductById(Long id) {
        if (inventory.remove(id) == null) {
            return;
        }
        productsByCategory.get(inventory.get(id).getCategory()).remove(inventory.get(id));
        lowStockQueue.remove(inventory.get(id));
    }

    public void updateQuantity(Product product, int quantity) {
        if (inventory.get(product.getId()) == null) {
            return;
        }
        lowStockQueue.remove(product);
        inventory.get(product.getId()).setQuantity(quantity);
        if (product.getQuantity() < 5) {
            lowStockQueue.add(product);
        }
    }


    public List<Product> findByCategory(String category) {
        return productsByCategory.getOrDefault(category, Set.of())
                .stream()
                .sorted(Comparator.comparing(Product::getPrice))
                .toList();
    }

    public List<Product> getLowStockReport(){
        return lowStockQueue
                .stream()
                .toList();
    }

    public Map<String, DoubleSummaryStatistics> getCategoryStats(){
        return inventory.values().stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.summarizingDouble(p -> p.getPrice().doubleValue())
                ));
    }


    public TreeMap<BigDecimal, List<Product>> exportSortedByPrice(){
        return inventory.values().stream()
                .collect(Collectors.groupingBy(
                        Product::getPrice,
                        TreeMap::new,
                        Collectors.toList()
                ));
    }


    public Map<String, Set<Product>> getProductsByCategory() {
        return Collections.unmodifiableMap(productsByCategory);
    }

    public Map<Long, Product> getInventory() {
        return Collections.unmodifiableMap(inventory);
    }

}
