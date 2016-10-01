package com.rh_navana_sorrento_am.ModelClass;

/**
 * Created by hhson on 10/1/2016.
 */
public class User {

    String name;
    String floor;

    public User(String name, String floor) {
        this.name = name;
        this.floor = floor;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }
}
