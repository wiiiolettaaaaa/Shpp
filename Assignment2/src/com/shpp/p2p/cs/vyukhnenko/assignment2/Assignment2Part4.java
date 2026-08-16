package com.shpp.p2p.cs.vyukhnenko.assignment2;

import acm.graphics.*;

import java.awt.*;

public class Assignment2Part4 extends SuperClass {
    //Constant fot changing width of the flag (x line)
    private static final double WIDTH = 400;
    //Constant fot changing height of the flag (y line)
    private static final double HEIGHT = 200;

    //A program that draws a tricolor flag
    public void run() {
        //Method that draw tricolor flag
        drawFlag();
        //Method that draw name of the flag
        drawNameOfFlag();
    }

    private void drawNameOfFlag() {
        //Creating label
        GLabel nameOfFlag = new GLabel("Flag of Hungary");

        /*Variables that contains coordinates
         *name of flag
         */
        double flagLocationX = getWidth() - nameOfFlag.getWidth();
        double flagLocationY = getHeight() - nameOfFlag.getHeight();

        // Turn name of flag to black color
        nameOfFlag.setColor(Color.BLACK);


        //Set location of name of flag and draw it
        nameOfFlag.setLocation(flagLocationX, flagLocationY);
        add(nameOfFlag);

    }

    private void drawFlag() {
        //Variables that contains width and height of one line of flag
        double oneLineWidth = WIDTH;
        double oneLineHeight = HEIGHT * ((double) 1 / 3);
        //Variables that contains central coordinates of flag
        double flagLocationX = ((double) getWidth() / 2) - oneLineWidth / 2;
        double flagLocationY = ((double) getHeight() / 2) - HEIGHT / 2;

        //Creating storage space for all parts of flag
        GCompound flag = new GCompound();

        //Create 3 lines of flag
        GRect firstRow = createRect(Color.RED, 0, 0, oneLineWidth, oneLineHeight);
        GRect secondRow = createRect(Color.WHITE, 0, oneLineHeight, oneLineWidth, oneLineHeight);
        GRect thirdRow = createRect(Color.GREEN, 0, 2 * oneLineHeight, oneLineWidth, oneLineHeight);

        //Add lines of flag to the storage space
        flag.add(firstRow);
        flag.add(secondRow);
        flag.add(thirdRow);

        //Set location of storage space
        flag.setLocation(flagLocationX, flagLocationY);

        //Draw flag(storage space)
        add(flag);
    }
}