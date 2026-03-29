package pd7;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RentalSystem system = new RentalSystem();

        RentableResource book1 = Book.of("Java Basics", 22, 300);
        RentableResource book2 = Book.of("OOP Guide", 12, 400);
        RentableResource game1 = BoardGame.of("Monopoly", 20, 4, 30);
        RentableResource game2 = BoardGame.of("The Floor", 25, 2, 20);

        system.addRental(Rental.of(book1, 20, RentalStatus.NEW));
        system.addRental(Rental.of(book2, 35, RentalStatus.ACTIVE));
        system.addRental(Rental.of(game1, 5, RentalStatus.FINISHED));
        system.addRental(Rental.of(game2, 10, RentalStatus.ACTIVE));

        List<RentableResource> list = system.getAllResources();
        Collections.sort(list);
        for(var resource : list){
            System.out.println(resource);
        }

        list.sort(Comparator.comparing(RentableResource::getName));

        for(var resource : list){
            System.out.println(resource);
        }

        System.out.printf("Ilość wypożyczeń z statusem ACTIVE: %d%n",system.getAmountOfRentalsWithStatus(RentalStatus.ACTIVE));
        system.printSummary();

    }
}
