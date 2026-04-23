package pd16;

import pd10.User;

import java.util.*;

public class ClientRepository {
    private final Map<String, Client> clientsMap = new HashMap<>();

    public ClientRepository() {
        clientsMap.put("Admin@admin.com", Client.of("Admin", "Admin@admin.com", "Admin", Role.ADMIN));
    }

    public void put(Client client) {
        clientsMap.put(client.getEmail(), client);
    }

    public void remove(Client client) {
        clientsMap.remove(client.getEmail());
    }

    public boolean containsEmail(String email) {
        return clientsMap.containsKey(email);
    }

    public Optional<Client> findByEmail(String email) {
        return Optional.ofNullable(clientsMap.get(email));
    }

    public Map<String, Client> getClientsMap() {
        return Collections.unmodifiableMap(clientsMap);
    }
}
