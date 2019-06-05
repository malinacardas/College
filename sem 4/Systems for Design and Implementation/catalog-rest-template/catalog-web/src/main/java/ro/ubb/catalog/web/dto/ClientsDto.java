package ro.ubb.catalog.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * author: radu
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ClientsDto {
    private Set<ClientDto> clients;


}
