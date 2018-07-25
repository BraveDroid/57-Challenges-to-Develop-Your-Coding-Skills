package com.bravedroid.passive_way.applicatiion;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GreetingAdderTest {
    private GreetingAdder SUT;

    //giveN
    @Before
    public void setup() {
        SUT = new GreetingAdder();
    }

    @Test
    public void addGreeting_correctCase_returnHelloRefka() throws Exception {
        //when
        String returnSolution = SUT.addGreeting("Refka");
        //then
        String expected = "Hello Refka";
        assertEquals(expected, returnSolution);
    }

    //then
    @Test(expected = IllegalArgumentException.class)
    public void addGreeting_exceptionCase_returnException() throws Exception {
        //when
        String returnSolution = SUT.addGreeting("");
    }

}