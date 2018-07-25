package com.bravedroid.presenter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Presenter {
    private int count = 0;
    private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private String inputString;

    public void promptStringAdedByUser() throws IOException {
        System.out.println("What is the input string?");
        inputString = input.readLine();
    }

    public void printNumberOfCharacter() throws IOException {
        if (inputString.length() != 0 && !inputString.equals("exit")) {
            System.out.println(inputString + " " + inputString.length() + " characters");
            promptStringAdedByUser();
            printNumberOfCharacter();
            count = 0;

        } else if (inputString.length() == 0) {
            while (count < 3) {
                count++;
                System.out.println(" Please Enter A string !!!");
                if (count == 3) {
                    System.out.println("this is the last chance");
                }
                promptStringAdedByUser();
                printNumberOfCharacter();

            }
        }
    }
}