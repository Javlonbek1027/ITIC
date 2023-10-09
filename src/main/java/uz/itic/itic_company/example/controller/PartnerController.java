package uz.itic.itic_company.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.itic.itic_company.example.common.basecontroller.GenericController;
import uz.itic.itic_company.example.common.baseservice.GenericService;
import uz.itic.itic_company.example.model.dto.PartnerDto;
import uz.itic.itic_company.example.model.entity.Partner;
import uz.itic.itic_company.example.model.mapper.PartnerMapper;
import uz.itic.itic_company.example.repository.PartnerRepository;

import java.util.UUID;

@RestController
@RequestMapping(value =  "/api/admin/partner")
public class PartnerController extends GenericController<Partner, UUID, PartnerDto, PartnerRepository, PartnerMapper> {


    public PartnerController(GenericService<Partner, UUID, PartnerDto, PartnerRepository, PartnerMapper> service) {
        super(service);
    }


}
