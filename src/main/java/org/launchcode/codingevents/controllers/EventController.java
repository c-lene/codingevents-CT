package org.launchcode.codingevents.controllers;

import jakarta.validation.Valid;
import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

    @GetMapping
    public String displayAllEvents(Model model) {
        String title = "All Events";

        // uses the event object to pass into the View
        model.addAttribute("events", EventData.getAll());
        model.addAttribute("title", title);
        return "events/index";
    }


    // Handles request at http://localhost:8080/events/create
    @GetMapping("create")
    public String displayCreateEventForm(Model model) {
        String title = "Create Event";
        model.addAttribute("title", title);

        // Allows to pass an Empty Event into the View => Used to store information about Event fields
        model.addAttribute(new Event());

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
        EventData.add(newEvent);

        // Returns a Redirect Response to the root path controller ==> displays output of eventName
        return "redirect:/events";
    }


    // Handler method that displays the form
    @GetMapping("delete")
    public String displayDeleteEventForm(Model model) {
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events", EventData.getAll());
        return "events/delete";

    }


    // Handler uses "required = false" parameter to make optional
    // Allows user to submit without any events selected
    @PostMapping("delete")
    public String processDeleteEventsForm(@RequestParam(required = false) int[] eventIds) {

        // Once 'eventIds' is optional, uses IF statement to check that it is not "null" before entering the loop
        if (eventIds != null) {
            for (int id : eventIds) {
                EventData.remove(id);
            }
        }

        return "redirect:/events";
    }

}
