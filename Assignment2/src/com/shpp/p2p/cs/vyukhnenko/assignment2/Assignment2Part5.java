package com.shpp.p2p.cs.vyukhnenko.assignment2;

import acm.graphics.GCompound;
import acm.graphics.GRect;

import java.awt.*;

public class Assignment2Part5 extends SuperClass {
    /* The number of rows and columns in the grid, respectively. */
    private static final int NUM_ROWS = 5;
    private static final int NUM_COLS = 6;

    /* The width and height of each box. */
    private static final double BOX_SIZE = 40;

    /* The horizontal and vertical spacing between the boxes. */
    private static final double BOX_SPACING = 10;

    public void run() {
        /* A method that creates a matrix of black boxes separated by "streets",
         * centered in the middle of the window.
         */
        drawMatrixOfBoxes();
    }

    private void drawMatrixOfBoxes() {
        //Initial coordinates for the first box
        double y = 0;
        double x;

        //Creating storage space for boxes
        GCompound illusion = new GCompound();

        //Draw boxes in row 5 times
        for (int i = 0; i < NUM_ROWS; i++) {
            //Changing every step y coordinate
            x = 0;
            y += 50;

            // draw columns of 6 boxes
            for (int j = 0; j < NUM_COLS; j++) {
                //Create box and add it to storage space
                GRect box = createRect(Color.BLACK, x, y, BOX_SIZE, BOX_SIZE);
                illusion.add(box);

                // add to coordinate x box spacing size after every box except last
                if (j < NUM_COLS - 1) {
                    x += BOX_SIZE + BOX_SPACING;
                }
            }
        }

        // Create variables for central coordinates
        double centerForIllusionX = ((getWidth() - illusion.getWidth()) / 2);
        double centerForIllusionY = ((((double) getHeight() / 2) - (illusion.getHeight() / 2)) / 2);

        //Set location of illusion (storage space)
        illusion.setLocation(centerForIllusionX, centerForIllusionY);

        //Draw illusion
        add(illusion);

    }
}
