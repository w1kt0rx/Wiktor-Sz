package pd19.repository;

import pd19.domain.Loan;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class LoanRepository {
    private final Map<Long, Loan> loanMap = new HashMap<>();

    public void save(Loan loan) {
        loanMap.put(loan.getId(), loan);
    }

    public void delete(Loan loan) {
        loanMap.remove(loan.getId());
    }

    public Optional<Loan> findById(Long id) {
        return Optional.ofNullable(loanMap.get(id));
    }

    public List<Loan> findAll() {
        return loanMap.values().stream().toList();
    }
}
