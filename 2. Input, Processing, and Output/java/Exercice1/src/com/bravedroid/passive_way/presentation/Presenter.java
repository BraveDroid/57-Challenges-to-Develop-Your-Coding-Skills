package com.bravedroid.passive_way.presentation;

import com.bravedroid.passive_way.applicatiion.GreetingAdder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Presenter {
    private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private GreetingAdder greetingAdder;
    private String name;

    public Presenter(GreetingAdder greetingAdder) {
        this.greetingAdder = greetingAdder;
    }

    public void promptUserName() throws IOException {
        System.out.println("Whats your name");
        name = input.readLine();
    }

    public void printGreetingForUser() throws IOException {
        try {
            String greeting = greetingAdder.addGreeting(name);
            System.out.println(greeting);
        } catch (IllegalArgumentException e) {
            System.out.println("please provide non impty name");
            promptUserName();
            printGreetingForUser();
        }
    }
}