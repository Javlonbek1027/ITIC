package uz.itic.itic_company.example.service;

import org.springframework.stereotype.Service;
import uz.itic.itic_company.example.common.baseservice.Deletable;
import uz.itic.itic_company.example.common.baseservice.GenericService;
import uz.itic.itic_company.example.model.dto.CaseDto;
import uz.itic.itic_company.example.model.dto.ResumeDto;
import uz.itic.itic_company.example.model.entity.Case;
import uz.itic.itic_company.example.model.entity.Resume;
import uz.itic.itic_company.example.model.mapper.AttachmentMapper;
import uz.itic.itic_company.example.model.mapper.ResumeMapper;
import uz.itic.itic_company.example.repository.ResumeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ResumeService extends GenericService<Resume, UUID, ResumeDto, ResumeRepository, ResumeMapper> implements Deletable {

    private final ResumeRepository repository;


    public ResumeService(ResumeRepository repository, ResumeMapper mapper, ResumeRepository repository1, AttachmentMapper attachmentMapper) {
        super(repository, mapper, Resume.class);
        this.repository = repository1;
    }


    public List<ResumeDto> search(String data) {
        List<ResumeDto> list = new ArrayList<>();
        List<Resume> all = repository.findByFullNameContainingIgnoreCase(data);
        if (!all.isEmpty()) {
            for (Resume aResume : all) {
                list.add(mapper.toDto(aResume));
            }
        }
        return list;
    }
}
