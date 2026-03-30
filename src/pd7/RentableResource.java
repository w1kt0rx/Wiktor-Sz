package pd7;

import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@ToString
@Getter
public abstract sealed class RentableResource implements Comparable<RentableResource> permits Book, BoardGame {
    private static int amountOfResources = 0;
    private final int id;
    private final String name;
    private final BigDecimal basePrice;
    private final ResourceType resourceType;

    public RentableResource(ResourceType resourceType, BigDecimal basePrice, String name) {
        this.id = ++amountOfResources;
        this.resourceType = resourceType;
        this.basePrice = basePrice;
        this.name = name;
    }

    @Override
    public int compareTo(RentableResource o) {
        return this.basePrice.compareTo(o.basePrice);
    }

    public abstract BigDecimal calculatePrice();
}

