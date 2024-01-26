package lorenza.week3project.repositories;

import lorenza.week3project.entities.Organizers;
import lorenza.week3project.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrganizerDAO extends JpaRepository<Organizers, UUID> {
    List<Organizers> findByOrganizerUUID(UUID organizerUUID);
    Optional<Organizers> findByEmail(String email);
}