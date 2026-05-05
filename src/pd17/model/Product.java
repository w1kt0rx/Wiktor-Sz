package pd17.model;

import java.math.BigDecimal;

public record Product(String date, long id, String name, String category, int quantity, BigDecimal price) {
    public BigDecimal getIncome() {
        return price.multiply(BigDecimal.valueOf(quantity));
    }
}
