package com.bravedroid.printing_quotes.presenter;

import com.bravedroid.printing_quotes.dal.QuoteDal;
import com.bravedroid.printing_quotes.business.QuotesAdder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Presenter {
    private QuotesAdder quotesAdder;

    public Presenter(QuotesAdder quotesAdder) {
        this.quotesAdder = quotesAdder;
    }

    public void printQuotes() throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("What is the quote?");
        String quotesText = input.readLine();
        System.out.println("Who said it?");
        String QuotesAuthor = input.readLine();

        String quoteToSave = quotesAdder.addQuotes(quotesText, QuotesAuthor);
        System.out.println(quoteToSave);
        // we should not do this way of communication because layer n+1 should not communicate directly with n-1
        //QuoteDal quoteDal = new QuoteDal();
        //try {
        //    quoteDal.storeQuote(quote);
        //} catch (IOException e) {
        //    e.printStackTrace();
        //    System.out.println("Error System we can't create files!!");
        //}
        try {
            quotesAdder.saveQuotes(quoteToSave);
        } catch (IOException e) {
            System.out.println("Error System we can't create files!!");
        }
    }
}
