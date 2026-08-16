package com.shpp.p2p.cs.vyukhnenko.assignment3;

import com.shpp.cs.a.console.TextProgram;

public class Assignment3Part3 extends TextProgram {
    /**
     * Console program that accepts two parameters
     * and calculate the value of the first parameter
     * raised to the power of the second parameter.
     */
    public void run() {
        raiseToPower(0.5, 3);
    }

    private double raiseToPower(double base, double exponent) {
        // Variable that contains base
        double res = base;

        // If exponent is 0, then res is 1
        if (exponent == 0) {
            res = 1;
        }

        /* If exponent is lower than 0, then multiply a number by itself,
         * quantity of operation depends on exponent and then 1 divide by terminal result
         */
        if (exponent < 0) {
            for (int i = -1; i > exponent; i--) {
                res = res * base;
            }
            res = 1 / res;
        }
        /* If exponent is bigger than 0, then multiply a number by itself,
         * quantity of operation depends on exponent
         */
        else {
            for (int i = 1; i < exponent; i++) {
                res = res * base;
            }
        }

        // Print result
        println(res);
        return res;
    }

}
