package uz.itic.itic_company.example.service;

import org.springframework.stereotype.Service;
import uz.itic.itic_company.example.common.baseservice.Deletable;
import uz.itic.itic_company.example.common.baseservice.GenericService;
import uz.itic.itic_company.example.model.dto.EmployeeDto;
import uz.itic.itic_company.example.model.entity.Employee;
import uz.itic.itic_company.example.model.mapper.AttachmentMapper;
import uz.itic.itic_company.example.model.mapper.EmployeeMapper;
import uz.itic.itic_company.example.repository.EmployeeRepository;

import java.util.List;
import java.util.UUID;
@Service
public class EmployeeService extends GenericService<Employee, UUID, EmployeeDto, EmployeeRepository, EmployeeMapper> implements Deletable {

    public EmployeeService(EmployeeRepository repository, EmployeeMapper mapper) {
        super(repository, mapper, Employee.class);
    }

    @Override
    public EmployeeDto create(EmployeeDto dto) {
        var employee = mapper.toEntity(dto);
        return mapper.toDto(repository.save(employee));
    }

    public List<EmployeeDto> search(String name) {
        return mapper.toDtoList(repository.findByFirstNameContainingIgnoreCase(name));
    }
}
