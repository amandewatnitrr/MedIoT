package com.example.myapplication.models;

public class doctor {
    private String name,specialisation;

    public doctor(String name, String specialisation) {
        this.name = name;
        this.specialisation = specialisation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }
}
