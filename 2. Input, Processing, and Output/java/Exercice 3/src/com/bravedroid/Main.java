package com.bravedroid;

import com.bravedroid.printing_quotes.business.Repository;
import com.bravedroid.printing_quotes.dal.QuoteDal2;
import com.bravedroid.printing_quotes.presenter.Presenter;
import com.bravedroid.printing_quotes.dal.QuoteDal;
import com.bravedroid.printing_quotes.business.QuotesAdder;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Repository quoteDal = new QuoteDal();
        //Repository quoteDal2 = new QuoteDal2();
        QuotesAdder quotesAdder = new QuotesAdder(quoteDal);
        //QuotesAdder quotesAdder = new QuotesAdder(quoteDa2);
        Presenter printerQuotes = new Presenter(quotesAdder);
        printerQuotes.printQuotes();
    }
}
