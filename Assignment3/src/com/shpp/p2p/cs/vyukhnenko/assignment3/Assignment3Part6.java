package com.shpp.p2p.cs.vyukhnenko.assignment3;

import acm.graphics.*;

import acm.util.RandomGenerator;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

public class Assignment3Part6 extends WindowProgram {

    //Constant that contains sun diameter
    private static final int SUN_DIAMETER = 70;
    //Constant that contains 1/3 part of cloud's top
    private static final int TOP_CLOUD = 30;
    //Constant that contains quantity of clouds
    private static final int CLOUDS_QUANTITY = 15;

    // Constant that contains duration of animation (5s)
    private static final long ANIMATION_DURATION = 5000;
    //Constant that contains FPS
    private static final int TARGET_FPS = 30;
    //Constant that contains delay
    private static final int DELAY = 1000 / TARGET_FPS;
    // Objects which appear in animation
    private GRect sky;
    private GOval sun;
    private GCompound clouds;
    private GRect ground;


    /**
     * Animation where the sky and ground became darker
     * while clouds wave on the screen
     */
    public void run() {
        createAnimation();
    }

    private void createAnimation() {
        // Create sky
        sky = createRect(0, 0, getWidth(), getHeight(), Color.CYAN);

        //Create sun
        sun = createOval(((double) getWidth() / 2) - ((double) SUN_DIAMETER / 2),
                ((double) getHeight() / 4) - ((double) SUN_DIAMETER / 2),
                SUN_DIAMETER, SUN_DIAMETER, Color.YELLOW);


        //Create storage which contains clouds
        clouds = new GCompound();
        add(clouds);
        drawClouds();

        // Create ground
        ground = createRect(0, (double) (getHeight() * 5) / 6, getWidth(), (double) (getHeight() * 5) / 6, Color.GREEN);

        // Method which contains animation
        animation();
    }


    private void animation() {
        // Time before first cycle of animation
        long startTime = System.currentTimeMillis();
        // Current time of animation
        long elapsedTime = 0;

        while (elapsedTime < ANIMATION_DURATION) {

            // Coefficient of animation duration
            double progress = (double) elapsedTime / ANIMATION_DURATION;

            /* Clouds animation */
            // Initial coordinate X of clouds
            double StartX = -getWidth();
            // Final coordinate X of clouds
            double EndX = -10;
            // Current coordinate X of clouds
            double CurrentX = EndX + (EndX - StartX) * progress;
            clouds.setLocation(CurrentX, getY());

            /* Sun animation */
            //Create rgb for sun which will change during cycles and depends on coef
            int rSun = (int) (Color.YELLOW.getRed() * (1 - progress)) + (int) (45 * progress);
            int gSun = (int) (Color.YELLOW.getGreen() * (1 - progress)) + (int) (45 * progress);
            int bSun = (int) (Color.YELLOW.getBlue() * (1 - progress)) + (int) (45 * progress);
            // Create new color
            Color cloudySun = new Color(rSun, gSun, bSun);
            sun.setFillColor(cloudySun);
            sun.setColor(cloudySun);


            // Sky animation
            //Create rgb for sky which will change during cycles and depends on coef
            int rSky = (int) (Color.CYAN.getRed() * (1 - progress));
            int gSky = (int) (Color.CYAN.getGreen() * (1 - progress));
            int bSky = (int) (Color.CYAN.getBlue() * (1 - progress)) + (int) (80 * progress);
            // Create new color
            Color cloudySky = new Color(rSky, gSky, bSky);
            sky.setFillColor(cloudySky);
            sky.setColor(cloudySky);

            //Ground animation
            //Create rgb for ground which will change during cycles and depends on coef
            int rGround = (int) (Color.GREEN.getRed() * (1 - progress));
            int gGround = (int) (Color.GREEN.getGreen() * (1 - progress)) + (int) (80 * progress);
            int bGround = (int) (Color.GREEN.getBlue() * (1 - progress));
            // Create new color
            Color cloudyGround = new Color(rGround, gGround, bGround);
            ground.setFillColor(cloudyGround);
            ground.setColor(cloudyGround);


            pause(DELAY);

            //Change current time of animation
            elapsedTime = System.currentTimeMillis() - startTime;
        }

        println(elapsedTime);

    }

    //Method that create space storage with clouds in random place
    private void drawClouds() {
        // Cycle which create quantity of clouds using constant
        for (int i = 0; i < CLOUDS_QUANTITY; i++) {
            RandomGenerator rgen = RandomGenerator.getInstance();
            //Coordinates in left from the screen for storage space
            double x = rgen.nextDouble(-getWidth(), 0);
            double y = rgen.nextDouble(0, (double) (getHeight() * 2) / 3);

            //Put clouds in storage space
            GCompound cloud = createCloud(x, y);
            clouds.add(cloud);
        }
    }

    // Storage space which contain one cloud
    private GCompound createCloud(double x, double y) {
        // Creating storage space
        GCompound cloud = new GCompound();

        //Coordinate x and y for top of cloud
        double partsX = 0;
        double partsY = 0;

        //Cycle which create top of the cloud which contains 3 circle parts
        for (int i = 0; i < 3; i++) {

            //If i is even then y coordinate will be in low position and if odd then in high position
            partsY = (i % 2 == 0) ? (double) TOP_CLOUD / 2 : 0;

            //Create part of clouds top
            GOval topCloud = createOval(partsX, partsY, TOP_CLOUD, TOP_CLOUD, Color.WHITE);
            cloud.add(topCloud);
            //Move next part on x coordinate
            partsX += (double) TOP_CLOUD / 2 + 10;
        }

        // Create bottom of the cloud
        GOval bottomCloud = createOval(0, 20, TOP_CLOUD * 2 + TOP_CLOUD / 1.5, TOP_CLOUD, Color.WHITE);
        cloud.add(bottomCloud);

        cloud.setLocation(x, y);
        return cloud;
    }

    //Support method for creating rectangle and set its color
    private GRect createRect(double x, double y, double width, double height, Color color) {
        GRect rect = new GRect(x, y, width, height);
        rect.setFilled(true);
        rect.setColor(color);

        add(rect);

        return rect;
    }

    //Support method for creating oval and set its color
    private GOval createOval(double x, double y, double width, double height, Color color) {
        GOval oval = new GOval(x, y, width, height);
        oval.setFilled(true);
        oval.setColor(color);

        add(oval);

        return oval;
    }
}

