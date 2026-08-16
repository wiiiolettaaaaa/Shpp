package com.shpp.p2p.cs.vyukhnenko.assignment2;

import acm.graphics.GOval;

import java.awt.*;

public class Assignment2Part6 extends SuperClass {
    //Constant that contains size of one oval of caterpillar
    private static final int OVAL_SIZE = 90;
    //Constants that contains quantity of caterpillar ovals
    private static final int QUANTITY = 6;

    public void run() {
        //Method that draws caterpillar
        drawCaterpillar();
    }

    private void drawCaterpillar() {
        //boolean with position of oval
        boolean highPozition = false;
        //Initial coordinates for oval
        double x = 0;
        double y = 0;

        //Cycle that create quantity of ovals which contains in constant QUANTITY
        for (int i = 0; i < QUANTITY; i++) {
            //If highPozition is true, then draw oval in y = 0
            if (highPozition) {
                y = 0;
                //Create oval of Caterpillar with using right size,color and coordinates
                GOval partOfCaterpillar = createCircle(x, y, OVAL_SIZE, OVAL_SIZE, Color.CYAN);
                partOfCaterpillar.setColor(Color.GREEN);
                //Draw oval
                add(partOfCaterpillar);
                //Change boolean false, to create next in lower position
                highPozition = false;
            } else {
                //Change coordinate y to lower position
                y += (double) OVAL_SIZE / 2;
                //Create oval of Caterpillar with using right size,color and coordinates
                GOval partOfCaterpillar = createCircle(x, y, OVAL_SIZE, OVAL_SIZE, Color.CYAN);
                partOfCaterpillar.setColor(Color.GREEN);
                //Draw oval
                add(partOfCaterpillar);
                //Change boolean true, to create next in high position
                highPozition = true;
            }
            //Change coordinate x for next oval (move right)
            x += ((double) OVAL_SIZE / 2) + ((double) OVAL_SIZE / 8);
        }
    }
}
