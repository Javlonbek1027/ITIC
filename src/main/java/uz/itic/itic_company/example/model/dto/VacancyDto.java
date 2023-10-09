package uz.itic.itic_company.example.model.dto;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import uz.itic.itic_company.example.model.dto.base.BaseDTO;
import uz.itic.itic_company.example.model.enums.EEmploymentType;
import uz.itic.itic_company.example.model.enums.ELocation;
import uz.itic.itic_company.example.model.enums.EPositionLevel;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VacancyDto extends BaseDTO<UUID> {


    private String title;

    private EPositionLevel positionLevel;

    private ELocation location;

    private EEmploymentType employmentType;

    private LocalTime fromTime;

    private LocalTime toTime;

    private Integer salary;

    private Boolean isActive;

    private LocalDate addedDate = LocalDate.now();
}
