package pd16;

import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
@Getter
@ToString
public class Rental {
    private static long amountOfRentals = 0;
    private Client client;
    private long id;
    private Game game;
    private int days;
    private BigDecimal fullPrice;
    private RentalStatus status;

    public void changeStatus(){
        status = RentalStatus.COMPLETED;
    }

    public Rental(Client client, Game game, int days){
        this.client = client;
        this.id = ++amountOfRentals;
        this.game = game;
        this.days = days;
        this.fullPrice = game.getRentPricePerDay().multiply(BigDecimal.valueOf(days));
        this.status = RentalStatus.ACTIVE;
    }

    public void complete() {
        status = RentalStatus.COMPLETED;
    }
}
