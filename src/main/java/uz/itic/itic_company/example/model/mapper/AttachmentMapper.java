package uz.itic.itic_company.example.model.mapper;

import org.mapstruct.Mapper;
import uz.itic.itic_company.example.model.dto.AttachmentDTO;
import uz.itic.itic_company.example.model.entity.Attachment;
import uz.itic.itic_company.example.model.mapper.base.GenericMapper;

@Mapper(componentModel = "spring")
public interface AttachmentMapper extends GenericMapper<Attachment, AttachmentDTO> {

}
