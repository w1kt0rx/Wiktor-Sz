package pd16.repository;

import pd16.entity.Game;
import pd16.entity.GameCategory;

import java.math.BigDecimal;
import java.util.*;

public class GameRepository {
    private final HashMap<Long, Game> gameMap = new HashMap<>();

    public GameRepository() {
        gameMap.put(1L, new Game("Catan", GameCategory.STRATEGY, new BigDecimal("15")));
        gameMap.put(2L, new Game("FIFA 24", GameCategory.SPORTS, new BigDecimal("20")));
        gameMap.put(3L, new Game("The Witcher: Old World", GameCategory.RPG, new BigDecimal("25")));
    }

    public void save(Game game) {
        gameMap.put(game.getId(), game);
    }

    public void delete(Game game) {
        gameMap.remove(game.getId());
    }

    public boolean existsByGame(Game game) {
        return gameMap.containsKey(game.getId());
    }

    public Optional<Game> get(long id) {
        return Optional.ofNullable(gameMap.get(id));
    }

    public List<Game> getAllGames() {
        return gameMap.values().stream().toList();
    }
}
