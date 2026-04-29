package pd17;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CsvParser {
    public static List<Product> loadProducts(Path file) throws IOException {
        List<String> lines = Files.readAllLines(file);
        List<Product> products = new ArrayList<>();
        int[] lineNum = {0};

        for (String line : lines) {
            lineNum[0]++;
            if (lineNum[0] == 1 || line.isBlank()) continue;
            parseLine(line, lineNum[0]).ifPresent(products::add);
        }
        System.out.printf("Wczytano %d produktów, pominięto %d, błędnych wierszy%n", products.size(), lineNum[0] - 1 - products.size());
        return Collections.unmodifiableList(products);
    }

    private static Optional<Product> parseLine(String line, int lineNumber) {
        try {
            String[] parts = line.split(",", -1);
            if (parts.length != 6) {
                System.err.printf("Linia %d: oczekiwano 6 pól, mam %d: %s%n", lineNumber, parts.length, line);
                return Optional.empty();
            }
            return Optional.of(new Product(
                    parts[0].trim(),
                    Long.parseLong(parts[1].trim()),
                    parts[2].trim(),
                    parts[3].trim(),
                    Integer.parseInt(parts[4].trim()),
                    new BigDecimal(parts[5].trim())
            ));
        } catch (NumberFormatException e) {
            System.err.printf("Linia %d: błąd parsowania liczby: %s%n", lineNumber, e.getMessage());
            return Optional.empty();
        }
    }
}
