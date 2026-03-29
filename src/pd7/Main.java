package pd7;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RentalSystem system = new RentalSystem();
        createResourcesAndFill(system);

        List<RentableResource> listOfRentals = system.getAllResources();
        System.out.println("Sortowane według ceny bazowej:");
        Collections.sort(listOfRentals);
        for (var resource : listOfRentals) {
            System.out.println(resource);
        }

        System.out.println("Sortowane według nazwy:");
        listOfRentals.sort(Comparator.comparing(RentableResource::getName));
        for (var resource : listOfRentals) {
            System.out.println(resource);
        }

        System.out.printf("Ilość wypożyczeń z statusem ACTIVE: %d%n", system.getAmountOfRentalsWithStatus(RentalStatus.ACTIVE));
        system.printSummary();

    }

    /**
     * Filling systems list with data
     *
     * @param system
     */
    private static void createResourcesAndFill(RentalSystem system) {
        RentableResource book1 = Book.of("Lalka", 22, 300);
        RentableResource book2 = Book.of("W pustyni i w puszczy", 12, 400);
        RentableResource game1 = BoardGame.of("Monopoly", 20, 4, 30);
        RentableResource game2 = BoardGame.of("The Floor", 25, 2, 20);

        system.addRental(Rental.of(book1, 20, RentalStatus.ACTIVE));
        system.addRental(Rental.of(book2, 35, RentalStatus.ACTIVE));
        system.addRental(Rental.of(game1, 5, RentalStatus.FINISHED));
        system.addRental(Rental.of(game2, 10, RentalStatus.ACTIVE));
    }
}

