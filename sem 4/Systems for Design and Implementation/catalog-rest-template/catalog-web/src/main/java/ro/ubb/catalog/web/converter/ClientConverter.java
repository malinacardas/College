package ro.ubb.catalog.web.converter;

import org.springframework.stereotype.Component;
import ro.ubb.catalog.core.model.Client;
import ro.ubb.catalog.web.converter.BaseConverter;
import ro.ubb.catalog.web.dto.ClientDto;


@Component
public class ClientConverter extends BaseConverter<Client, ClientDto> {
    @Override
    public Client convertDtoToModel(ClientDto dto) {
        Client client =Client.builder()
                .name(dto.getName())
                .serialNumber(dto.getSerialNumber())
                .build();
//        String name= (String) dto.getName();
//        String serialNumber= (String) dto.getSerialNumber();
//        Client client=new Client(name, serialNumber);
        client.setId((Long) dto.getId());
        return client;
    }



    @Override
    public ClientDto convertModelToDto(Client client) {
        ClientDto clientdto = ClientDto.builder()
                .name(client.getName())
                .serialNumber(client.getSerialNumber())
                .build();
//        String name= (String) client.getName();
//        String serialNumber= (String) client.getSerialNumber();
//        ClientDto clientdto=new ClientDto(name, serialNumber);
        clientdto.setId(client.getId());
        return clientdto;
    }
}
