package uz.itic.itic_company.example.service;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import uz.itic.itic_company.example.model.dto.res.FileCreatedResponse;
import uz.itic.itic_company.example.model.entity.Attachment;
import uz.itic.itic_company.example.model.exaptions.ErrorCodes;
import uz.itic.itic_company.example.model.exaptions.GeneralApiException;
import uz.itic.itic_company.example.repository.AttachmentRepository;
import uz.itic.itic_company.example.utils.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileService {

    private final AttachmentRepository attachmentRepository;
    private final Path path = Path.of("../uploads");

    @Value(value = "${file.server.domain-name}")
    public String serverURL;


    @PostConstruct
    public void createDir() throws IOException {
        Files.createDirectories(path);
    }


    public FileCreatedResponse uploadFile(MultipartFile multipartFile) throws IOException {
        var fileServerName = String.format("%s_user", UUID.randomUUID());
        var fileLocation = Path.of(path.toFile().getPath() + File.separator + fileServerName + "." + multipartFile.getOriginalFilename());
        String downloadUrl = Utils.generateDownloadUrl(fileServerName, serverURL);
        Attachment attachment = new Attachment();
        attachment.setFileLocation(fileLocation.toFile().getAbsolutePath());
        attachment.setFileSize(multipartFile.getSize());
        attachment.setFileContentType(multipartFile.getContentType());
        attachment.setFileOriginalName(multipartFile.getOriginalFilename());
        attachment.setFileServerName(fileServerName);
        attachment.setFileURL(downloadUrl);
        Files.copy(multipartFile.getInputStream(),fileLocation ,StandardCopyOption.REPLACE_EXISTING);
        Attachment savedAttachment = attachmentRepository.save(attachment);
        return FileCreatedResponse.builder().fileName(multipartFile.getOriginalFilename())
                .fileUrl(downloadUrl)
                .fileSize(multipartFile.getSize())
                .id(savedAttachment.getId())
                .build();

    }

    public void downloadFile(HttpServletResponse httpServletResponse, String fileServerName) throws IOException     {
        var byFileServerName = attachmentRepository.findByFileServerName(fileServerName).orElseThrow(
                () -> new GeneralApiException("resource_not_found", ErrorCodes.ERROR)
        );

        var fileLocation = byFileServerName.getFileLocation();
        httpServletResponse.setHeader(HttpHeaders.CONTENT_DISPOSITION,ContentDisposition.attachment().name(byFileServerName.getFileOriginalName()).filename(byFileServerName.getFileOriginalName()).build().toString());
        FileCopyUtils.copy(new FileInputStream(fileLocation),httpServletResponse.getOutputStream());
    }
}
