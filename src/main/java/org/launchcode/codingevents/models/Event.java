package org.launchcode.codingevents.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.Objects;



@Entity
public class Event {

    /** FIELDS **/

    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message = "Name is REQUIRED.")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    @Size(max = 500, message = "Description too long!")
    private String description;

    @NotBlank(message = "Email is REQUIRED.")
    @Email(message = "Invalid email. Try again!")
    private String contactEmail;

    private EventType type;


    /** CONSTRUCTOR **/
    public Event(String name, String description, String contactEmail, EventType type) {
        this.name = name;
        this.description = description;
        this.contactEmail= contactEmail;
        this.type = type;
        
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

    public EventType getType() {
        return type;
    }

    public int getId() {
        return id;
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

    public void setType(EventType type) {
        this.type = type;
    }



    /** ToString Method **/
    @Override
    public String toString() {
        return name;
    }



    /** equals() & hashcode() Method **/
    // Compares the id to make objects are the same if id matches
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
