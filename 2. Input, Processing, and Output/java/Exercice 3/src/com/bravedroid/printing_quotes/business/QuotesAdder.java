package com.bravedroid.printing_quotes.business;

import java.io.IOException;

public class QuotesAdder {
    private Repository repository;

    public QuotesAdder(Repository repository) {
        this.repository = repository;
    }

    public String addQuotes(String quotesText, String quotesAuthor) throws Exception {
        if (quotesText.length() == 0 || quotesAuthor.length() == 0) {
            throw new Exception(" Enter the requirements inputs");
        }

        StringBuilder quote = new StringBuilder(); // Using default 16 character size
        quote.append(quotesAuthor);
        quote.append(" says ");
        quote.append("\"");
        quote.append(quotesText);
        quote.append("\"");
        return quote.toString();
    }

    public boolean saveQuotes(String quoteToSave) throws IOException {
        //deligate the work to the responsible (repository)
        return repository.storeQuote(quoteToSave);
    }
}

