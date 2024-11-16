package org.launchcode.codingevents.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class Event {

    /** FIELDS **/
    private int id;
    private static int nextId = 1;

    @NotBlank(message = "Name is REQUIRED.")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    @Size(max = 500, message = "Description too long!")
    private String description;

    @NotBlank(message = "Email is REQUIRED.")
    @Email(message = "Invalid email. Try again!")
    private String contactEmail;


    /** CONSTRUCTOR **/
    public Event(String name, String description, String contactEmail) {
        this.name = name;
        this.description = description;
        this.contactEmail= contactEmail;
        this.id = nextId;
        nextId++;
    }

    // Created an Constructor for an Empty Event
    public Event() {}



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
