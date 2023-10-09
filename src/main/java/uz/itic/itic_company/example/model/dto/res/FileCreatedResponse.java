package uz.itic.itic_company.example.model.dto.res;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
public class FileCreatedResponse {
    private String fileUrl;
    private String fileName;
    private Long fileSize;
    private UUID id;
}
