package lorenza.week3project.services;

import lorenza.week3project.entities.Event;
import lorenza.week3project.entities.Organizers;
import lorenza.week3project.entities.User;
import lorenza.week3project.exceptions.NotFoundException;
import lorenza.week3project.payload.NewUserDTO;
import lorenza.week3project.repositories.EventDAO;
import lorenza.week3project.repositories.OrganizerDAO;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrganizerService {
    @Autowired
    private EventDAO eventDAO;

    @Autowired
    private OrganizerDAO organizerDAO;

    public Organizers findByEmail(String email) throws NotFoundException {
        return organizerDAO.findByEmail(email).orElseThrow(() -> new NotFoundException("organizzatore con email " + email + " non trovato"));
    }

    public Organizers findByUUID(UUID uuid) {
        return organizerDAO.findById(uuid).orElseThrow(() -> new NotFoundException(uuid));
    }

    public Organizers findByUUIDAndUpdate(UUID uuid, Organizers body) {
        Organizers found = this.findByUUID(uuid);
        found.setOrganizer(body.getOrganizer());
        found.setPassword(body.getPassword());
        return organizerDAO.save(found);
    }

    public void findByUUIDAndDelete(UUID uuid) {
        Organizers found = this.findByUUID(uuid);
        organizerDAO.delete(found);
    }

    }