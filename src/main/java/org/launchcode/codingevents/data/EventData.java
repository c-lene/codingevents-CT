package org.launchcode.codingevents.data;

import org.launchcode.codingevents.models.Event;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EventData {

    // Need a place to put events
    private static final Map<Integer, Event> events = new HashMap<>();


    // Get ALL events
    public static Collection<Event> getAll() {
        return events.values();
    }


    // Get a SINGLE event
    public static Event getById(int id) {
        return events.get(id);
    }


    // ADD an event
    public static void add(Event event) {
        events.put(event.getId(), event);
    }


    // REMOVE an event
    public static void remove(int id) {
        events.remove(id);
    }

}
