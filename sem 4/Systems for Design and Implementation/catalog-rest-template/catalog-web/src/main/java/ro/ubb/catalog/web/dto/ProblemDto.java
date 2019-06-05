package ro.ubb.catalog.web.dto;


import lombok.*;
import ro.ubb.catalog.web.dto.BaseDto;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(callSuper = true)
@Builder
public class ProblemDto extends BaseDto {
    private String problemStatement;
}