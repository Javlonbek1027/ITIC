package uz.itic.itic_company.example.model.entity;

import jakarta.persistence.*;
import lombok.*;
import uz.itic.itic_company.example.model.entity.base.BaseEntityUID;
import uz.itic.itic_company.example.model.mapper.AttachmentMapper;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "partner")
@Builder
public class Partner extends BaseEntityUID {
    @Column(length = 1024)
    private String partnerPhotoUrl;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "attachment_id", insertable = false, updatable = false)
    private Attachment attachment;

    @Column(name = "attachment_id")
    private UUID attachmentId;

    @Builder.Default
    private Boolean isActive = Boolean.FALSE;
}
