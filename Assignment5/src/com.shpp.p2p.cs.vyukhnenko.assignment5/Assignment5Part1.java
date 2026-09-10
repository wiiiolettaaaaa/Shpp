package com.shpp.p2p.cs.vyukhnenko.assignment5;

import com.shpp.cs.a.console.TextProgram;

public class Assignment5Part1 extends TextProgram {

    //Array with vowels
    private static final char[] vowels = {'a', 'e', 'i', 'o', 'u', 'y'};

    public void run() {
        /* Repeatedly prompt the user for a word and print out the estimated
         * number of syllables in that word.
         */
        while (true) {
            String word = readLine("Enter a single word: ");
            if (isWord(word)) {
                println("  Syllable count: " + syllablesInWord(word));
            } else {
                println("  Not a word ");
            }
        }
    }

    /**
     * Given a word, estimates the number of syllables in that word according to the
     * heuristic specified in the handout.
     *
     * @param word A string containing a single word.
     * @return An estimate of the number of syllables in that word.
     */
    private int syllablesInWord(String word) {
        int syllables = 0;
        //Create array of chars(letters) from String word and put it to lower case
        char letters[] = word.toLowerCase().toCharArray();

        //Cycle which looks on every letter from the word and checks is it vowel or not
        //If vowel - syllables count increase and if not or next also vowel - go to next letter
        for (int i = 0; i < letters.length - 1; i++) {
            if (isVowel(letters[i])) {
                syllables++;
                while (i + 1 < letters.length - 1 && isVowel(letters[i + 1])) {
                    i++;
                }
            }
        }

        //If the last letter is vowel and before it consonant letter, and it's not letter 'e' - syllables count increase;
        if (isVowel(letters[letters.length - 1]) && letters[letters.length - 1] != vowels[1] && !isVowel(letters[letters.length - 2])) {
            syllables++;
        }

        //If there aren't any vowels - add one
        if (syllables == 0) {
            syllables++;
        }

        return syllables;
    }

    /**
     * Check is user input is a word and isn't it empty
     *
     * @param word A string contains user input word
     * @return Boolean true or false
     */
    private boolean isWord(String word) {
        //Checks is there are some chars
        if (word == null || word.isEmpty()) {
            return false;
        }

        char symbols[] = word.toCharArray();

        //Checks is chars - letters
        for (int i = 0; i < symbols.length; i++) {
            if (!Character.isLetter(symbols[i])) {
                return false;
            }

        }
        return true;
    }

    /**
     * Checker is current letter vowel or not
     *
     * @param letter Char which make String word(user input)
     * @return Boolean true or false
     */
    private boolean isVowel(char letter) {
        for (int i = 0; i < vowels.length; i++) {
            if (letter == vowels[i]) {
                return true;
            }
        }
        return false;
    }
}
