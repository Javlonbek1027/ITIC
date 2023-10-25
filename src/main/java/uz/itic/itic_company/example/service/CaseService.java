package uz.itic.itic_company.example.service;

import org.springframework.stereotype.Service;
import uz.itic.itic_company.example.common.baseservice.Deletable;
import uz.itic.itic_company.example.common.baseservice.GenericService;
import uz.itic.itic_company.example.model.dto.AttachmentDTO;
import uz.itic.itic_company.example.model.dto.CaseDto;
import uz.itic.itic_company.example.model.dto.CaseDtoForTransfer;
import uz.itic.itic_company.example.model.entity.Case;
import uz.itic.itic_company.example.model.exaptions.GeneralApiException;
import uz.itic.itic_company.example.model.mapper.AttachmentMapper;
import uz.itic.itic_company.example.model.mapper.CaseMapper;
import uz.itic.itic_company.example.repository.AttachmentRepository;
import uz.itic.itic_company.example.repository.CaseRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class CaseService extends GenericService<Case, UUID, CaseDto, CaseRepository, CaseMapper> implements Deletable{
    public CaseService(CaseRepository repository, CaseMapper mapper, AttachmentMapper attachmentMapper, AttachmentRepository attachmentRepository, CaseRepository caseRepository) {
        super(repository, mapper, Case.class);
        this.attachmentMapper = attachmentMapper;
        this.caseRepository = caseRepository;
    }

    private final AttachmentMapper attachmentMapper;

    private final CaseRepository caseRepository;

    public CaseDtoForTransfer create(CaseDtoForTransfer dto) {
        Case entity = new Case();

        entity.setProjectName(dto.getProjectName());
        entity.setCasePhotoUrl(dto.getCasePhotoUrl());
        entity.setAttachmentId(dto.getAttachmentId());
        entity.setClient(dto.getClient());
        entity.setLink(dto.getLink());
        entity.setIsActive(dto.getIsActive());
        StringBuilder tags = new StringBuilder();
        if (!dto.getTagsList().isEmpty()) {
            for (String s : dto.getTagsList()) {
                tags.append(s).append(",");
            }
        }
        entity.setTags(tags.toString());
        Case save = repository.save(entity);
        dto.setId(save.getId());
        return dto;

    }

    public CaseDto edit(CaseDto dto) {
        Case byId = repository.findById(dto.getId()).orElseThrow();
        byId.setProjectName(dto.getProjectName());
        byId.setCasePhotoUrl(dto.getCasePhotoUrl());
        byId.setAttachment(attachmentMapper.toEntity(dto.getAttachment()));
        byId.setClient(dto.getClient());
        byId.setLink(dto.getLink());
        StringBuilder tags = new StringBuilder();
        if (!dto.getTagsList().isEmpty()) {
            for (String s : dto.getTagsList()) {
                tags.append(s).append(",");
            }
        }
        byId.setTags(tags.toString());
        repository.save(byId);
        return dto;
    }

    @Override
    public CaseDto get(UUID uuid) {
        return toDto(caseRepository.findById(uuid).orElseThrow());
    }

    public List<CaseDto> getList() {
        List<CaseDto> list = new ArrayList<>();
        List<Case> all = repository.findAll();
        if (!all.isEmpty()) {
            for (Case aCase : all) {
                list.add(toDto(aCase));
            }
        }
        return list;

    }

    public Case toEntity(CaseDto dto) {
        Case entity = new Case();
        entity.setProjectName(dto.getProjectName());
        entity.setCasePhotoUrl(dto.getCasePhotoUrl());
        entity.setAttachment(attachmentMapper.toEntity(dto.getAttachment()));
        entity.setClient(dto.getClient());
        entity.setLink(dto.getLink());
        StringBuilder tags = new StringBuilder();
        if (!dto.getTagsList().isEmpty()) {
            for (String s : dto.getTagsList()) {
                tags.append(s).append(",");
            }
        }
        entity.setTags(tags.toString());
        return entity;
    }

    public CaseDto toDto(Case entity) {
        CaseDto dto = new CaseDto();
        dto.setId(entity.getId());
        dto.setProjectName(entity.getProjectName());
        dto.setCasePhotoUrl(entity.getCasePhotoUrl());
        dto.setAttachment(attachmentMapper.toDto(entity.getAttachment()));
        dto.setClient(entity.getClient());
        dto.setAttachmentId(entity.getAttachmentId());
        List<String> split = List.of(entity.getTags().split(","));
//        List<String> result = new ArrayList<>();
//        for (String s : split) {
//            if(!Objects.equals(s, "")){
//                result.add(s);
//            }
//        }
        dto.setTagsList(split);
        dto.setLink(entity.getLink());
        dto.setIsActive(entity.getIsActive());
        return dto;
    }

        public List<CaseDto> search(String data) {
            List<CaseDto> list = new ArrayList<>();
            List<Case> all = caseRepository.findByProjectNameContainingIgnoreCase(data);
            if (!all.isEmpty()) {
                for (Case aCase : all) {
                    list.add(toDto(aCase));
                }
            }
            return list;
        }
}
