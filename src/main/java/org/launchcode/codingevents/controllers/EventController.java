package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String renderCreateEventForm(Model model) {
        String title = "Create Event";
        model.addAttribute("title", title);
        return "events/create";
    }


    // Handles request for the form at http://localhost:8080/events/create
    @PostMapping("create")
    public String processCreateEventForm(@ModelAttribute Event newEvent) {

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


    @GetMapping("edit/{eventId}")
    public String displayEditForm(Model model, @PathVariable int eventId) {

        // Use an EventData method to find the event object with the given eventId.
        Event eventToEdit = EventData.getById(eventId);

        // Put the event object in the model with .addAttribute().
        model.addAttribute("event", eventToEdit);

        // Add a title to model that reads “Edit Event NAME (id=ID)” where NAME and ID are replaced by the values for the given event.
        String title = "Edit Event" + eventToEdit.getName() + " (id=" + eventToEdit.getId() + ")";
        model.addAttribute("title", title);


        return "events/edit";
    }


    @PostMapping("edit")
    public String processEditForm(int eventId, String name, String description) {
        // Query 'EventData' or the event being edited with the given id paramer
        Event eventToEdit = EventData.getById(eventId);

        // Update the 'name' & 'description' of the event with the appropriate model setter methods
        eventToEdit.setName(name);
        eventToEdit.setDescription(description);

        // Redirect the user to "/events" (the event listing page)
        return "redirect:/events";
    }



}
