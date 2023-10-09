package uz.itic.itic_company.example.repository;

import org.springframework.stereotype.Repository;
import uz.itic.itic_company.example.model.entity.Employee;
import uz.itic.itic_company.example.repository.base.BaseRepository;

import java.util.UUID;
@Repository
public interface EmployeeRepository extends BaseRepository<Employee, UUID> {
}
