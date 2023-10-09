package uz.itic.itic_company.example.service;

import org.springframework.stereotype.Service;
import uz.itic.itic_company.example.common.baseservice.Deletable;
import uz.itic.itic_company.example.common.baseservice.GenericService;
import uz.itic.itic_company.example.model.dto.ResumeDto;
import uz.itic.itic_company.example.model.entity.Resume;
import uz.itic.itic_company.example.model.mapper.ResumeMapper;
import uz.itic.itic_company.example.repository.ResumeRepository;

import java.util.UUID;

@Service
public class ResumeService extends GenericService<Resume, UUID, ResumeDto, ResumeRepository, ResumeMapper> implements Deletable {

    public ResumeService(ResumeRepository repository, ResumeMapper mapper) {
        super(repository, mapper, Resume.class);
    }

}
