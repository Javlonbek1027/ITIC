package uz.itic.itic_company.example.model.mapper;

import org.mapstruct.Mapper;
import uz.itic.itic_company.example.model.dto.CallRequestDto;
import uz.itic.itic_company.example.model.entity.CallRequest;
import uz.itic.itic_company.example.model.mapper.base.GenericMapper;
@Mapper(componentModel = "spring")
public interface CallRequestMapper extends GenericMapper<CallRequest, CallRequestDto> {
}
