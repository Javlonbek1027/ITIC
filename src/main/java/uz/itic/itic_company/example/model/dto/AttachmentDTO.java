package uz.itic.itic_company.example.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class AttachmentDTO {
    private String fileOriginalName;

    private Long fileSize;

    private String fileContentType;

    private String fileServerName;

    private String fileLocation;

    private String fileURL;

}
