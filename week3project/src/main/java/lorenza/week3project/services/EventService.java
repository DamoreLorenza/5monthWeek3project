package lorenza.week3project.services;

import lorenza.week3project.entities.Event;
import lorenza.week3project.entities.User;
import lorenza.week3project.exceptions.NotFoundException;
import lorenza.week3project.repositories.EventDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class EventService {
    @Autowired
    private EventDAO eventDAO;

    public List<Event> getEventsWithFreeSeats() {
        return eventDAO.findFreeSeats(0);
    }


    public static Event findByUUID(UUID uuid) {
        return EventDAO.findByUUID(uuid).orElseThrow(() -> new NotFoundException(uuid));
    }

    public static Event findByUUIDAndUpdate(UUID uuid, Event body) {
        Event found = findByUUID(uuid);
        found.setTitle(body.getTitle());
        found.setDescription(body.getDescription());
        found.setLocation(body.getLocation());
        found.setFreeSeats(body.getFreeSeats());
        return EventDAO.save(found);
    }

    public void findByUUIDAndDelete(UUID uuid) {
        Event found = this.findByUUID(uuid);
        eventDAO.delete(found);
    }

}