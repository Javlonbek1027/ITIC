package uz.itic.itic_company.example.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.itic.itic_company.example.model.dto.base.BaseDTO;

import java.sql.Timestamp;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PartnerDto extends BaseDTO<UUID> {
    private String partnerPhotoUrl;

    private AttachmentDTO attachment;

    private UUID attachmentId;

    private Boolean isActive;
}
