package com.shpp.p2p.cs.vyukhnenko.assignment3;

import acm.graphics.GCompound;
import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

public class Assignment3Part4 extends WindowProgram {
    // Constant that contains brick height
    private static final int BRICK_HEIGHT = 20;
    // Constant that contains brick width
    private static final int BRICK_WIDTH = 40;
    // Constant that contains quantity of bricks in pyramid
    private static final int BRICKS_IN_BASE = 9;

    /**
     * Program which make pyramid, which centered on horizontal line
     * and lay on the bottom of the window
     */
    public void run() {
        createPyramid();
    }

    private void createPyramid() {
        // Cycle which make bricks until quantity of bricks in constant
        for (int i = 0; i < BRICKS_IN_BASE; i++) {
            // Container with bricks in row
            GCompound row = new GCompound();

            // Variables that contains coordinates for brick
            double x = 0;
            double y = 0;

            // Variable that contains quantity if bricks in row (every step minus 1)
            int bricksInRow = BRICKS_IN_BASE - i;

            // Cycle which create bricks depends on quantity of variable bricksInRow
            for (int j = 0; j < bricksInRow; j++) {
                // Create one brick
                GRect brick = createRect(x, y, BRICK_WIDTH, BRICK_HEIGHT, Color.RED, Color.YELLOW);
                row.add(brick);
                //Next x coordinate will be through one brick
                x += BRICK_WIDTH;
            }

            // Coordinate X in the center of the window
            double rowX = (double) getWidth() / 2 - row.getWidth() / 2;
            // Coordinate y on the bottom of the window. Every step through one brick
            double rowY = getHeight() - BRICK_HEIGHT * (i + 1);

            //set location for row
            row.setLocation(rowX, rowY);
            add(row);
        }
    }

    // Support process for creating rectangle
    public GRect createRect(double x, double y, double width, double height, Color color, Color fillColor) {
        GRect rect = new GRect(x, y, width, height);
        rect.setFilled(true);
        rect.setFillColor(fillColor);
        rect.setColor(color);

        return rect;
    }

}
