package org.launchcode.codingevents.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
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

    @Size(max = 500, message = "Description too long!")
    private String description;

    @NotBlank(message = "Email is REQUIRED.")
    @Email(message = "Invalid email. Try again!")
    private String contactEmail;

    @ManyToOne
    @NotNull(message = "Category is REQUIRED.")
    private EventCategory eventCategory;


    /** CONSTRUCTOR **/
    public Event(String name, String description, String contactEmail, EventCategory eventCategory) {
        this.name = name;
        this.description = description;
        this.contactEmail= contactEmail;
        this.eventCategory = eventCategory;
        
    }

    // Added a No-Arg Constructor to Event that doesn't require any arguments
    public Event() {

    }



    /** GETTER & SETTER **/
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public @Email String getContactEmail() {
        return contactEmail;
    }

    public EventCategory getEventCategory() {
        return eventCategory;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setContactEmail(@Email String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public void setEventCategory(EventCategory eventCategory) {
        this.eventCategory = eventCategory;
    }



    /** ToString Method **/
    @Override
    public String toString() {
        return name;
    }

}
