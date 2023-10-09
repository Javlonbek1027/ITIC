package uz.itic.itic_company.example.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uz.itic.itic_company.example.model.dto.EmployeeDto;
import uz.itic.itic_company.example.model.dto.Header;
import uz.itic.itic_company.example.model.dto.res.FileCreatedResponse;
import uz.itic.itic_company.example.service.FileService;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping(value =  "/api/file")
public class FileUploadingController {

    private final FileService fileService;

    @PostMapping(value = "/upload")
    public Header<FileCreatedResponse> upload(@RequestParam("file") MultipartFile file) throws IOException {
        return Header.ok(fileService.uploadFile(file));

    }

    @GetMapping(value = "/download/{fileName}")
    public void download(@PathVariable String fileName, HttpServletResponse httpServletResponse) throws IOException {
        fileService.downloadFile(httpServletResponse,fileName);
    }
}
