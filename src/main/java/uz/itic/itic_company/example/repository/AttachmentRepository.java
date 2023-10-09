package uz.itic.itic_company.example.repository;

import org.springframework.stereotype.Repository;
import uz.itic.itic_company.example.model.entity.Attachment;
import uz.itic.itic_company.example.repository.base.BaseRepository;


import java.util.Optional;
import java.util.UUID;

@Repository
public interface AttachmentRepository extends BaseRepository<Attachment, UUID> {

    Optional<Attachment> findByFileServerName(String fileServerName);
}
