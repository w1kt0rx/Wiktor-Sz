package pd16;

import java.util.Optional;

public class ClientService {
    private final ClientRepository clientRepository = new ClientRepository();

    public void registerUser(String name, String email, String password) {
        Validators.validateName(name);
        Validators.validateEmail(email);
        Validators.validateUniqueEmail(email, clientRepository);
        Validators.validatePassword(password);
        clientRepository.put(Client.of(name, email, password, Role.USER));
        System.out.println("Rejestracja powiodła się");
    }

    public Optional<Client> loginUser(String email, String password) {
        return clientRepository.findByEmail(email)
                .filter(client -> client.getPassword().equals(password));

    }

    public void printAllRentals(Client client) {
        client.printRentedGames();
    }

    public Client getClientByEmail(String email) {
        if (clientRepository.findByEmail(email).isPresent()) {
            return clientRepository.findByEmail(email).get();
        }
        return null;
    }


    public void printUsers() {
        clientRepository.getClientsMap().forEach((email, user) -> System.out.println(user));
    }

}
