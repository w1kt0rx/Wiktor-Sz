package pd7;

public record Rental(RentableResource resource, int days, RentalStatus rentalStatus) {

    public static Rental of(RentableResource resource, int days, RentalStatus rentalStatus) {
        return new Rental(resource, days, rentalStatus);
    }

    /**
     *
     * @return calculating cost of rent with duration of rental
     */
    public double calculateTotalCost() {
        return resource.calculatePrice() * days;
    }
}

