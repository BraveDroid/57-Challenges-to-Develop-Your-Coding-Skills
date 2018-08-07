package com.bravedroid;

import com.bravedroid.presenter.PasswordValidationPrinter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        PasswordValidationPrinter passwordValidationPrinter = new PasswordValidationPrinter();
        passwordValidationPrinter.readPassWord();
        passwordValidationPrinter.printPassWord();
    }
}
