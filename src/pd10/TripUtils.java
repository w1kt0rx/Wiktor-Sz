package pd10;

import java.util.List;
import java.util.Optional;

public class TripUtils {
    public static Optional<Trip> findByDestination(List<Trip> availableTrips, String destinationName) {
        return availableTrips.stream()
                .filter(trip -> trip.getDestination() != null)
                .filter(trip -> trip.getDestination().getName() != null)
                .filter(trip -> trip.getDestination().getName().equalsIgnoreCase(destinationName))
                .findFirst();
    }

    public static Optional<Trip> findBestTrip(User user, List<Trip> trips) {
        String preferredTransport = String.valueOf(user.getPreferredTransport());
        var budget = user.getBudget();

        if (preferredTransport == null && budget == null) {
            return Optional.empty();
        }

        return trips.stream()
                .filter(trip -> preferredTransport == null || trip.getTransport().equalsIgnoreCase(preferredTransport))
                .filter(trip -> budget == null || trip.getBudget().compareTo(budget) <= 0)
                .findFirst();
    }

    public static String buildTripDescription(User user, List<Trip> trips) {
        return findBestTrip(user, trips)
                .map(trip -> String.format(
                        "Destination: %s, Transport: %s, Budget: %s",
                        trip.getDestination().getName(),
                        trip.getTransport(),
                        trip.getBudget()
                ))
                .orElse("No trip available");
    }

}
