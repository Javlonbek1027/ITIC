package uz.itic.itic_company.example.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.itic.itic_company.example.model.dto.base.BaseDTO;

import java.util.List;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CaseDto extends BaseDTO<UUID> {
    private String projectName;

    private String client;

    private String tags;

    private String link;

    private String casePhotoUrl;
    private AttachmentDTO attachment;

    private UUID attachmentId;

    private Boolean isActive;

    private List<String> tagsList;
}
