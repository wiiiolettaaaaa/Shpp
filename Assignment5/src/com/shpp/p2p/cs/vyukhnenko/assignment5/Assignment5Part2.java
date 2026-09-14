package com.shpp.p2p.cs.vyukhnenko.assignment5;

import com.shpp.cs.a.console.TextProgram;

public class Assignment5Part2 extends TextProgram {
    /**
     * The method accepts two String values and
     * returns a String value representing the sum of the accepted numbers.
     */
    public void run() {
        /* Sit in a loop, reading numbers and adding them. */
        while (true) {
            String n1 = readLine("Enter first number:  ");
            while (!isNum(n1)) {
                println("Not a number");
                n1 = readLine("Enter first number:  ");
            }

            String n2 = readLine("Enter second number: ");
            while (!isNum(n2)) {
                println("Not a number");
                n2 = readLine("Enter second number:  ");
            }

            println(n1 + " + " + n2 + " = " + addNumericStrings(n1, n2));
            println();
        }
    }

    /**
     * Checker if string that user input contains only digits and isn't it empty
     *
     * @param num String which user input
     * @return Boolean true or false
     */
    private boolean isNum(String num) {
        //Checks isn't user input empty
        if (num == null || num.isEmpty()) {
            return false;
        }

        char[] nums = num.toCharArray();

        //Cycle which look for every char of the string and if it's not a digit return false
        for (int i = 0; i < nums.length; i++) {
            if (!Character.isDigit(nums[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * Given two string representations of nonnegative integers, adds the
     * numbers represented by those strings and returns the result.
     *
     * @param n1 The first number.
     * @param n2 The second number.
     * @return A String representation of n1 + n2
     */
    private String addNumericStrings(String n1, String n2) {
        char digit1[] = n1.toCharArray();
        char digit2[] = n2.toCharArray();

        theLongestOne(n1, n2);
        //Array with result of addition
        char res[] = new char[theLongestOne(n1, n2) + 1];
        //Length of the longest one number
        int length = theLongestOne(n1, n2);
        //Difference between numbers
        int diff = Math.abs(n1.length() - n2.length());
        //Ten that is carried
        int step = 0;

        //Cycle which add num1 to num2
        for (int i = length - 1; i >= 0; i--) {
            //Summery of two digits(chars)
            int sum = 0;
            //Char from digit1
            int d1 = 0;
            //Char from digit2
            int d2 = 0;

            if (n1.length() >= n2.length()) {
                d1 = digit1[i] - '0';
                d2 = i - diff >= 0 ? digit2[i - diff] - '0' : 0;
            } else {
                d2 = digit2[i] - '0';
                d1 = i - diff >= 0 ? digit1[i - diff] - '0' : 0;
            }

            sum = d1 + d2 + step;
            //Trough integer division, finds out if there is a ten
            step = sum / 10;
            res[i + 1] = (char) ((sum % 10) + '0');
        }
        res[0] = (char) (step + '0');

        String result = new String(res);

        int indexLastZeroFromBeggining = 0;

        //If there are zero in the begging of result, find index of the last one
        for (int i = 0; i < result.length(); i++) {
            if (res[i] == '0') {
                indexLastZeroFromBeggining += 1 ;
            }else{
                break;
            }
        }

        if (res[0] == '0') {
            return result.substring(indexLastZeroFromBeggining);
        }

        return result;
    }

    /**
     * Method that  compares which num is longer
     *
     * @param n1 First number that user input
     * @param n2 Second number that user input
     * @return Length of the longest one number
     */
    private int theLongestOne(String n1, String n2) {
        int lengthForResultArray = 0;

        if (n1.length() > n2.length()) {
            lengthForResultArray = n1.length();
        } else {
            lengthForResultArray = n2.length();
        }

        return lengthForResultArray;
    }

}
