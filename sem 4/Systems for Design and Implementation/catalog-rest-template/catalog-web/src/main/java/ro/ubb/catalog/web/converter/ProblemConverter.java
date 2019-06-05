package ro.ubb.catalog.web.converter;

import org.springframework.stereotype.Component;
import ro.ubb.catalog.core.model.Client;
import ro.ubb.catalog.core.model.Problem;
import ro.ubb.catalog.web.converter.BaseConverter;
import ro.ubb.catalog.web.dto.ClientDto;
import ro.ubb.catalog.web.dto.ProblemDto;

/**
 * author: radu
 */
@Component
public class ProblemConverter extends BaseConverter<Problem, ProblemDto> {
    @Override
    public Problem convertDtoToModel(ProblemDto dto) {
        Problem problem =Problem.builder()
                .problemStatement(dto.getProblemStatement())
                .build();
//        String name= (String) dto.getName();
//        String serialNumber= (String) dto.getSerialNumber();
//        Client client=new Client(name, serialNumber);
        problem.setId((Long) dto.getId());
        return problem;
    }



    @Override
    public ProblemDto convertModelToDto(Problem problem) {
        ProblemDto clientdto = ProblemDto.builder()
                .problemStatement(problem.getProblemStatement())
                .build();
//        String name= (String) client.getName();
//        String serialNumber= (String) client.getSerialNumber();
//        ClientDto clientdto=new ClientDto(name, serialNumber);
        clientdto.setId(problem.getId());
        return clientdto;
    }
}
