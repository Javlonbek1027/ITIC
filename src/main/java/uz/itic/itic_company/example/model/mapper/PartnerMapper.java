package uz.itic.itic_company.example.model.mapper;

import org.mapstruct.Mapper;
import uz.itic.itic_company.example.model.dto.PartnerDto;
import uz.itic.itic_company.example.model.entity.Partner;
import uz.itic.itic_company.example.model.mapper.base.GenericMapper;

@Mapper(componentModel = "spring", uses = AttachmentMapper.class)
public interface PartnerMapper extends GenericMapper<Partner, PartnerDto> {

}
