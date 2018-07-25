package com.bravedroid;

import com.bravedroid.presenter.Presenter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Presenter counterCharInString = new Presenter();
        counterCharInString.promptUserString();
        counterCharInString.printNumberOfCharacter();
           }
    }


