package org.launchcode.codingevents.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Size;


@Entity
public class EventCategory extends AbstractEntity {

    /** FIELDS **/

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

    public void setName(String name) {
        this.name = name;
    }


    /** Override Methods **/
    @Override
    public String toString() {
        return name;
    }

}