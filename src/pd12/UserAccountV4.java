package pd12;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@AllArgsConstructor(staticName = "of")
public class UserAccountV4 {
    private long id;
    private String email;
    private String displayName;
    @Setter
    private String status;
}
