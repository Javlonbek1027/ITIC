package uz.itic.itic_company.example.service;

import org.springframework.stereotype.Service;
import uz.itic.itic_company.example.common.baseservice.Deletable;
import uz.itic.itic_company.example.common.baseservice.GenericService;
import uz.itic.itic_company.example.model.dto.TestomonialDto;
import uz.itic.itic_company.example.model.entity.Testomonial;
import uz.itic.itic_company.example.model.mapper.TestomonialMapper;
import uz.itic.itic_company.example.repository.TestomonialRepository;

import java.util.UUID;

@Service
public class TestomonialService extends GenericService<Testomonial, UUID, TestomonialDto, TestomonialRepository, TestomonialMapper> implements Deletable {

    public TestomonialService(TestomonialRepository repository, TestomonialMapper mapper) {
        super(repository, mapper, Testomonial.class);
    }

    @Override
    public TestomonialDto create(TestomonialDto dto) {
        var create = mapper.toEntity(dto);
        return mapper.toDto(repository.save(create));
    }
}
