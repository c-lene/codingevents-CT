package org.launchcode.codingevents.controllers;

import jakarta.validation.Valid;
import org.launchcode.codingevents.data.EventRepository;
import org.launchcode.codingevents.models.Event;
import org.launchcode.codingevents.models.EventType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    // findAll, save, findById

    @GetMapping
    public String displayAllEvents(Model model) {
        String title = "All Events";

        // uses the event object to pass into the View
        model.addAttribute("events", eventRepository.findAll());
        model.addAttribute("title", title);
        return "events/index";
    }


    // Handles request at http://localhost:8080/events/create
    @GetMapping("create")
    public String displayCreateEventForm(Model model) {
        String title = "Create Event";

        model.addAttribute("title", title);

        // Passes an empty Event object into the View by calling the No-Arg Constructor => Used to store information about Event fields
        model.addAttribute(new Event());

        // Will return an Array of values of the 4 EventType Enums
        model.addAttribute("types", EventType.values());

        return "events/create";
    }


    // Handles request for the form at http://localhost:8080/events/create
    @PostMapping("create")
    public String processCreateEventForm(@ModelAttribute @Valid Event newEvent, Errors errors, Model model) {

        // IF validation errors present, redirects to page back to the original form
        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Event");

            // Adds an Error message notify user of validation error
//            model.addAttribute("errorMsg", "Bad data!");
            return "events/create";
        }

        // Creates a new event object to pass into the List
        eventRepository.save(newEvent);

        // Returns a Redirect Response to the root path controller ==> displays output of eventName
        return "redirect:/events";
    }


    // Handler method that displays the form
    @GetMapping("delete")
    public String displayDeleteEventForm(Model model) {
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events", eventRepository.findAll());
        return "events/delete";

    }


    // Handler uses "required = false" parameter to make optional
    // Allows user to submit without any events selected
    @PostMapping("delete")
    public String processDeleteEventsForm(@RequestParam(required = false) int[] eventIds) {

        // Once 'eventIds' is optional, uses IF statement to check that it is not "null" before entering the loop
        if (eventIds != null) {
            for (int id : eventIds) {
                eventRepository.deleteById(id);
            }
        }

        return "redirect:/events";
    }

}
