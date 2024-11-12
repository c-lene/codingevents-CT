package org.launchcode.codingevents.models;

public class Event {

    /** FIELDS **/
    private int id;
    private static int nextId = 1;

    private String name;
    private String description;


    /** CONSTRUCTOR **/
    public Event(String name, String description) {
        this.name = name;
        this.description = description;
        this.id = nextId;
        nextId++;
    }


    /** GETTER & SETTER **/
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
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




    /** ToString Method **/
    @Override
    public String toString() {
        return name;
    }
}
