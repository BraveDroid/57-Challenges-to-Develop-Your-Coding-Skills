package com.bravedroid.printing_quotes.business;

import java.io.IOException;

public interface Repository {
    boolean storeQuote(String quotes) throws IOException;
}
