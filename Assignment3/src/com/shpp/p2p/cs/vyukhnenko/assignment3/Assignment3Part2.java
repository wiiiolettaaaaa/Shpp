package com.shpp.p2p.cs.vyukhnenko.assignment3;

import com.shpp.cs.a.console.TextProgram;

public class Assignment3Part2 extends TextProgram {
    /** Console program that ask user number and if it's even,
     * then take half or if it's odd, then number * 3 + 1,
     * until number wouldn't be 1
     */
    public void run(){
        //Catch error if user write not integer
        try {
            /* Ask user number and do operation bases on
             * its odd or even
             */
            askNumber();
        } catch (Exception e) {
            //Catch error and said why
            println("Not integer");
        }
    }

    private void askNumber() {
        // Ask user number
        int num = readInt("Enter a number: ");
        // Cycle will continue until number isn't 1
        while (num != 1) {
            // Variable that will contain initial num after operation
            int initialNum;
            // If num is even then take half of it or if odd make 3 * num + 1
            if (num % 2 == 0) {
                initialNum = num;
                num = num / 2;
                println(STR."\{initialNum} is even so I take half: \{num}");
            } else {
                initialNum = num;
                num = num * 3 + 1;
                println(STR."\{initialNum} is odd so I make 3n + 1: \{num}");
            }
        }
        // After all operation, when num = 1. Print message 'End'
        println("End");
    }
}
