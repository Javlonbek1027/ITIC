package uz.itic.itic_company.example.model.mapper;

import org.mapstruct.Mapper;
import uz.itic.itic_company.example.model.dto.CaseDto;
import uz.itic.itic_company.example.model.entity.Case;
import uz.itic.itic_company.example.model.mapper.base.GenericMapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = AttachmentMapper.class)
public interface CaseMapper extends GenericMapper<Case, CaseDto> {
}
