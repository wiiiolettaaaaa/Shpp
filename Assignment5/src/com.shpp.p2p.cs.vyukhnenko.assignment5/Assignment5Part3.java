package com.shpp.p2p.cs.vyukhnenko.assignment5;

import acm.util.ErrorException;
import com.shpp.cs.a.console.TextProgram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Assignment5Part3 extends TextProgram {
    /**
     * Path to the dictionary
     */
    private static final String DICTIONARY = "/Users/wioletta/IdeaProjects/ShppGit/Assignment5/files/en-dictionary.txt";

    private final ArrayList<String> dictionary = readDictionary();

    /**
     * Program that asks the user for a three-letter string
     * and then displays words that can be formed from those letters.
     */
    public void run() {
        while (true) {
            String userInput = readLine("Enter line with 3 letters: ");
            if (isWord(userInput)) {
                if (wrongQuantity(userInput)) {
                    println("You wrote wrong quantity of letters. Please try again)");
                    continue;
                }

                println("Words: " + findWords(userInput));
            } else {
                println("You wrote not letters. Please try again)");
            }
        }
    }

    /**
     * Checks if user enter three letters
     *
     * @param userInput String that user input
     * @return Boolean true or false
     */
    private boolean wrongQuantity(String userInput) {
        if(userInput.length() > 3) {
            return true;
        }else if(userInput.length() < 3) {
            return true;
        }

        return false;
    }

    /**
     * ArrayList which contains all words from dictionary that contains user input letters in
     * the order in which they were introduced
     *
     * @param userInput String that user input which contains 3 letters
     * @return Founded words with 3 letters
     */
    private ArrayList<String> findWords(String userInput) {

        //3 letters user input
        char[] userInputLetters = userInput.toLowerCase().toCharArray();

        //For founded words
        ArrayList<String> foundedWords = new ArrayList<>();

        for (int wordInDictionary = 0; wordInDictionary < dictionary.size(); wordInDictionary++) {
            //word in dictionary
            String currentWord = dictionary.get(wordInDictionary);
            //letters of current world from dictionary
            char[] lettersInCurrentWord = currentWord.toLowerCase().toCharArray();

            searchWord:
            //Checks for the first letters, if the word contain, go to next letter
            for (int a = 0; a < lettersInCurrentWord.length; a++) {
                if (userInputLetters[0] == lettersInCurrentWord[a]) {
                    //Checks for the second letters, if the word contain, go to next letter
                    for (int b = a + 1; b < lettersInCurrentWord.length; b++) {
                        if (userInputLetters[1] == lettersInCurrentWord[b]) {
                            //Checks for the first letters, if the word contain, put the word to Arraylist and break cycles
                            for (int c = b + 1; c < lettersInCurrentWord.length; c++) {
                                if (userInputLetters[2] == lettersInCurrentWord[c]) {
                                    foundedWords.add(currentWord);
                                    break searchWord;
                                }
                            }
                        }
                    }
                }
            }
        }

        return foundedWords;
    }


    /**
     * Read line from file and put it to the ArrayList
     *
     * @return ArrayList from file
     */
    private ArrayList<String> readDictionary() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(DICTIONARY));
            ArrayList<String> dictionary = new ArrayList<String>();

            while (true) {
                String world = br.readLine();
                if (world == null) {
                    break;
                }
                dictionary.add(world);
            }

            br.close();
            return dictionary;

        } catch (IOException e) {
            throw new ErrorException(e);
        }
    }

    /**
     * Check is user input is a letters and isn't it empty
     *
     * @param letters A string contains user input letters
     * @return Boolean true or false
     */
    private boolean isWord(String letters) {
        //Checks is there are some chars
        if (letters == null || letters.isEmpty()) {
            return false;
        }

        char symbols[] = letters.toCharArray();

        //Checks is chars - letters
        for (int i = 0; i < symbols.length; i++) {
            if (!Character.isLetter(symbols[i])) {
                return false;
            }

        }
        return true;
    }
}
