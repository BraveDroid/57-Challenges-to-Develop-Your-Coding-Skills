package com.bravedroid.passive_way.presentation;

import com.bravedroid.passive_way.applicatiion.GreetingAdder;

public class Presenter {
    private GreetingAdder greetingAdder;
    private String name;

    public Presenter(GreetingAdder greetingAdder) {
        this.greetingAdder = greetingAdder;
    }

    public void promptUserName() {
// TODO: 21/07/2018 update the name
    }

    public void printGreetingForUser() {
        String greeting = greetingAdder.addGreeting(name);
        // TODO: 21/07/2018 show the greeting
    }
}
