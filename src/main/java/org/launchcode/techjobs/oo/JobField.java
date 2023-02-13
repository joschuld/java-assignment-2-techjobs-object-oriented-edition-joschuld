package org.launchcode.techjobs.oo;

import java.util.Objects;

public abstract class JobField {

    //overlapping fields
    private int id;
    private static int nextId = 1;
    private String value;

    //overlapping constructors
    public JobField() {
        this.id = nextId;
        nextId++;

    }

    public JobField(String value) {
        this();
        this.value = value;
    }

    //overlapping setters/getters

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    //overlapping custom methods
    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobField)) return false;
        JobField jobField = (JobField) o;
        return getId() == jobField.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
