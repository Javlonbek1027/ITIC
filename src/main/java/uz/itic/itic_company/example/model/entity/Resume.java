package uz.itic.itic_company.example.model.entity;

import jakarta.persistence.*;
import lombok.*;
import uz.itic.itic_company.example.model.entity.base.BaseEntityUID;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "resume")
@Builder
public class Resume extends BaseEntityUID {

    @Column(name = "fullName", nullable = false)
    private String fullName;

    @Column(name = "linkedinLink")
    private String linkedinLink;

    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "position", nullable = false)
    private String position;

    @Column(name = "comment", nullable = false)
    private String comment;

    @Column(length = 1024)
    private String userCVUrl;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "attachment_id", insertable = false, updatable = false)
    private Attachment attachment;

    @Column(name = "attachment_id")
    private UUID attachmentId;
}
