package pd11;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor(staticName = "of")
public class User {
    private final String name;
    private final String email;
    private final String hashedPassword;

}
