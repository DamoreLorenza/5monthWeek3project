package lorenza.week3project.services;

import lorenza.week3project.entities.Event;
import lorenza.week3project.repositories.EventDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventDAO eventDAO;

    public List<Event> getEventsWithFreeSeats() {
        return eventDAO.findFreeSeats(0);
    }


}