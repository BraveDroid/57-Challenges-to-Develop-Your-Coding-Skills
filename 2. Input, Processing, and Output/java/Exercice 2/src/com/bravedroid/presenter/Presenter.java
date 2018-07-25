package com.bravedroid.presenter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Presenter {
    private int failedInputCount = 0;
    private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private String inputString;

    public void promptUserString() throws IOException {
        System.out.println("What is the input string?");
        inputString = input.readLine();

    }

    public void printNumberOfCharacter() throws IOException {
        if (inputString.length() != 0 && !inputString.equals("exit")) {
            System.out.println(inputString + " " + inputString.length() + " characters");
            failedInputCount = 0;
            promptUserString();
            printNumberOfCharacter();


        } else if (inputString.length() == 0) {
            while (failedInputCount < 3) {
                failedInputCount++;
                System.out.println(" Please Enter A string !!!");
                if (failedInputCount == 3) {
                    System.out.println("this is the last chance");
                }
                promptUserString();
                printNumberOfCharacter();
            }
        }
        //if( inputString ) is equal to "exit " the program will just continue... the END because there is no more instructions.
    }
}