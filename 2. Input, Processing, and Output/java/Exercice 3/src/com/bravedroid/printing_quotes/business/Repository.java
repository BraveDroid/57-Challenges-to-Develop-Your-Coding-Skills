package com.bravedroid.printing_quotes.business;

import java.io.IOException;

public interface Repository {
    void storeQuote(String quotes) throws IOException;
}
