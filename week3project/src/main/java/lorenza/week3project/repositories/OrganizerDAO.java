package lorenza.week3project.repositories;

import lorenza.week3project.entities.Organizers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrganizerDAO extends JpaRepository<Organizers, UUID> {
    List<Organizers> findByOrganizerUUID(UUID organizerUUID);
}