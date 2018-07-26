package com.bravedroid.printing_quotes.business;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class QuotesAdderTest {
    private QuotesAdder SUT;

    //given
    @Before
    public void setup() {
        Repository mockedRepo = new Repository() {
            @Override
            public boolean storeQuote(String quotes) throws IOException {
                return true;
            }
        };

        SUT = new QuotesAdder(mockedRepo);
    }

    @Test
    public void addQuotes_corrrectCase_returnquote() throws Exception {
        //when
        final String quodeReturn = SUT.addQuotes("Don't cry because it's over, smile because it happened.", "Dr. Seuss");
        final String expected = "Dr. Seuss says \"Don't cry because it's over, smile because it happened.\"";
        //then
        assertEquals(expected, quodeReturn);
    }

    @Test(expected = Exception.class)
    public void addQuotes_emptyInputCase_returnException() throws Exception {
        SUT.addQuotes("", "");
    }

    @Test
    public void saveQuotes() throws IOException {
        boolean returnResult = SUT.saveQuotes("Dr. Seuss says \"Don't cry because it's over, smile because it happened.\"");
        assertEquals(true, returnResult);
    }
}