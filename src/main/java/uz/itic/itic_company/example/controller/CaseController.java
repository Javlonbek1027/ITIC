package uz.itic.itic_company.example.controller;

import org.springframework.web.bind.annotation.*;
import uz.itic.itic_company.example.common.basecontroller.GenericController;
import uz.itic.itic_company.example.common.baseservice.GenericService;
import uz.itic.itic_company.example.model.dto.CaseDto;
import uz.itic.itic_company.example.model.dto.CaseDtoForTransfer;
import uz.itic.itic_company.example.model.dto.Header;
import uz.itic.itic_company.example.model.entity.Case;
import uz.itic.itic_company.example.model.mapper.CaseMapper;
import uz.itic.itic_company.example.repository.CaseRepository;
import uz.itic.itic_company.example.service.CaseService;

import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping(value =  "/api/admin/case")
public class CaseController extends GenericController<Case, UUID, CaseDto, CaseRepository, CaseMapper> {
    public CaseController(GenericService<Case, UUID, CaseDto, CaseRepository, CaseMapper> service, CaseService caseService) {
        super(service);
        this.caseService = caseService;

    }
    private final CaseService caseService;
    @PostMapping("/add")
    public Header<CaseDtoForTransfer> addCase(@RequestBody Header<CaseDtoForTransfer> caseDto){
        return Header.ok(caseService.create(caseDto.getData()));
    }

    @GetMapping("/get/one/{id}")
    public Header<CaseDto> getOne(@PathVariable UUID id){
        return Header.ok(caseService.get(id));
    }

    @PutMapping("/edite")
    public Header<CaseDto> edite(@RequestBody Header<CaseDto> dto){
        return Header.ok(caseService.edit(dto.getData()));
    }

    @GetMapping("/get/all/info")
    public Header<List<CaseDto>> getAll(){
        return Header.ok(caseService.getList());
    }

    @GetMapping("/search")
    public Header<List<CaseDto>> search(@RequestParam String projectName) {
        return Header.ok(caseService.search(projectName));
    }

//    @DeleteMapping("/delete/{id}")
//    public Header<Void> delete(@PathVariable UUID id){
//        caseService.delete(id);
//        return Header.ok();
//    }




}
