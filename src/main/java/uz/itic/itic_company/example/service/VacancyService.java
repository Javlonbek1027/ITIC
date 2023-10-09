package uz.itic.itic_company.example.service;

import org.springframework.stereotype.Service;
import uz.itic.itic_company.example.common.baseservice.Deletable;
import uz.itic.itic_company.example.common.baseservice.GenericService;
import uz.itic.itic_company.example.model.dto.VacancyDto;
import uz.itic.itic_company.example.model.entity.Vacancy;
import uz.itic.itic_company.example.model.mapper.VacancyMapper;
import uz.itic.itic_company.example.repository.VacancyRepository;

import java.util.UUID;

@Service
public class VacancyService extends GenericService<Vacancy, UUID, VacancyDto, VacancyRepository, VacancyMapper> implements Deletable {
    public VacancyService(VacancyRepository repository, VacancyMapper mapper) {
        super(repository, mapper,Vacancy.class);
    }

    public String getJobTitle(UUID id){
        return repository.findById(id).get().getTitle();
    }
}
