package uz.itic.itic_company.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.itic.itic_company.example.common.basecontroller.GenericController;
import uz.itic.itic_company.example.common.baseservice.GenericService;
import uz.itic.itic_company.example.model.dto.CaseDto;
import uz.itic.itic_company.example.model.dto.Header;
import uz.itic.itic_company.example.model.dto.ResumeDto;
import uz.itic.itic_company.example.model.entity.Resume;
import uz.itic.itic_company.example.model.mapper.ResumeMapper;
import uz.itic.itic_company.example.repository.ResumeRepository;
import uz.itic.itic_company.example.service.ResumeService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value =  "/api/admin/resume")
public class ResumeController extends GenericController<Resume, UUID, ResumeDto, ResumeRepository, ResumeMapper> {
    private final ResumeService resumeService;
    public ResumeController(GenericService<Resume, UUID, ResumeDto, ResumeRepository, ResumeMapper> service, ResumeService resumeService) {
        super(service);
        this.resumeService = resumeService;
    }

    @GetMapping("/search")
    public Header<List<ResumeDto>> search(@RequestParam String fullName) {
        return Header.ok(resumeService.search(fullName));
    }

}
