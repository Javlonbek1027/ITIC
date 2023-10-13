package uz.itic.itic_company.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.itic.itic_company.example.common.basecontroller.GenericController;
import uz.itic.itic_company.example.common.baseservice.GenericService;
import uz.itic.itic_company.example.model.dto.CallRequestDto;
import uz.itic.itic_company.example.model.entity.CallRequest;
import uz.itic.itic_company.example.model.mapper.CallRequestMapper;
import uz.itic.itic_company.example.repository.CallRequestRepository;

import java.util.UUID;

@RestController
@RequestMapping(value =  "/api/admin/call-request")
public class CallRequestController extends GenericController<CallRequest, UUID, CallRequestDto, CallRequestRepository, CallRequestMapper> {
    public CallRequestController(GenericService<CallRequest, UUID, CallRequestDto, CallRequestRepository, CallRequestMapper> service) {
        super(service);
    }


}
