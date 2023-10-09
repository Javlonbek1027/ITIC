package uz.itic.itic_company.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.itic.itic_company.example.common.basecontroller.GenericController;
import uz.itic.itic_company.example.common.baseservice.GenericService;
import uz.itic.itic_company.example.model.dto.TestomonialDto;
import uz.itic.itic_company.example.model.entity.Testomonial;
import uz.itic.itic_company.example.model.mapper.TestomonialMapper;
import uz.itic.itic_company.example.repository.TestomonialRepository;

import java.util.UUID;

@RestController
@RequestMapping(value =  "/api/admin/testomonial")
public class TestomonialController extends GenericController<Testomonial, UUID, TestomonialDto, TestomonialRepository, TestomonialMapper> {


    public TestomonialController(GenericService<Testomonial, UUID, TestomonialDto, TestomonialRepository, TestomonialMapper> service) {
        super(service);
    }


}
