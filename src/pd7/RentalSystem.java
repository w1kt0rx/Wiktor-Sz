package pd7;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class RentalSystem {
    List<Rental> rentalList = new ArrayList<>();

    public void addRental(Rental rental) {
        rentalList.add(rental);
    }

    /**
     *
     * @return total cost off all resources in rentalList
     */
    public BigDecimal getTotalCost() {
        BigDecimal totalCost = BigDecimal.ZERO;
        for (var rental : rentalList) {
            totalCost = totalCost.add(rental.calculateTotalCost());
        }
        return totalCost;
    }

    /**
     *
     * @param status status to be counted
     * @return amount of rentals with status
     */
    public int getAmountOfRentalsWithStatus(RentalStatus status) {
        int amount = 0;
        for (var rental : rentalList) {
            if (rental.rentalStatus() == status) {
                amount++;
            }
        }
        return amount;
    }

    /**
     *
     * @return list of resources
     */
    public List<RentableResource> getAllResources() {
        List<RentableResource> resourceList = new ArrayList<>();
        for (var rental : rentalList) {
            resourceList.add(rental.resource());
        }
        return resourceList;
    }

    public void printSummary() {
        for (var rental : rentalList) {
            System.out.printf("Nazwa : %s, kategoria: %s, ilość dni: %d, koszt: %.2f, status: %s%n", rental.resource().getName(), rental.resource().getResourceType(), rental.days(), rental.calculateTotalCost(), rental.rentalStatus());
        }
        System.out.println("Całkowite koszty: " + getTotalCost());
    }
}
