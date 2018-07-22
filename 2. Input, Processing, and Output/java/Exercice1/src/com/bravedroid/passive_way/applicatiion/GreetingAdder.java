package com.bravedroid.passive_way.applicatiion;

public class GreetingAdder {
    public String addGreeting(String name) throws IllegalArgumentException {
        if (name.equals("")) {
            throw new IllegalArgumentException();
        }
        return "Hello " + name;
    }
}
