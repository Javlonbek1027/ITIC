package uz.itic.itic_company.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.itic.itic_company.example.common.basecontroller.GenericController;
import uz.itic.itic_company.example.common.baseservice.GenericService;
import uz.itic.itic_company.example.model.dto.EmployeeDto;
import uz.itic.itic_company.example.model.dto.Header;
import uz.itic.itic_company.example.model.entity.Employee;
import uz.itic.itic_company.example.model.mapper.EmployeeMapper;
import uz.itic.itic_company.example.repository.EmployeeRepository;
import uz.itic.itic_company.example.service.EmployeeService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value =  "/api/admin/employee")
public class EmployeeController extends GenericController<Employee, UUID, EmployeeDto, EmployeeRepository, EmployeeMapper> {


    private final EmployeeService employeeService;
    public EmployeeController(GenericService<Employee, UUID, EmployeeDto, EmployeeRepository, EmployeeMapper> service, EmployeeService employeeService) {
        super(service);
        this.employeeService = employeeService;
    }
    @GetMapping("/search")
    public Header<List<EmployeeDto>> search(@RequestParam String name){
        return Header.ok(employeeService.search(name));
    }


}
