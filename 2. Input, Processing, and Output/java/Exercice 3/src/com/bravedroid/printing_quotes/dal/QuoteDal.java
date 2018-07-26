package com.bravedroid.printing_quotes.dal;

import com.bravedroid.printing_quotes.business.Repository;

import java.io.IOException;
import java.io.PrintWriter;

public class QuoteDal implements Repository {
    @Override
    public boolean storeQuote(String quote) throws IOException {
        PrintWriter writer = new PrintWriter("Quotes.txt", "UTF-8");
        writer.println(quote);
        writer.close();
        return true;
    }
}
