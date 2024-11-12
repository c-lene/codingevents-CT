package org.launchcode.codingevents.models;

public class Event {

    private String name;
    private String description;


    /** CONSTRUCTOR **/
    public Event(String name, String description) {
        this.name = name;
        this.description = description;
    }


    /** GETTER & SETTER **/
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }




    /** ToString Method **/
    @Override
    public String toString() {
        return name;
    }
}
