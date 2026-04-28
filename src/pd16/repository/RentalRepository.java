package pd16.repository;

import pd16.entity.Rental;

import java.util.*;

public class RentalRepository {
    private final Map<Long, Rental> rentalMap = new HashMap<>();

    public void save(Rental rental) {
        rentalMap.put(rental.getId(), rental);
    }

    public void delete(Long id) {
        rentalMap.remove(id);
    }

    public boolean existsById(long id) {
        return rentalMap.containsKey(id);
    }

    public Optional<Rental> get(long id) {
        return Optional.ofNullable(rentalMap.get(id));
    }

    public List<Rental> getAll() {
        return rentalMap.values().stream().toList();
    }
}
