package uz.itic.itic_company.example.repository;


import org.springframework.stereotype.Repository;
import uz.itic.itic_company.example.model.entity.Partner;
import uz.itic.itic_company.example.repository.base.BaseRepository;

import java.util.UUID;
@Repository
public interface PartnerRepository extends BaseRepository<Partner, UUID> {
}
