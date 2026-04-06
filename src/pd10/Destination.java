package pd10;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class Destination {
    private String name;
    private String country;
}
