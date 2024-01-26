package lorenza.week3project.controller;

import lorenza.week3project.entities.Event;
import lorenza.week3project.entities.User;
import lorenza.week3project.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/events")
public class EventController {
    @Autowired
    private EventService eventService;

    @GetMapping("/list")
    public String eventList(Model model) {
        List<Event> events = eventService.getEventsWithFreeSeats();
        model.addAttribute("events", events);
        return "eventList";
    }

    @GetMapping("/{eventUUID}")
    public Event getEventByUUID(@PathVariable UUID eventUUID) {
        return EventService.findByUUID(eventUUID);
    }


    @PutMapping("/{eventUUID}")
    public Event getEventByUUIDAndUpdate(@PathVariable UUID eventUUID, @RequestBody Event modifiedEventPayload) {
        return EventService.findByUUIDAndUpdate(eventUUID, modifiedEventPayload);
    }

    @DeleteMapping("/{eventUUID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void getEventByUUIDAndDelete(@PathVariable UUID eventUUID) {
        eventService.findByUUIDAndDelete(eventUUID);
    }

}