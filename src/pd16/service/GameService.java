package pd16.service;

import pd16.entity.Game;
import pd16.entity.GameCategory;
import pd16.exception.GameNotFoundException;
import pd16.validator.GameValidators;
import pd16.repository.GameRepository;

import java.math.BigDecimal;

public class GameService {
    private final GameRepository gameRepository = new GameRepository();

    public void printAllGames() {
        gameRepository.getAllGames()
                .forEach(System.out::println);
    }

    public void printAllRentableGames() {
        gameRepository.getAllGames()
                .stream()
                .filter(Game::isAvailable)
                .forEach(System.out::println);
    }

    public Game getGameWithId(long id) {
        return gameRepository.get(id).orElseThrow(() -> new GameNotFoundException(id));
    }

    public void addGame(String name, GameCategory category, BigDecimal price) {
        GameValidators.validateGame(name, price);
        gameRepository.save(new Game(name, category, price));
    }
}
