package uz.itic.itic_company.example.model.entity.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class CommonFields extends BaseEntitySequentialID{

    @Column(name = "caption", nullable = false)
    private String caption;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = Boolean.TRUE;
}
