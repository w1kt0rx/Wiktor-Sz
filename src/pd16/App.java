package pd16;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Scanner;

public class App {
    private final Scanner scanner;
    private final ClientService clientService;
    private final GameService gameService;
    private final RentalService rentalService;

    public App() {
        this.scanner = new Scanner(System.in);
        this.clientService = new ClientService();
        this.gameService = new GameService();
        this.rentalService = new RentalService();
    }

    public void start() {
        while (true) {
            System.out.println("""
                    Witaj w wypożyczalni gier
                    Wybierz opcje
                    1. Zaloguj się
                    2. Zarejestruj się
                    3. Wyjdź
                    """);

            switch (scanner.nextLine()) {
                case "1" -> loginMenu();
                case "2" -> registrationMenu();
                case "3" -> {
                    System.out.println("Do zobaczenia!");
                    return;
                }
                default -> System.out.println("Nie ma takiej opcji");
            }
        }
    }

    private void registrationMenu() {
        try {
            System.out.println("Rejestracja");
            System.out.println("Podaj imię:");
            String name = scanner.nextLine();

            System.out.println("Podaj email:");
            String email = scanner.nextLine();

            System.out.println("Podaj hasło:");
            String password = scanner.nextLine();

            clientService.registerUser(name, email, password);
            System.out.println("Rejestracja zakończona sukcesem");

        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }
    }

    private void loginMenu() {
        System.out.println("Podaj email:");
        String email = scanner.nextLine();

        System.out.println("Podaj hasło:");
        String password = scanner.nextLine();

        Optional<Client> userOpt = clientService.loginUser(email, password);

        if (userOpt.isEmpty()) {
            System.out.println("Niepoprawne dane");
            return;
        }

        Client client = userOpt.get();
        System.out.println("Zalogowano");

        if (client.isAdmin()) {
            loggedAdminMenu(client);
        } else {
            loggedMenu(client);
        }
    }

    private void loggedMenu(Client client) {
        while (true) {
            System.out.printf("""
                    
                    Witaj %s, co chcesz zrobić?
                    1. Wyświetl dostępne gry
                    2. Wypożycz grę
                    3. Zwróć grę
                    4. Moje wypożyczenia
                    5. Raport
                    0. Wyloguj
                    """, client.getName());

            switch (scanner.nextLine()) {
                case "1" -> gameService.printAllRentalbleGames();
                case "2" -> rentGameMenu(client);
                case "3" -> returnGameMenu(client);
                case "4" -> clientService.printAllRentals(client);
                case "5" -> rentalService.printReports();
                case "0" -> {
                    System.out.println("Wylogowano");
                    return;
                }
                default -> System.out.println("Nie ma takiej opcji");
            }
        }
    }

    private void loggedAdminMenu(Client client) {
        while (true) {
            System.out.printf("""
                    
                    Witaj %s (ADMIN), co chcesz zrobić?
                    1. Wyświetl wszystkie gry
                    2. Dodaj grę
                    3. Wyświetl klientów
                    4. Aktualne wypożyczenia
                    5. Wypożyczenia klienta
                    6. Raport
                    0. Wyloguj
                    """, client.getName());

            switch (scanner.nextLine()) {
                case "1" -> gameService.printAllGames();
                case "2" -> addingGameMenu();
                case "3" -> clientService.printUsers();
                case "4" -> rentalService.printAllRentals();
                case "5" -> menuOfAllUsers();
                case "6" -> rentalService.printReports();
                case "0" -> {
                    System.out.println("Wylogowano");
                    return;
                }
                default -> System.out.println("Nie ma takiej opcji");
            }
        }
    }

    private void addingGameMenu() {
        try {
            System.out.print("Nazwa gry: ");
            String name = scanner.nextLine();

            System.out.println("Wybierz kategorię:");
            for (GameCategory c : GameCategory.values()) {
                System.out.println(c.ordinal() + ". " + c);
            }

            int choice = Integer.parseInt(scanner.nextLine());
            GameCategory category = GameCategory.values()[choice];

            System.out.print("Proszę podać cenę za dzień wypożyczenia ");
            BigDecimal price = new BigDecimal(scanner.nextLine());

            gameService.addGame(name, category, price);

            System.out.println("Gra dodana");

        } catch (Exception e) {
            System.out.println("Błąd dodawania gry");
        }
    }

    private void menuOfAllUsers() {
        System.out.println("Wszyscy użytkownicy");
        clientService.printUsers();
        System.out.println("Wybierz użytkownika przez email");
        String email = scanner.nextLine();
        Client client = clientService.getClientByEmail(email);

        if (client == null) {
            System.out.println("Nie znaleziono");
            return;
        }

        clientService.printAllRentals(client);

    }

    private void rentGameMenu(Client client) {
        System.out.println("Dostępne gry:");
        try {
            gameService.printAllRentalbleGames();

            System.out.print("ID gry: ");
            long id = Long.parseLong(scanner.nextLine());

            System.out.print("Liczba dni: ");
            int days = Integer.parseInt(scanner.nextLine());

            rentalService.rentGame(client, gameService.getGameWithId(id), days);

        } catch (Exception e) {
            System.out.println("Błąd wypożyczenia");
        }
    }

    private void returnGameMenu(Client client) {
        try {
            client.printRentedGames();

            System.out.print("ID wypożyczenia: ");
            long id = Long.parseLong(scanner.nextLine());

            rentalService.returnGameById(client, id);

        } catch (Exception e) {
            System.out.println("Błąd zwrotu");
        }
    }
}