package org.launchcode.codingevents.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

import java.util.Objects;


@Entity
public class EventCategory {

    /** FIELDS **/
    @Id
    @GeneratedValue
    private int id;

    @Size(min = 3, message = "Name must be AT LEAST 3 characters long.")
    private String name;


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

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }


    /** Override Methods **/
    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventCategory that = (EventCategory) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
