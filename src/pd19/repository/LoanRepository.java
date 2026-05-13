package pd19.repository;

import pd19.domain.Loan;
import pd19.dto.LoanDto;
import pd19.mapper.LoanMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class LoanRepository {
    private final Map<Long, Loan> loanMap = new HashMap<>();
    private long idCounter = 0;

    public LoanDto save(Loan loan) {
        loanMap.put(loan.getId(), loan);
        return LoanMapper.toDto(loan);
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

    public long getNextId() {
        return ++idCounter;
    }
}
