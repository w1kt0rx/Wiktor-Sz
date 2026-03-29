package pd7;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public abstract sealed class RentableResource implements Comparable<RentableResource> permits Book, BoardGame {
    private static int amountOfResources = 0;
    private final int ID;
    private String name;
    private int basePrice;
    private final ResourceType resourceType;

    public RentableResource(ResourceType resourceType, int basePrice, String name) {
        this.ID = ++amountOfResources;
        this.resourceType = resourceType;
        this.basePrice = basePrice;
        this.name = name;
    }

    @Override
    public int compareTo(RentableResource o) {
        return Double.compare(this.basePrice, o.basePrice);
    }

    public abstract double calculatePrice();


}

