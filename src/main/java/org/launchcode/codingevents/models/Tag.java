package org.launchcode.codingevents.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Tag extends AbstractEntity {

    /** FIELDS **/
    @Size(min = 1, max = 25)
    @NotBlank
    private String name;



    /** CONSTRUCTORS **/
    // Primary Constructor
    public Tag(String name) {
        this.name = name;
    }

    // No-args Constructor
    public Tag() {}



    /** GETTER & SETTER **/
    public @Size(min = 1, max = 25) @NotBlank String getName() {
        return name;
    }

    public void setName(@Size(min = 1, max = 25) @NotBlank String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return "#" + name + " ";
    }

}
