package org.launchcode.codingevents.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;


@Entity
public class EventCategory extends AbstractEntity {

    /** FIELDS **/
    @Size(min = 3, message = "Name must be AT LEAST 3 characters long.")
    private String name;

    @OneToMany(mappedBy = "eventCategory")
    private final List<Event> events = new ArrayList<>();



    /** CONSTRUCTORS **/
    // Primary Constructor
    public EventCategory(@Size(min = 3, message = "Name must be AT LEAST 3 characters long.") String name) {
        this.name = name;
    }

    // No-arg Constructor
    public EventCategory(){

    }



    /** GETTERS & SETTERS **/
    public String getName() {
        return name;
    }

    public List<Event> getEvents() {
        return events;
    }


    public void setName(String name) {
        this.name = name;
    }


    /** Override Methods **/
    @Override
    public String toString() {
        return name;
    }

}