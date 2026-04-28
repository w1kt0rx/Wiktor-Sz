package pd16.entity;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Client {
    private static long amountOfClients = 0;
    private final long id;
    private final String name;
    private final String email;
    private final String password;
    private final List<Rental> rentalList = new ArrayList<>();
    private Role role = Role.USER;

    private Client(String name, String email, String password) {
        this.id = ++amountOfClients;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    private Client(String name, String email, String password, Role role) {
        this(name, email, password);
        this.role = role;
    }

    public static Client of(String name, String email, String password) {
        return new Client(name, email, password);
    }

    public static Client of(String name, String email, String password, Role role) {
        return new Client(name, email, password, role);
    }

    public void addRental(Rental rental) {
        rentalList.add(rental);
    }

    public void printRentedGames() {
        rentalList.forEach(rental -> System.out.println(rental.getGame() + " " + rental.getStatus()));
    }

    public boolean isAdmin() {
        return role == Role.ADMIN;
    }

    @Override
    public String toString() {
        return "Client{" + "email='" + email + '\'' + ", name='" + name + '\'' + '}';
    }
}
