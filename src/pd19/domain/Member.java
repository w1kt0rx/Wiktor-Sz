package pd19.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ToString
@Getter
public class Member {
    private long id;
    public String name;
    private String email;
    private List<Loan> loans;

    private Member(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.loans = new ArrayList<>();
    }

    public static Member of(long id, String name, String email) {
        return new Member(id, name, email);
    }

    public boolean canBorrow() {
        return loans.size() < 3;
    }

    public List<Loan> getLoans() {
        return Collections.unmodifiableList(loans);
    }

    public void borrow(Loan loan) {
        loans.add(loan);
    }

}
