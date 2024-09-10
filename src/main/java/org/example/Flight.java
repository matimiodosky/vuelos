package org.example;

import java.util.Objects;

public class Flight {

    private final String code;
    private final Airport from;
    private final Airport to;
    private final int capacity;

    public Flight(String code, Airport from, Airport to, int capacity) {
        this.code = code;
        this.from = from;
        this.to = to;
        this.capacity = capacity;
    }

    public String getCode() {
        return code;
    }

    public Airport getFrom() {
        return from;
    }

    public Airport getTo() {
        return to;
    }

    public int getCapacity() {
        return capacity;
    }
}
