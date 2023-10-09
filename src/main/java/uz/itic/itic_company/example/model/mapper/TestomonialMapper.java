package uz.itic.itic_company.example.model.mapper;

import org.mapstruct.Mapper;
import uz.itic.itic_company.example.model.dto.TestomonialDto;
import uz.itic.itic_company.example.model.entity.Testomonial;
import uz.itic.itic_company.example.model.mapper.base.GenericMapper;

@Mapper(componentModel = "spring", uses = AttachmentMapper.class)
public interface TestomonialMapper extends GenericMapper<Testomonial, TestomonialDto> {
}
