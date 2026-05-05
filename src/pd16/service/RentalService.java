package pd16.service;

import pd16.entity.*;
import pd16.exception.InvalidRentalStateException;
import pd16.exception.RentalNotFoundException;
import pd16.exception.RentalOwnershipException;
import pd16.repository.RentalRepository;

import java.math.BigDecimal;
import java.util.Map;
import java.util.stream.Collectors;

public class RentalService {
    private final RentalRepository rentalRepository = new RentalRepository();

    public void rentGame(Client client, Game game, int days) {
        if (game.getStatus() == Status.AVAILABLE) {
            Rental rental = new Rental(client, game, days);
            rentalRepository.save(rental);
            client.addRental(rental);
            game.markAsRented();
        } else {
            System.out.println("Gra nie jest dostępna.");
        }
    }

    public void printAllRentals() {
        rentalRepository.getAll().forEach(System.out::println);

    }

    public void returnGameById(Client client, Long id) {
        Rental rental = rentalRepository.get(id)
                .orElseThrow(() -> new RentalNotFoundException(id));

        if (!rental.getClient().equals(client)) throw new RentalOwnershipException();
        if (rental.getStatus() == RentalStatus.COMPLETED)
            throw new InvalidRentalStateException();

        rental.markAsCompleted();
        rental.getGame().markAsAvailable();
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
        rentalRepository.getAll().stream()
                .collect(Collectors.groupingBy(
                        rental -> rental.getGame().getCategory(),
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
        rentalRepository.getAll().stream()
                .collect(Collectors.groupingBy(
                        Rental::getClient,
                        Collectors.counting()
                ))
                .values().stream()
                .max(Long::compareTo)
                .ifPresent(maxCount -> System.out.println("Max wynajęć: " + maxCount));
    }

    public void mostPopularGames() {
        rentalRepository.getAll().stream()
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
