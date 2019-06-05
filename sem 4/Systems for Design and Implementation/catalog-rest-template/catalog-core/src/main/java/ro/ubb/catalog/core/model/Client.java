package ro.ubb.catalog.core.model;

import lombok.*;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
public class Client extends BaseEntity<Long> {
    private String name;
    private String serialNumber;
//
//    public Client(String name, String serialNumber) {
//        this.name=name;
//        this.serialNumber=serialNumber;
//    }
//
//    public void setName(String name) { this.name=name;
//    }
//
//    public String getName() { return name;
//    }
//
//    public void setSerialNumber(String serialNumber) { this.serialNumber=serialNumber;
//    }
//
//    public String getSerialNumber() { return serialNumber;
//    }

}
