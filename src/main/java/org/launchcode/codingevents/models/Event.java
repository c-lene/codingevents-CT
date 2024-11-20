package org.launchcode.codingevents.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
public class Event extends AbstractEntity {

    /** FIELDS **/

    @NotBlank(message = "Name is REQUIRED.")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    @ManyToOne
    @NotNull(message = "Category is REQUIRED.")
    private EventCategory eventCategory;

    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    @NotNull
    private EventDetails eventDetails;



    /** CONSTRUCTOR **/
    public Event(String name, EventCategory eventCategory) {
        this.name = name;
        this.eventCategory = eventCategory;
        
    }

    // Added a No-Arg Constructor to Event that doesn't require any arguments
    public Event() {

    }



    /** GETTER & SETTER **/
    public String getName() {
        return name;
    }

    public EventCategory getEventCategory() {
        return eventCategory;
    }

    public EventDetails getEventDetails() {
        return eventDetails;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEventCategory(EventCategory eventCategory) {
        this.eventCategory = eventCategory;
    }

    public void setEventDetails(EventDetails eventDetails) {
        this.eventDetails = eventDetails;
    }

    /** ToString Method **/
    @Override
    public String toString() {
        return name;
    }

}
