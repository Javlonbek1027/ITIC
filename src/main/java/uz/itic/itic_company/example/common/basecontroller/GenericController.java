package uz.itic.itic_company.example.common.basecontroller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.itic.itic_company.example.common.baseservice.GenericService;
import uz.itic.itic_company.example.model.dto.CustomPage;
import uz.itic.itic_company.example.model.dto.Header;
import uz.itic.itic_company.example.model.dto.base.BaseDTO;
import uz.itic.itic_company.example.model.dto.req.PaginationRequest;
import uz.itic.itic_company.example.model.mapper.base.GenericMapper;
import uz.itic.itic_company.example.repository.base.BaseRepository;

import java.util.List;

@RequiredArgsConstructor
public abstract class GenericController<E, ID, DTO extends BaseDTO<ID>, R extends BaseRepository<E, ID>, T extends GenericMapper<E, DTO>> {

    protected  final GenericService<E, ID, DTO, R, T> service;

    @PostMapping
    public Header<DTO> create(@RequestBody @Valid Header<DTO> dto) {
        return Header.ok(service.create(dto.getData()));
    }

    @PutMapping
    public Header<DTO> edit(@RequestBody @Valid Header<DTO> dto) {
        return Header.ok(service.edit(dto.getData(), dto.getData().getId()));
    }

    @DeleteMapping("/{id}")
    public Header<?> delete(@PathVariable ID id) {
        service.delete(id);
        return Header.ok();
    }

    @GetMapping("/{id}")
    public Header<DTO> getById(@PathVariable ID id) {
        return Header.ok(service.get(id));
    }

    @GetMapping("/all")
    public Header<List<DTO>> getList() {
        return Header.ok(service.getList());
    }

    @GetMapping
    public Header<List<DTO>> getListPagination(PaginationRequest request) {
        CustomPage<DTO> page = service.getListPagination(request);
        return Header.ok(page.getData(), page.getPaginationData());
    }

    @GetMapping(value = "/filter")
    public Header<List<DTO>> getByFilter(E entity, PaginationRequest paginationRequest) {
        CustomPage<DTO> page = service.getFiltered( paginationRequest, entity);
        return Header.ok(page.getData(), page.getPaginationData());
    }
}
