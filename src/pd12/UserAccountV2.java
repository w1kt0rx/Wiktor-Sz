package pd12;

import lombok.AllArgsConstructor;

import java.util.Objects;

@AllArgsConstructor(staticName = "of")
public class UserAccountV2 {
    private long id;
    private String email;
    private String displayName;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserAccountV2 that = (UserAccountV2) o;
        return id == that.id && Objects.equals(email, that.email) && Objects.equals(displayName, that.displayName);
    }
}
