package ro.ubb.catalog.web.dto;

import lombok.*;
import ro.ubb.catalog.web.dto.BaseDto;

/**
 * author: radu
 */
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(callSuper = true)
@Builder
public class ClientDto extends BaseDto {
    private String name;
    private String serialNumber;

//    public ClientDto(String name, String serialNumber) {
//        this.name=name;
//        this.serialNumber=serialNumber;
//    }
//
//    public Object getName() { return name;
//    }
//
//    public Object getSerialNumber() { return serialNumber;
//    }
}
