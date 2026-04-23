package pd16;

import java.math.BigDecimal;
import java.util.*;

public class GameRepository {
    private final HashMap<Long, Game> gameMap = new HashMap<>();

    public GameRepository() {
        gameMap.put(1L, new Game("Catan", GameCategory.STRATEGY, new BigDecimal("15")));
        gameMap.put(2L, new Game("FIFA 24", GameCategory.SPORTS, new BigDecimal("20")));
        gameMap.put(3L, new Game("The Witcher: Old World", GameCategory.RPG, new BigDecimal("25")));
    }

    public void put(Game game) {
        gameMap.put(game.getId(), game);
    }

    public void remove(Game game) {
        gameMap.remove(game.getId());
    }

    public boolean contains(Game game) {
        return gameMap.containsKey(game.getId());
    }

    public Game get(long id) {
        if (gameMap.containsKey(id)) {
            return gameMap.get(id);
        }
        return null;
    }

    public Map<Long, Game> getGameMap() {
        return Collections.unmodifiableMap(gameMap);
    }
}
