package com.bravedroid.presenter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PasswordValidationPrinter {
    private boolean mustExit;
    private BufferedReader input;
    private String enteredPassWord;

    public PasswordValidationPrinter() {
        input = new BufferedReader(new InputStreamReader(System.in));
    }

    public void readPassWord() throws IOException {
        System.out.println("What is the password?");
        enteredPassWord = input.readLine();
        if (enteredPassWord.equals("exit"))
            mustExit = true;
    }

    public void printPassWord() throws IOException {
        if (mustExit) return;
        String correctPassWord = "abc$123";
        if (enteredPassWord.equals(correctPassWord)) {
            System.out.println("Welcome!");
        } else {
            System.out.println("I don't know you.");
            readPassWord();
            printPassWord();
        }
    }
}
