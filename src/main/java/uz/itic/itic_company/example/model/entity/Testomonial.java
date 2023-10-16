package uz.itic.itic_company.example.model.entity;

import jakarta.persistence.*;
import lombok.*;
import uz.itic.itic_company.example.model.entity.base.BaseEntityUID;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "testomonial")
public class Testomonial extends BaseEntityUID {
    private String name;

    private String surname;

    private String companyName;
    private String content;

    private  Boolean isActive;
    @Column(length = 1024)
    private String testomonialPhotoUrl;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "attachment_id", insertable = false, updatable = false)
    private Attachment attachment;

    @Column(name = "attachment_id")
    private UUID attachmentId;

}
