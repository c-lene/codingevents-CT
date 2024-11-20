package org.launchcode.codingevents.controllers;

import jakarta.validation.Valid;
import org.launchcode.codingevents.data.EventCategoryRepository;
import org.launchcode.codingevents.data.EventRepository;
import org.launchcode.codingevents.models.Event;
import org.launchcode.codingevents.models.EventCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;




@Controller
@RequestMapping("events")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventCategoryRepository eventCategoryRepository;

    // findAll, save, findById


   // Allows requests to URLs like /events?categoryId=1
    @GetMapping
    public String displayEvents(@RequestParam(required = false) Integer categoryId, Model model) {

        if (categoryId == null) {
            // uses the event object to pass into the View
            model.addAttribute("title", "All Events");
            model.addAttribute("events", eventRepository.findAll());

        } else {
            // Queries repository for a category object with the given ID
            Optional<EventCategory> result = eventCategoryRepository.findById(categoryId);

            // IF the query did NOT return a VALID categoryId
            if (result.isEmpty()) {
                model.addAttribute("title", "Invalid Category ID: " + categoryId);

            } else {
                // ELSE if query returned a VALID categoryId => will get the result of the query
                EventCategory category = result.get();
                model.addAttribute("title", "Events in Category: " + category.getName());

                // Passes the Events into the View
                model.addAttribute("events", category.getEvents());
            }
        }
        return "events/index";
    }


    // Handles request at http://localhost:8080/events/create
    @GetMapping("create")
    public String displayCreateEventForm(Model model) {
        model.addAttribute("title", "Create Event");

        // Passes an empty Event object into the View by calling the No-Arg Constructor => Used to store information about Event fields
        model.addAttribute(new Event());

        // Will return an Array of values of the 4 EventType Enums
        model.addAttribute("categories", eventCategoryRepository.findAll());

        return "events/create";
    }


    // Handles request for the form at http://localhost:8080/events/create
    @PostMapping("create")
    public String processCreateEventForm(@ModelAttribute @Valid Event newEvent, Errors errors, Model model) {

        // IF validation errors present, redirects to page back to the original form
        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Event");

            // Adds an Error message notify user of validation error
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