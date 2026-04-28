package pd16.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
public class Game {
    private static long amountOfGames = 0;
    private final long id;
    private final String name;
    private final GameCategory category;
    @Setter
    private BigDecimal rentPricePerDay;
    private Status status;

    public Game(String name, GameCategory category, BigDecimal rentPrice) {
        this.id = ++amountOfGames;
        this.name = name;
        this.category = category;
        this.rentPricePerDay = rentPrice;
        this.status = Status.AVAILABLE;
    }

    public boolean isAvailable() {
        return status == Status.AVAILABLE;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Game g && g.id == id;
    }

    public void markAsRented() {
        status = Status.RENTED;
    }

    public void markAsAvailable() {
        status = Status.AVAILABLE;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return id + " " + name + " " + status;
    }
}
