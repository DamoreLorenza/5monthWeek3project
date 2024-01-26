package lorenza.week3project.services;

import lorenza.week3project.entities.Event;
import lorenza.week3project.entities.User;
import lorenza.week3project.exceptions.NotFoundException;
import lorenza.week3project.payload.NewEventDTO;
import lorenza.week3project.repositories.EventDAO;
import lorenza.week3project.repositories.UserDAO;
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
    public Event save(NewEventDTO newEventDTOPayload) {
        return null;
    }

}