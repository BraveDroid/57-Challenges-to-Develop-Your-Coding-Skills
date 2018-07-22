package com.bravedroid.passive_way.applicatiion;

import org.junit.Test;

import static org.junit.Assert.*;

public class GreetingAdderTest {
    //given
    GreetingAdder greetingAdder = new GreetingAdder();
    //when
    //then

    @org.junit.Test
    public void addGreeting_correctCase_returnHelloRefka() throws Exception {
        //when
        String returnSolution = greetingAdder.addGreeting("Refka");
        String expected = "Hello Refka";
        assertEquals(expected, returnSolution);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addGreeting_exceptionCase_returnException() throws Exception {
        //when
        String returnSolution = greetingAdder.addGreeting("");
    }

}