package uz.itic.itic_company.example.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.itic.itic_company.example.model.entity.base.BaseEntityUID;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CallRequest extends BaseEntityUID {

    private String fullName;

    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "comment", nullable = false)
    private String comment;
}
