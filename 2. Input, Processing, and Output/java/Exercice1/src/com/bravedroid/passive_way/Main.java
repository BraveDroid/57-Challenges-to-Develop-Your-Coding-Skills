package com.bravedroid.passive_way;

import com.bravedroid.passive_way.applicatiion.GreetingAdder;
import com.bravedroid.passive_way.presentation.Presenter;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws Exception {
        GreetingAdder greetingAdder = new GreetingAdder();
        Presenter presenter = new Presenter(greetingAdder);

        presenter.promptUserName();
        presenter.printGreetingForUser();
    }
}
