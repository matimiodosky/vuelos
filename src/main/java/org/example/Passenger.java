package org.example;

public class Passenger {

    private final String name;
    private final String id;

    public Passenger(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getId() {
        return this.id;
    }
}
