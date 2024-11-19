package org.launchcode.codingevents.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.util.Objects;

@MappedSuperclass
public abstract class AbstractEntity {


    /** FIELDS **/
    @Id
    @GeneratedValue
    private int id;


    /** GETTER & SETTER **/
    public int getId() {
        return id;
    }


    /** equals() & hashcode() Method **/
    // Compares the id to make objects are the same if id matches
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity entity = (AbstractEntity) o;
        return id == entity.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
