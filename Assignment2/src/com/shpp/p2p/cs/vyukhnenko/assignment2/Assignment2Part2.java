package com.shpp.p2p.cs.vyukhnenko.assignment2;

import java.awt.*;


public class Assignment2Part2 extends SuperClass {
    //Constant fot changing width of the window (x line)
    private static final int APPLICATION_WIDTH = 600;
    //Constant fot changing height of the window (y line)
    private static final int APPLICATION_HEIGHT = 600;

    /*Console program that create a white rectangle
     * that overlaps the four circles.
     */

    public void run() {
        // Put constants in void for its work, for changing window size
        setSize(APPLICATION_WIDTH, APPLICATION_HEIGHT);

        //Creating variable for diameter of Oval
        double diameter;

        /*Diameter depends on window screen, which line(x or y) is shorter
         * would be the third part of diameter.
         * It's need for search is normally sized despite window resizing
         */
        if (getWidth() > getHeight()) {
            diameter = (double) getHeight() / 3;
        } else {
            diameter = (double) getWidth() / 3;
        }

        // Variable radius that by formula is half of diameter
        double radius = diameter / 2;
        //Variables for placing oval in the corners of the window
        double y = getHeight() - diameter;
        double x = getWidth() - diameter;

        add(createCircle(0, 0, diameter, diameter, Color.BLACK));
        add(createCircle(0, y, diameter, diameter, Color.BLACK));
        add(createCircle(x, y, diameter, diameter, Color.BLACK));
        add(createCircle(x, 0, diameter, diameter, Color.BLACK));
        add(createRect(Color.WHITE, radius, radius,
                /* If we subtract the diameter of the circle from the entire area,
                 * then there will be room for only one diameter,
                 *  i.e. 2 radius of circles on each side of the window
                 */
                getWidth() - diameter,
                getHeight() - diameter));
    }
}