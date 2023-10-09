package uz.itic.itic_company.example.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import uz.itic.itic_company.example.model.entity.base.BaseEntityUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "attachments")
public class Attachment extends BaseEntityUID {

    @Column(nullable = false, name = "file_original_name")
    private String fileOriginalName;

    @Column(nullable = false, name = "file_size")
    private Long fileSize;

    @Column(nullable = false, name = "file_content_type")
    private String fileContentType;

    @Column(nullable = false, name = "file_server_name")
    private String fileServerName;

    @Column(nullable = false, name = "file_location")
    private String fileLocation;

    private String fileURL;

}
