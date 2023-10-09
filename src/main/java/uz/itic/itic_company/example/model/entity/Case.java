package uz.itic.itic_company.example.model.entity;

import jakarta.persistence.*;
import lombok.*;
import uz.itic.itic_company.example.model.entity.base.BaseEntityUID;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "cases")
@Builder
public class Case extends BaseEntityUID {
    @Column(name = "projectName", nullable = false)
    private String projectName;
    @Column(name = "client", nullable = false)
    private String client;
    @Column(name = "tags")
    private String tags;
    @Column(name = "link", nullable = false)
    private String link;

    @Column(length = 1024)
    private String casePhotoUrl;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "attachment_id", insertable = false, updatable = false)
    private Attachment attachment;

    @Column(name = "attachment_id")
    private UUID attachmentId;

    @Builder.Default
    private Boolean isActive = Boolean.FALSE;
}
