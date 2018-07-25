package com.bravedroid.printing_quotes.business;

import com.bravedroid.printing_quotes.presenter.Presenter;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuotesAdderTest {
    //given
    private Repository repository;
    private QuotesAdder quotesAdder = new QuotesAdder(repository);

    @org.junit.Test
    public void addQuotes_corrrectCase_returnquote() throws Exception {
        //when
        String quodeReturn = quotesAdder.addQuotes("Don't cry because it's over, smile because it happened.", "Dr. Seuss");
        String expected = "Dr. Seuss says \"Don't cry because it's over, smile because it happened.\"";
        //then
        assertEquals(expected, quodeReturn);
    }

    @Test(expected = Exception.class)
    public void addQuotes_emptyInputCase_returnquote() throws Exception{
        String returnSolution = quotesAdder.addQuotes("","");
    }
}