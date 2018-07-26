package com.bravedroid;

import com.bravedroid.printing_quotes.business.QuotesAdder;
import com.bravedroid.printing_quotes.business.Repository;
import com.bravedroid.printing_quotes.dal.QuoteDal;
import com.bravedroid.printing_quotes.presenter.Presenter;

public class Main {
    public static void main(String[] args) throws Exception {
        Repository quoteDal = new QuoteDal();
        //Repository quoteDal2 = new QuoteDal2();
        QuotesAdder quotesAdder = new QuotesAdder(quoteDal);
        //QuotesAdder quotesAdder = new QuotesAdder(quoteDa2);
        Presenter printerQuotes = new Presenter(quotesAdder);
        printerQuotes.printQuotes();
    }
}
