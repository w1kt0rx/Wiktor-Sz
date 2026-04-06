package pd10;


import java.math.BigDecimal;
import java.util.List;

public class PlanningTripTest {

    static void main(String[] args) {
        List<Trip> listOfAvailableTrips = List.of(
                Trip.builder()
                        .transport("Car")
                        .duration(7)
                        .budget(new BigDecimal("4360"))
                        .destination(Destination.builder()
                                .name("Stadion Camp Nou")
                                .country("Hiszpania").build())
                        .build(),

                Trip.builder()
                        .transport("Plane")
                        .duration(14)
                        .budget(new BigDecimal("3600"))
                        .destination(Destination.builder()
                                .name("Zimna Grota")
                                .country("Islandia").build())
                        .build(),

                Trip.builder()
                        .transport("Train")
                        .duration(5)
                        .budget(new BigDecimal("2220"))
                        .destination(Destination.builder()
                                .name("Ujście Świni")
                                .country("Polska").build())
                        .build()
        );

        User user1 = new User("Anna", TransportType.CAR, new BigDecimal("5000"));
        User user2 = new User("Marek", TransportType.PLANE, new BigDecimal("3000"));
        User user3 = new User("Piotr", null, null);

        System.out.println(TripUtils.buildTripDescription(user1, listOfAvailableTrips));
        System.out.println(TripUtils.buildTripDescription(user2, listOfAvailableTrips));
        System.out.println(TripUtils.buildTripDescription(user3, listOfAvailableTrips));


        System.out.println(TripUtils.findByDestination(listOfAvailableTrips, "Zimna Grota")
                .map(t -> t.getDestination().getName())
                .orElse("No trip found"));

    }
}
