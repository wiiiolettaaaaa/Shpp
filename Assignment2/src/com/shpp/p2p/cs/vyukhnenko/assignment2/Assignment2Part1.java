package com.shpp.p2p.cs.vyukhnenko.assignment2;

import com.shpp.cs.a.console.TextProgram;

public class Assignment2Part1 extends TextProgram {
    /* Console program that accepts three numbers of type double (a, b, c)
     * as input and outputs the roots of the quadratic equation.
     */
    public void run() {
        // Ask user enter numbers that makes equation a*(x^2) + b*x + c = 0
        double a = readDouble("Please enter a: ");
        double b = readDouble("Please enter b: ");
        double c = readDouble("Please enter c: ");

        //Finding discriminant
        double discriminant = (b * b) - (4 * a * c);

        /* If a=0 and b!= 0, then quadratic equation changes to linen one
         * This method calculates this case
         */
        linenEquation(a, b, c);

        /* This method finds roots if discriminant
         * bigger than 0. There would be 2 roots
         */
        discriminantBiggerZero(b, discriminant, a);

        /* This method finds root if discriminant is 0
         * There would be 1 root.
         */
        discriminantZero(b, a, discriminant);

        /* This method finds root if discriminant less than 0
         * There would be no roots.
         */
        discriminantLessZero(discriminant);

    }

    private void discriminantLessZero(double discriminant) {
        // Here we check if discriminant < 0, then program print there aren't any roots
        if (discriminant < 0) {
            println("There are no real roots");
        }
    }

    private void discriminantZero(double b, double a, double discriminant) {
        // Here we check if discriminant = 0, then program print one root
        if (discriminant == 0) {
            // Create variable and put there formula for finding the root of an equation
            double x = -b / (2 * a);
            println(STR."There is one root: \{x}");
        }
    }

    private void discriminantBiggerZero(double b, double discriminant, double a) {
        /* Here we check if discriminant > 0 and a not equivalent 0
         * (if it is, it would be linen equation),
         *  then program print two roots
         */
        if (discriminant > 0 && a != 0) {
            // Create variables and put there formula for finding the roots of an equation
            double x1 = (-b + Math.sqrt(discriminant)) / 2 * a;
            double x2 = (-b - Math.sqrt(discriminant)) / 2 * a;
            println(STR."There is two roots: \{x1} and \{x2}");
        }
    }

    private void linenEquation(double a, double b, double c) {
        // If a = 0 and b != 0, then it's linen equation and program find root for x
        if (a == 0 && b != 0) {
            // Create variable and put there formula for finding the root of an equation
            double x = -(c / b);
            println("Number 'a' was ZERO, now its linen equation. x = " + x);

        }
    }
}
