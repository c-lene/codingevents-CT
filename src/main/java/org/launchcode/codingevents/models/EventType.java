package org.launchcode.codingevents.models;

public enum EventType {

    /** 4 enums of EventType object **/
    CONFERENCE("Conference"),
    MEETUP("Meetup"),
    WORKSHOP("Workshop"),
    SOCIAL("Social");


    /** FIELDS **/
    private final String displayName;


    /** CONSTRUCTOR **/
    EventType(String displayName) {
        this.displayName = displayName;
    }


    /** GETTER & SETTERS **/

    // No Setter is used because field is "final"
    // Uses Getter to call the Constructor to use specific String value associated with the Field

    public String getDisplayName() {
        return displayName;
    }

}
