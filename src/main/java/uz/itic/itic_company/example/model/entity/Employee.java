package uz.itic.itic_company.example.model.entity;

import jakarta.persistence.*;
import lombok.*;
import uz.itic.itic_company.example.model.entity.base.BaseEntityUID;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "employees")
@Builder
public class Employee extends BaseEntityUID {

    @Column(name = "first_name",nullable = false)
    private String firstName;

    @Column(name = "last_name",nullable = false)
    private String lastName;

    @Column(name = "position",nullable = false)
    private String position;
    @Column(length = 1024)
    private String employeePhotoUrl;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "attachment_id", insertable = false, updatable = false)
    private Attachment attachment;

    @Column(name = "attachment_id")
    private UUID attachmentId;

    @Builder.Default
    private Boolean isActive = Boolean.FALSE;

}
