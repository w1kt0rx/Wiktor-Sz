package pd19.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ToString
@Getter
public class Member {
    private static long amountOfMembers = 0;
    private final long id;
    @Setter
    public String name;
    private final String email;
    private final List<Loan> loans = new ArrayList<>();

    private Member(String name, String email) {
        id = ++amountOfMembers;
        this.name = name;
        this.email = email;
    }

    public static Member of(String name, String email) {
        return new Member(name, email);
    }

    public boolean canBorrow() {
        return loans.size() < 3;
    }

    public List<Loan> getLoans() {
        return Collections.unmodifiableList(loans);
    }

    public void addLoan(Loan loan) {
        loans.add(loan);
    }

}
