package pd7;

public final class BoardGame extends RentableResource {
    private int maxPlayers;
    private int playingTime;

    public BoardGame(String name, int basePrice, int maxPlayers, int playingTime) {
        super(ResourceType.BOARDGAME, basePrice, name);
        this.maxPlayers = maxPlayers;
        this.playingTime = playingTime;
    }

    public static BoardGame of(String name, int basePrice, int maxPlayers, int playingTime) {
        return new BoardGame(name, basePrice, maxPlayers, playingTime);
    }

    @Override
    public double calculatePrice() {
        return getBasePrice() * 1.89;
    }
}
