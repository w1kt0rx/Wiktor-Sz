package pd10;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(staticName = "initialize")
public class TripCatalog {
    private final List<Trip> trips = new ArrayList<>();

    public void add(Trip trip) {
        trips.add(trip);
    }

    public List<Trip> getTrips() {
        return trips;
    }
}
