package pd10;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Destination {
    private String name;
    private String country;

    public Destination(String name, String country) {
        this.name = name == null ? "Unknown" : name;
        this.country = country;
    }
}
