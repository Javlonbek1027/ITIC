package uz.itic.itic_company.example.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uz.itic.itic_company.example.model.dto.*;
import uz.itic.itic_company.example.model.dto.res.FileCreatedResponse;
import uz.itic.itic_company.example.service.*;

import java.io.IOException;
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
    private final CaseService caseService;
    private final TestomonialService testomonialService;

    private final FileService fileService;

    @PostMapping(value = "/upload")
    public Header<FileCreatedResponse> upload(@RequestParam("file") MultipartFile file) throws IOException {
        return Header.ok(fileService.uploadFile(file));

    }

    @GetMapping(value = "/download/{fileName}")
    public void download(@PathVariable String fileName, HttpServletResponse httpServletResponse) throws IOException {
        fileService.downloadFile(httpServletResponse,fileName);
    }
    @PostMapping("/resume")
    public Header<?> sendResume(@RequestBody Header<ResumeDto> resumeDto){
        resumeService.create(resumeDto.getData());
        return Header.ok();
    }
    @GetMapping("/vacancy")
    public Header<List<VacancyDto>> getVacancy(){
        var vacancyDtoCustomPage = vacancyService.getList();
        return Header.ok(vacancyDtoCustomPage);
    }
    @GetMapping("/vacancy/{id}")
    public Header<String> getJobTitle(@PathVariable UUID id){
        return Header.ok(vacancyService.getJobTitle(id));
    }
    @GetMapping("/employee")
    public Header<List<EmployeeDto>> getEmployee(){
        var listPagination = employeeService.getList();
        return Header.ok(listPagination);
    }
    @GetMapping("/partner")
    public Header<List<PartnerDto>> getPartners(){
        var page = partnerService.getList();
        return Header.ok((page));
    }
    @GetMapping("/case")
    public Header<List<CaseDto>> getCase(){
        return Header.ok(caseService.getList());
    }

    @PostMapping("/call-request")
    public Header<CallRequestDto>  sendCallRequest(@RequestBody Header<CallRequestDto> dto){
        return Header.ok(callRequestService.create(dto.getData()));
    }

    @GetMapping("/testomonial")
    public Header<List<TestomonialDto>> getTestomonial(){
        return Header.ok(testomonialService.getList());
    }
}
