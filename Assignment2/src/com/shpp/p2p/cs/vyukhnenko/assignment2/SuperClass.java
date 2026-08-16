package com.shpp.p2p.cs.vyukhnenko.assignment2;

import acm.graphics.*;

import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

public class SuperClass extends WindowProgram {
    public GOval createCircle(double x, double y, double width, double height, Color color) {
        GOval oval = new GOval(x, y, width, height);
        fillFigure(oval, color);

        return oval;
    }


    public GRect createRect(Color color, double x, double y, double width, double height) {
        GRect rect = new GRect(x, y, width, height);
        fillFigure(rect, color);
        rect.setColor(color);

        return rect;
    }

    private void fillFigure(GFillable obj, Color color) {
        obj.setFilled(true);
        obj.setFillColor(color);
    }
}
