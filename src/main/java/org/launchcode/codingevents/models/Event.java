package org.launchcode.codingevents.models;

public class Event {

    private String name;


    /** CONSTRUCTOR **/
    public Event(String name) {
        this.name = name;
    }


    /** GETTER & SETTER **/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    /** ToString Method **/
    @Override
    public String toString() {
        return name;
    }
}
