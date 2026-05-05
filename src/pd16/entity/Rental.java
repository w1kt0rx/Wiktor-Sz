package pd16.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@ToString
public class Rental {
    private static long amountOfRentals = 0;
    private final Client client;
    private final long id;
    private final Game game;
    @Setter
    private int days;
    @Setter
    private BigDecimal fullPrice;
    private RentalStatus status;

    public Rental(Client client, Game game, int days) {
        this.client = client;
        this.id = ++amountOfRentals;
        this.game = game;
        this.days = days;
        this.fullPrice = game.getRentPricePerDay().multiply(BigDecimal.valueOf(days));
        this.status = RentalStatus.ACTIVE;
    }

    public void markAsCompleted() {
        status = RentalStatus.COMPLETED;
    }
}
