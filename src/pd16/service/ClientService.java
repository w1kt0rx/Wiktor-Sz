package pd16.service;

import pd16.entity.Client;
import pd16.exception.ClientNotFoundException;
import pd16.validator.ClientValidators;
import pd16.entity.Role;
import pd16.repository.ClientRepository;

import java.util.Optional;

public class ClientService {
    private final ClientRepository clientRepository = new ClientRepository();

    public void registerUser(String name, String email, String password) {
        ClientValidators.validateName(name);
        ClientValidators.validateEmail(email);
        ClientValidators.validateUniqueEmail(email, clientRepository);
        ClientValidators.validatePassword(password);
        clientRepository.save(Client.of(name, email, password, Role.USER));
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
        return clientRepository.findByEmail(email).orElseThrow(() -> new ClientNotFoundException(email));
    }

    public void printUsers() {
        clientRepository.getAll().forEach(System.out::println);
    }

}
