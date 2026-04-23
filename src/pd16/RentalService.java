package pd16;

import java.math.BigDecimal;
import java.util.Map;
import java.util.stream.Collectors;

public class RentalService {
    private final RentalRepository rentalRepository = new RentalRepository();

    public void rentGame(Client client, Game game, int days) {
        if (game.getStatus() == Status.AVAILABLE) {
            Rental rental = new Rental(client, game, days);
            rentalRepository.put(rental);
            client.addRental(rental);
            game.rent();
        } else {
            System.out.println("Gra nie jest dostępna.");
        }
    }

    public void printAllRentals() {
        rentalRepository.getRentalMap().forEach((id, rental) -> System.out.println(rental));

    }

    public void returnGameById(Client client, Long id) {
        Rental rental = rentalRepository.get(id);

        if (rental == null) {
            throw new RuntimeException("Nie znaleziono wypożyczenia");
        }

        if (!rental.getClient().equals(client)) {
            throw new RuntimeException("To nie jest Twoje wypożyczenie");
        }

        if (rental.getStatus() == RentalStatus.COMPLETED) {
            throw new RuntimeException("Gra już została zwrócona");
        }

        rental.complete();
        rental.getGame().returnGame();
    }

    public void printReports() {
        System.out.println("Najczęściej wypożyczane gry");
        mostPopularGames();

        System.out.println("Najlepszy klient");
        topClient();

        System.out.println("Przychód dla kategorii");
        revenueByCategory();
    }

    public void revenueByCategory() {
        rentalRepository.getRentalMap().values().stream()
                .collect(Collectors.groupingBy(
                        r -> r.getGame().getCategory(),
                        Collectors.reducing(
                                BigDecimal.ZERO,
                                Rental::getFullPrice,
                                BigDecimal::add
                        )
                ))
                .forEach((category, revenue) ->
                        System.out.println(category + " -> " + revenue)
                );
    }

    public void topClient() {
        rentalRepository.getRentalMap().values().stream()
                .collect(Collectors.groupingBy(
                        Rental::getClient,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(e ->
                        System.out.println("Top klient: " + e.getKey() + " -> " + e.getValue())
                );
    }

    public void mostPopularGames() {
        rentalRepository.getRentalMap().values().stream()
                .collect(Collectors.groupingBy(
                        Rental::getGame,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .sorted(Map.Entry.<Game, Long>comparingByValue().reversed())
                .forEach(e ->
                        System.out.println(e.getKey() + " -> " + e.getValue())
                );
    }
}
