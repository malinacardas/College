package ro.ubb.catalog.core.service;

import ro.ubb.catalog.core.model.Client;

import java.util.List;

/**
 * author: radu
 */
public interface ClientService {
    List<Client> getAllClients();

    Client saveClient(Client student);

    Client updateClient(Long id, Client convertDtoToModel);

    void deleteClient(Long id);
}
