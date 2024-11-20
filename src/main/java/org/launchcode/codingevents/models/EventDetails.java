package org.launchcode.codingevents.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;



@Entity
public class EventDetails extends AbstractEntity {

    /** FIELDS **/
    @Size(max = 500, message = "Description too long!")
    private String description;

    @NotBlank(message = "Email is REQUIRED.")
    @Email(message = "Invalid email. Try again!")
    private String contactEmail;

    // Creates the INVERSE One-to-One relationship between  <== REFERENCE ONLY, App does not need
//    @OneToOne(mappedBy = "eventDetails")
//    private Event event;



    /** CONSTRUCTORS **/

    // Primary Constructor
    public EventDetails(String description, String contactEmail) {
        this.description = description;
        this.contactEmail = contactEmail;
    }

    // No-args Constructor
    public EventDetails () {

    }



    /** GETTER & SETTER **/
    public @Size(max = 500, message = "Description too long!") String getDescription() {
        return description;
    }

    public void setDescription(@Size(max = 500, message = "Description too long!") String description) {
        this.description = description;
    }

    public @NotBlank(message = "Email is REQUIRED.") @Email(message = "Invalid email. Try again!") String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(@NotBlank(message = "Email is REQUIRED.") @Email(message = "Invalid email. Try again!") String contactEmail) {
        this.contactEmail = contactEmail;
    }

}
