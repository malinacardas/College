package ro.ubb.catalog.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.catalog.core.model.Client;
import ro.ubb.catalog.core.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

/**
 * author: radu
 */
@Service
public class ClientServiceImpl implements ClientService {
    private static final Logger log =
            LoggerFactory.getLogger(ClientServiceImpl.class);

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getAllClients() {
        log.trace("getAllStudents --- method entered");

        List<Client> result = clientRepository.findAll();

        log.trace("getAllStudents: result={}", result);

        return result;
    }

    @Override
    public Client saveClient(Client client) {
        log.trace("-----saveStudent------ student={}", client);

        Client savedClient = this.clientRepository.save(client);

        //todo log result...

        return savedClient;
    }

    @Override
    @Transactional
    public Client updateClient(Long id, Client client) {
        log.trace("updateStudent: id={},student={}", id, client);

        Optional<Client> optionalStudent = clientRepository.findById(id);
        Client result = optionalStudent.orElse(client);
        result.setName(client.getName());
        result.setSerialNumber(client.getSerialNumber());

        log.trace("updateStudent: result={}", result);

        return result;


    }

    @Override
    public void deleteClient(Long id) {
        log.trace("deleteStudent: id={}", id);
        clientRepository.deleteById(id);

        log.trace("deleteStudent --- method finished");
    }


}
