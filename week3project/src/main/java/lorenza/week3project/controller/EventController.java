package lorenza.week3project.controller;

import lorenza.week3project.entities.Event;
import lorenza.week3project.exceptions.BadRequestException;
import lorenza.week3project.payload.NewEventDTO;
import lorenza.week3project.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createEvent(@RequestBody @Validated NewEventDTO newEventDTOPayload, BindingResult validation) {
        System.out.println(validation);
        if (validation.hasErrors()) {
            System.out.println(validation.getAllErrors());
            throw new BadRequestException("Errori nel payload");
        } else {
            Event newEvent = eventService.save(newEventDTOPayload);
        }
    }



    }