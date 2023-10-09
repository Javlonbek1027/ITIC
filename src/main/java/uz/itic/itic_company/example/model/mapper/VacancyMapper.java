package uz.itic.itic_company.example.model.mapper;

import org.mapstruct.Mapper;
import uz.itic.itic_company.example.model.dto.VacancyDto;
import uz.itic.itic_company.example.model.entity.Vacancy;
import uz.itic.itic_company.example.model.mapper.base.GenericMapper;

@Mapper(componentModel = "spring", uses = AttachmentMapper.class)
public interface VacancyMapper extends GenericMapper<Vacancy, VacancyDto> {
}
