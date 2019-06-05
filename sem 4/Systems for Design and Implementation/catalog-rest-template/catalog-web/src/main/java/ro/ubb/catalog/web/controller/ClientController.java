package ro.ubb.catalog.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.catalog.core.model.Client;
import ro.ubb.catalog.core.service.ClientService;
import ro.ubb.catalog.web.converter.ClientConverter;
import ro.ubb.catalog.web.dto.ClientDto;
import ro.ubb.catalog.web.dto.ClientsDto;

import java.util.List;
import java.util.Set;


@RestController
public class ClientController {
    private static final Logger log =
            LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientConverter clientConverter;

    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    //@GetMapping("/clients")
    ClientsDto getAllClients() {
        log.trace("getAllStudents --- method entered");

        List<Client> clients = clientService.getAllClients();
        Set<ClientDto> dtos = clientConverter.convertModelsToDtos(clients);
        ClientsDto result = new ClientsDto(dtos);

        log.trace("getAllStudents: result={}", result);

        return result;
    }

    @RequestMapping(value = "/clients", method = RequestMethod.POST)
    ClientDto saveClient (@RequestBody ClientDto dto) {
        log.trace("saveStudent: dto={}", dto);

        Client saved = this.clientService.saveClient(
                clientConverter.convertDtoToModel(dto)
        );
        ClientDto result = clientConverter.convertModelToDto(saved);

        log.trace("saveStudent: result={}", result);

        return result;
    }

    @RequestMapping(value = "/clients/{id}", method = RequestMethod.PUT)
    ClientDto updateClient(@PathVariable Long id,
            @RequestBody ClientDto dto) {
        log.trace("updateStudent: id={},dto={}", id, dto);

        Client update = clientService.updateClient(
                id,
                clientConverter.convertDtoToModel(dto));
        ClientDto result = clientConverter.convertModelToDto(update);

        return result;
    }

    @RequestMapping(value = "/clients/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteClient(@PathVariable Long id) {
        log.trace("deleteStudent: id={}", id);

        clientService.deleteClient(id);

        log.trace("deleteStudent --- method finished");

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
