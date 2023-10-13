package uz.itic.itic_company.example.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.internal.util.StringHelper;
import org.springframework.web.bind.annotation.*;
import uz.itic.itic_company.example.model.dto.*;
import uz.itic.itic_company.example.model.dto.req.PaginationRequest;
import uz.itic.itic_company.example.service.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value =  "/api/public")
@RequiredArgsConstructor
public class CommonApiController {

    private final ResumeService resumeService;
    private final PartnerService partnerService;
    private final EmployeeService employeeService;
    private final VacancyService vacancyService;
    private final CallRequestService callRequestService;
    @PostMapping("/resume")
    public Header<?> sendResume(@RequestBody Header<ResumeDto> resumeDto){
        resumeService.create(resumeDto.getData());
        return Header.ok();
    }
    @GetMapping("/vacancy")
    public Header<List<VacancyDto>> getVacancy(PaginationRequest request){
        CustomPage<VacancyDto> vacancyDtoCustomPage = vacancyService.getListPagination(request);
        return Header.ok(vacancyDtoCustomPage.getData(), vacancyDtoCustomPage.getPaginationData());
    }
    @GetMapping("/vacancy/{id}")
    public Header<String> getJobTitle(@PathVariable UUID id){
        return Header.ok(vacancyService.getJobTitle(id));
    }
    @GetMapping("/employee")
    public Header<List<EmployeeDto>> getEmployee(PaginationRequest paginationRequest){
        var listPagination = employeeService.getListPagination(paginationRequest);
        return Header.ok(listPagination.getData(),listPagination.getPaginationData());
    }
    @GetMapping("/partner")
    public Header<List<PartnerDto>> getPartners(PaginationRequest paginationRequest){
        var page = partnerService.getListPagination(paginationRequest);
        return Header.ok(page.getData(),page.getPaginationData());
    }

    @PostMapping("/call-request")
    public Header<CallRequestDto>  sendCallRequest(@RequestBody Header<CallRequestDto> dto){
        return Header.ok(callRequestService.create(dto.getData()));
    }
}
