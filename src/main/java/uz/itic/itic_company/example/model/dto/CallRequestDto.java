package uz.itic.itic_company.example.model.dto;

import lombok.*;
import uz.itic.itic_company.example.model.dto.base.BaseDTO;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CallRequestDto extends BaseDTO<UUID> {

    private String fullName;

    private String phoneNumber;

    private String email;

    private String comment;
}
