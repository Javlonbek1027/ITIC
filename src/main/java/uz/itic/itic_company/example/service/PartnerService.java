package uz.itic.itic_company.example.service;

import org.springframework.stereotype.Service;
import uz.itic.itic_company.example.common.baseservice.Deletable;
import uz.itic.itic_company.example.common.baseservice.GenericService;
import uz.itic.itic_company.example.model.dto.PartnerDto;
import uz.itic.itic_company.example.model.entity.Partner;
import uz.itic.itic_company.example.model.mapper.PartnerMapper;
import uz.itic.itic_company.example.repository.PartnerRepository;

import java.util.UUID;

@Service
public class PartnerService extends GenericService<Partner, UUID, PartnerDto, PartnerRepository, PartnerMapper> implements Deletable {

    public PartnerService(PartnerRepository repository, PartnerMapper mapper) {
        super(repository, mapper, Partner.class);
    }

    @Override
    public PartnerDto create(PartnerDto dto) {
        var partner = mapper.toEntity(dto);
        return mapper.toDto(repository.save(partner));
    }
}
