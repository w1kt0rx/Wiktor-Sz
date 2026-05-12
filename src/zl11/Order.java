package zl11;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor(staticName = "of")
@Getter
@ToString
public class Order {
    private final String clientName;
    private final int quantity;
}
