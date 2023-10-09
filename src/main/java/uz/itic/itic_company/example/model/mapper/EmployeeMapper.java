package uz.itic.itic_company.example.model.mapper;

import org.mapstruct.Mapper;
import uz.itic.itic_company.example.model.dto.EmployeeDto;
import uz.itic.itic_company.example.model.entity.Employee;
import uz.itic.itic_company.example.model.mapper.base.GenericMapper;

@Mapper(componentModel = "spring", uses = AttachmentMapper.class)
public interface EmployeeMapper extends GenericMapper<Employee, EmployeeDto> {

}
