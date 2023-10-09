package uz.itic.itic_company.example.model.dto.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BaseUUIDTO extends BaseDTO<UUID>{

    private UUID id;
}
