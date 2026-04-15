package pd10;

import java.math.BigDecimal;
import java.util.List;

public class PlanningTripTest {

    public static void main(String[] args) {
        Trip trip1 = new Trip(new Destination("Stadion Camp Nou", "Hiszpania"), TransportType.CAR, 7, new BigDecimal("4360"));
        Trip trip2 = new Trip(new Destination("Zimna Grota", "Islandia"), TransportType.PLANE, 14, new BigDecimal("3600"));
        Trip trip3 = new Trip(new Destination("Ustka", "Polska"), TransportType.TRAIN, 5, new BigDecimal("2220"));

        User user1 = new User("Anna", TransportType.CAR, new BigDecimal("5000"));
        User user2 = new User("Marek", TransportType.PLANE, new BigDecimal("3000"));
        User user3 = new User("Piotr", null, null);

        TripCatalog tripCatalog = TripCatalog.initialize();
        tripCatalog.add(trip1);
        tripCatalog.add(trip2);
        tripCatalog.add(trip3);

        System.out.println(TripUtils.buildTripDescription(user1, tripCatalog.getTrips()));
        System.out.println(TripUtils.buildTripDescription(user2, tripCatalog.getTrips()));
        System.out.println(TripUtils.buildTripDescription(user3, tripCatalog.getTrips()));


        System.out.println(TripUtils.findByDestination(tripCatalog.getTrips(), "Zimna Grota")
                .map(trip -> trip.getDestination().getName())
                .orElse("No trip found"));

    }
}
