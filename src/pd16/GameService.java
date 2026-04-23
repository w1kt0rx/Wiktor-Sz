package pd16;

import java.math.BigDecimal;

public class GameService {
    private final GameRepository gameRepository = new GameRepository();
    public void printAllGames(){
        gameRepository.getGameMap()
                .values()
                .forEach(System.out::println);
    }

    public void printAllRentalbleGames(){
        gameRepository.getGameMap()
                .values()
                .stream()
                .filter(Game::isAvailable)
                .forEach(System.out::println);
    }
    public Game getGameWithId(long id){
        return gameRepository.get(id);
    }

    public void addGame(String name, GameCategory category, BigDecimal price) {
        Validators.validateGame(name, price);
        gameRepository.put(new Game(name, category, price));
    }
}
