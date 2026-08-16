package com.shpp.p2p.cs.vyukhnenko.assignment1;

public class Assignment1Part3 extends SuperCarol {
    //this method put beeper in the central cell
    public void run() throws Exception {
        putBeepers();
        takeFromEnds();

    }

    //we fill whole line by beepers
    private void putBeepers() throws Exception {

        putBeeper();
        while (frontIsClear()) {
            move();
            putBeeper();
        }

    }


    //we take beeper from ends of beepers line and leave only one in central cell
    private void takeFromEnds() throws Exception {
        //After filling line by beepers, Karol looks in wall and he need to turn around to continue his task
        //Karol turn around here
        turnAround();
        //if beeper present in  current we move to another cell and find beeper in another cell to check for beeper
        //if there aren't any beepers in next cell then beeper in central cell
        //and if there are beepers we start picking up beepers from edges
        while (beepersPresent() && frontIsClear()) {
            move();
            //we moved from present cell if there is beeper and front is clear
            //if in this cell beeper present we moved back and take beeper from previous cell
            //so we pick up beeper from edge
            if (beepersPresent()) {
                turnAround();
                move();
                pickBeeper();
                turnAround();
                moveToAnotherEnd();
            }

        }
    }

    //Karel move to the end,then turn around and come to beeper in another edge og beepers line
    //so he can start looking for beepers from another end
    private void moveToAnotherEnd() throws Exception {
        while (frontIsClear()) {
            move();
        }
        //if front is blocked he turns to the clear one
        turnAround();
        //here Karel found the beggining of another edge of beeper line
        while (frontIsClear() && noBeepersPresent()) {
            move();
        }
    }

}
