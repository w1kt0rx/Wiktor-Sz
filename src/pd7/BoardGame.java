package pd7;

import lombok.ToString;

import java.math.BigDecimal;

public final class BoardGame extends RentableResource {
    private final int maxPlayers;
    private final int playingTime;

    public BoardGame(String name, BigDecimal basePrice, int maxPlayers, int playingTime) {
        super(ResourceType.BOARDGAME, basePrice, name);
        this.maxPlayers = maxPlayers;
        this.playingTime = playingTime;
    }

    public static BoardGame of(String name, BigDecimal basePrice, int maxPlayers, int playingTime) {
        return new BoardGame(name, basePrice, maxPlayers, playingTime);
    }

    @Override
    public BigDecimal calculatePrice() {
        return getBasePrice().multiply(BigDecimal.valueOf(1.89));
    }
}
