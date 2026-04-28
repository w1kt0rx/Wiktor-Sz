package pd16.repository;

import pd16.entity.Client;
import pd16.entity.Role;

import java.util.*;

public class ClientRepository {
    private final Map<Long, Client> clientsMap = new HashMap<>();

    public ClientRepository() {
        clientsMap.put(0L, Client.of("Admin", "Admin@admin.com", "Admin", Role.ADMIN));
    }

    public void save(Client client) {
        clientsMap.put(client.getId(), client);
    }

    public void delete(Client client) {
        clientsMap.remove(client.getId());
    }

    public boolean existsByEmail(String email) {
        return clientsMap.values().stream()
                .map(Client::getEmail)
                .anyMatch(e -> e.equalsIgnoreCase(email));
    }

    public Optional<Client> findByEmail(String email) {
        return Optional.ofNullable(clientsMap.get(email));
    }

    public List<Client> getAllClients() {
        return clientsMap.values().stream().toList();
    }
}
