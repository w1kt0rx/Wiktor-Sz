package pd10;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
@AllArgsConstructor
public class User {
    private String name;
    private TransportType preferredTransport;
    private BigDecimal budget;
}
