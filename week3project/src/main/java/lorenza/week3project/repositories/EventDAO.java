package lorenza.week3project.repositories;

import lorenza.week3project.entities.Event;
import lorenza.week3project.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EventDAO extends JpaRepository<Event, UUID> {
    List<Event> findFreeSeats(int freeSeats);

    Event findByUUID(UUID uuid);

}