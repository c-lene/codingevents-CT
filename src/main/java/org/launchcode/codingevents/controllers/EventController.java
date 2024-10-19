package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

    // A Static ArrayList that allows access at Class level
    // Static List only exist in the lifetime of the application ==> Once Quit, all data will be lost
//    private static List<String> events = new ArrayList<>();
    private static HashMap<String, String> events = new HashMap<>();



    @GetMapping
    public String displayAllEvents(Model model) {
        String title = "All Events";

        events.put("Menteaship", "A fun meetup for connecting with mentors");
        events.put("Code With Pride", "A fun meetup sponsored by LaunchCode");
        events.put("Javascripty", "An imaginary meetup for Javascript developers");

        model.addAttribute("events", events);
        model.addAttribute("title", title);
        return "events/index";
    }


    // Handles request at http://localhost:8080/events/create
    @GetMapping("create")
    public String renderCreateEventForm(Model model) {
        String title = "Create Event";
        model.addAttribute("title", title);
        return "events/create";
    }


    // Handles request for the form at http://localhost:8080/events/create
    @PostMapping("create")
    public String createEvent(@RequestParam String eventName, @RequestParam String eventDescription) {
//        events.add(eventName);
        events.put(eventName, eventDescription);

        // Returns a Redirect Response to the root path controller ==> displays output of eventName
        return "redirect:/events";
    }

}
