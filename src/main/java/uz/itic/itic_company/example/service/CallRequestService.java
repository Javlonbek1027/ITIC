package uz.itic.itic_company.example.service;

import org.springframework.stereotype.Service;
import uz.itic.itic_company.example.common.baseservice.Deletable;
import uz.itic.itic_company.example.common.baseservice.GenericService;
import uz.itic.itic_company.example.model.dto.CallRequestDto;
import uz.itic.itic_company.example.model.entity.CallRequest;
import uz.itic.itic_company.example.model.mapper.CallRequestMapper;
import uz.itic.itic_company.example.repository.CallRequestRepository;

import java.util.UUID;

@Service
public class CallRequestService extends GenericService<CallRequest, UUID, CallRequestDto, CallRequestRepository, CallRequestMapper> implements Deletable {

    private final CallRequestRepository callRequestRepository;
    private final CallRequestMapper callRequestMapper;
    public CallRequestService(CallRequestRepository repository, CallRequestMapper mapper, CallRequestRepository callRequestRepository, CallRequestMapper callRequestMapper) {
        super(repository, mapper, CallRequest.class);
        this.callRequestRepository = callRequestRepository;
        this.callRequestMapper = callRequestMapper;

    }

    public CallRequestDto createCall(CallRequestDto dto) {
        CallRequest callRequest = callRequestMapper.toEntity(dto);
        return callRequestMapper.toDto(callRequestRepository.save(callRequest));
    }
}
