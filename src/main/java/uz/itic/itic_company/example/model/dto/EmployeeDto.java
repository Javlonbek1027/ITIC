package uz.itic.itic_company.example.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.itic.itic_company.example.model.dto.base.BaseDTO;

import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeDto extends BaseDTO<UUID> {
    private String firstName;
    private String position;
    private String lastName;
    private String employeePhotoUrl;
    private Boolean isActive;
    private AttachmentDTO attachment;
    private UUID attachmentId;
}
