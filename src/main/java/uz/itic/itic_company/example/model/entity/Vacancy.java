package uz.itic.itic_company.example.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import uz.itic.itic_company.example.model.entity.base.BaseEntityUID;
import uz.itic.itic_company.example.model.enums.EEmploymentType;
import uz.itic.itic_company.example.model.enums.ELocation;
import uz.itic.itic_company.example.model.enums.EPositionLevel;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "vacancy")
@Builder
public class Vacancy extends BaseEntityUID {
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "positionLevel", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private EPositionLevel positionLevel;

    @Column(name = "location", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private ELocation location;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "employmentType", nullable = false)
    private EEmploymentType employmentType;

    @Column(name = "from_time")
    private LocalTime fromTime;

    @Column(name = "to_time")
    private LocalTime toTime;

    @Column(name = "salary", nullable = false)
    private Integer salary;

    @Builder.Default
    private Boolean isActive = Boolean.FALSE;

    @Column
    @Builder.Default
    private LocalDate addedDate = LocalDate.now();
}
