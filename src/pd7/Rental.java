package pd7;

import java.math.BigDecimal;

public record Rental(RentableResource resource, int days, RentalStatus rentalStatus) {

    public static Rental of(RentableResource resource, int days, RentalStatus rentalStatus) {
        return new Rental(resource, days, RentalStatus.ACTIVE);
    }

    /**
     *
     * @return calculating cost of rent with duration of rental
     */
    public BigDecimal calculateTotalCost() {
        return resource.calculatePrice().multiply(BigDecimal.valueOf(days));
    }
}

