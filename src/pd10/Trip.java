package pd10;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
public class Trip {
    private final Destination destination;
    private final TransportType transport;
    @Setter
    private BigDecimal cost;
    private final int durationInDays; // in days


    public Trip(Destination destination, TransportType transport, int durationInDays, BigDecimal cost) {
        this.destination = destination == null ? new Destination("Unknown", "Unknown") : destination;
        this.transport = transport;
        this.durationInDays = durationInDays;
        this.cost = cost;
    }
}
