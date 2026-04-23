package pd16;

import java.util.*;

public class RentalRepository {
    private final Map<Long, Rental> rentalMap = new HashMap<>();

    public void put(Rental rental) {
        rentalMap.put(rental.getId(), rental);
    }

    public void remove(Long id) {
        rentalMap.remove(id);
    }

    public boolean contain(long id) {
        return rentalMap.containsKey(id);
    }

    public Rental get(long id) {
        return rentalMap.get(id);
    }

    public Map<Long, Rental> getRentalMap() {
        return Collections.unmodifiableMap(rentalMap);
    }
}
