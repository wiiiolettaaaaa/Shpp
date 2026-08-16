package com.shpp.p2p.cs.vyukhnenko.assignment1;

import com.shpp.karel.KarelTheRobot;

public class SuperCarol extends KarelTheRobot {
    //This method allows Karol to turn Around
    void turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }
}
