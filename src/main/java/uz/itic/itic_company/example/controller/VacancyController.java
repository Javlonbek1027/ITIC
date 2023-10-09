package uz.itic.itic_company.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.itic.itic_company.example.common.basecontroller.GenericController;
import uz.itic.itic_company.example.common.baseservice.GenericService;
import uz.itic.itic_company.example.model.dto.VacancyDto;
import uz.itic.itic_company.example.model.entity.Vacancy;
import uz.itic.itic_company.example.model.mapper.VacancyMapper;
import uz.itic.itic_company.example.repository.VacancyRepository;

import java.util.UUID;
@RestController
@RequestMapping(value =  "/api/admin/vacancy")
public class VacancyController extends GenericController<Vacancy, UUID, VacancyDto, VacancyRepository, VacancyMapper> {

    public VacancyController(GenericService<Vacancy, UUID, VacancyDto, VacancyRepository, VacancyMapper> service) {
        super(service);
    }
}
