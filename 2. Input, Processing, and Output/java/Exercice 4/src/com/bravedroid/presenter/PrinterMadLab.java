package com.bravedroid.presenter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrinterMadLab {
    public void printMadLab() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String noun = getWord(input, "noun");
        String verb = getWord(input, "verb");
        String adjective = getWord(input, "adjective");
        String adverb = getWord(input, "adverb");
        System.out.println("Do you " + verb + " your " + adjective + " " + noun + " " + adverb + " ? That 's hilarious!");
    }

    private String getWord(BufferedReader input, String expectedWord) throws IOException {
        String prefix = "a";

        if (expectedWord.startsWith("a") ||
                expectedWord.startsWith("e") ||
                expectedWord.startsWith("i") ||
                expectedWord.startsWith("u") ||
                expectedWord.startsWith("o")) {
            //prefix = "an";
            prefix += "n";
        }

        System.out.println("Enter " + prefix + " " + expectedWord + " : ");
        String word = input.readLine();
        while (word.length() == 0) {
            System.out.println("Enter the requirements string");
            System.out.println("Enter " + prefix + " " + expectedWord + " : ");
            word = input.readLine();
        }
        return word;
    }
}
