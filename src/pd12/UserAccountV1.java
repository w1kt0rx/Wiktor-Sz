package pd12;

import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "of")
public class UserAccountV1 {
    private long id;
    private String email;
    private String displayName;
}
