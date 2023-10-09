package uz.itic.itic_company.example.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.itic.itic_company.example.model.dto.base.BaseDTO;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TestomonialDto extends BaseDTO<UUID> {
    private String name;

    private String surname;

    private String content;

    private  Boolean isActive;
    private String testomonialPhotoUrl;
    private AttachmentDTO attachment;
    private UUID attachmentId;

}
