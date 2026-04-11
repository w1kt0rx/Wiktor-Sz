package pd12;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@EqualsAndHashCode
@AllArgsConstructor(staticName = "of")
public class UserAccountV3 {
    private long id;
    private String email;
    private String displayName;
}
