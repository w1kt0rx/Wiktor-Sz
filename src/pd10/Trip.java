package pd10;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class Trip {
    private Destination destination;
    private String transport;
    private BigDecimal budget;
    private int duration; // in days
}
