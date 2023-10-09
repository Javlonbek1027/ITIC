package uz.itic.itic_company.example.model.dto.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BaseSequentialIdDTO extends BaseDTO<Long> {
    private Long id;
}
