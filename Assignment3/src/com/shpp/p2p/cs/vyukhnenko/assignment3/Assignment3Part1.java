package com.shpp.p2p.cs.vyukhnenko.assignment3;

import com.shpp.cs.a.console.TextProgram;

public class Assignment3Part1 extends TextProgram {
    /** Console program that asks user about quantity of minutes for training
     * per day and answer with how many days you need to train for
     * better health or said good luck
     */
    public void run() {
        catchErrorAndAskAboutAerobics();
    }

    //Catch error if user write not integer
    private void catchErrorAndAskAboutAerobics() {
        try{
            /* Ask user number if minutes user train per day
             * and give recommendations
             */
            askQuantity();
        }catch(Exception e){
            //Catch error and said why
            println("Not Integer");
        }
    }

    private void askQuantity() {
        // Variable that will contain quantity of days with cardiovascular health aerobics exercises per week
        int quontityCh = 0;
        // Variable that will contain quantity of days with blood pressure aerobics exercises per week
        int quontityBp = 0;

        //Cycle that asks 7 times about number of minutes of aerobics
        for (int i = 1; i < 8; i++) {
            int askTime = readInt(STR."How many minutes did you do on day \{i} ? ");
                // If more than 30 minutes then + 1 day of cardiovascular health aerobics exercises
                if (askTime >= 30) {
                    quontityCh += 1;
                }
                // If more than 40 minutes then + 1 day of blood pressure aerobics exercises
                if (askTime >= 40) {
                    quontityBp += 1;
                }
        }

        // Method that answer user about activity bases on quantity of days with aerobics
        answerUser(quontityCh, quontityBp);
    }

    private void answerUser(int quantityCh, int quantityBp) {
        /* Variable that contain quantity of days with cardiovascular health
         * aerobics exercises per week which user haven't done
         */
        int needToDoCh = 5 - quantityCh;
        /* Variable that contain quantity of days with blood pressure
         * aerobics exercises per week which user haven't done
         */
        int needToDoBp = 3 - quantityBp;

        /* Answer user bases on CARDIOVASCULAR HEALTH variables.
         * On one hand if it enough then good luck,
         * on the other if not enough number of days
         * that user have to do extra exercises
         */
        if (quantityCh >= 5) {
            println("Cardiovascular health:\n" +
                    "  Great job! You've done enough exercise for cardiovascular health.");

        } else {
            println(STR."Cardiovascular health:\n  You needed to train hard for at least \{needToDoCh} more day(s) a week!");
        }

        /* Answer user bases on BLOOD PRESSURE variable.
         * On one hand if it enough then good luck,
         * on the other if not enough number of days
         * that user have to do extra exercises
         */
        if (quantityBp >= 3) {
            println("Blood pressure:\n" +
                    "  Great job! You've done enough exercise to keep a low blood pressure.");

        } else {
            println(STR."Blood pressure:\n  You needed to train hard for at least \{needToDoBp} more day(s) a week!");
        }
    }
}
