package org.launchcode.codingevents.models.dto;

import jakarta.validation.constraints.NotNull;
import org.launchcode.codingevents.models.Event;
import org.launchcode.codingevents.models.Tag;

public class EventTagDTO {

    /** FIELDS **/
    @NotNull
    private Event event;

    @NotNull
    private Tag tag;



    /** CONSTRUCTOR **/

    //No-args Constructor
    public EventTagDTO() {}



    /** GETTERS & SETTERS **/
    public @NotNull Event getEvent() {
        return event;
    }

    public void setEvent(@NotNull Event event) {
        this.event = event;
    }


    public @NotNull Tag getTag() {
        return tag;
    }

    public void setTag(@NotNull Tag tag) {
        this.tag = tag;
    }
}
