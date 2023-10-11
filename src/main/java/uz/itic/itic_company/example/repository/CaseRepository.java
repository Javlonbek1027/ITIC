package uz.itic.itic_company.example.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.itic.itic_company.example.model.entity.Case;
import uz.itic.itic_company.example.repository.base.BaseRepository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CaseRepository extends BaseRepository<Case, UUID> {


    List<Case> findByProjectNameContainingIgnoreCase(String projectName);
}
