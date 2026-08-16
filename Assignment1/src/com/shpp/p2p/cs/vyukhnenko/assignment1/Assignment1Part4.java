package com.shpp.p2p.cs.vyukhnenko.assignment1;


public class Assignment1Part4 extends SuperCarol {
    /*this method allows Karol to make “chessboard”
     * using a beeper in a rectangular empty world
     */
    public void run() throws Exception {
        //if the world have horizontal line we start from it
        while (frontIsClear()) {
            putBeeperToRow();
            moveNextAndStart();
        }
        //if the world is only one vertical line we need to turn left and fill it
        while (leftIsClear()) {
            turnLeft();
            putBeeperToRow();
        }
    }

    //Karol put beeper in checkerboard pattern in row that he appeared
    private void putBeeperToRow() throws Exception {
        //put beeper in first cell
        putBeeper();
        //if there are another cell move to it
        while (frontIsClear()) {
            move();
            /*if the world have 3+ horizontal cells,
             * he will put beeper to into the cell
             * one cell away from the previous one
             */
            if (frontIsClear()) {
                move();
                putBeeper();
            }
        }
    }

    /*
     * This method allows Karol to fill next row
     * when Karol fill the row,to start fell next row he have to face the west
     * and be in the first east cell
     */
    private void moveNextAndStart() throws Exception {
        //Karol come to east cell
        goToEast();

        //as Karol facing East the wall can be to his left and he verifies it
        if (leftIsClear()) {
            //if in such cell beeper present in next row we don't need to put it
            if (beepersPresent()) {
                //Karol moves to next row
                moveNextAndTurnAround();
                //he makes a step to skip a cell that does not need to be filled in
                if (frontIsClear()) {
                    move();
                }
            }
            //if in previous line end up without beeper, he fills first cell
            else {
                moveNextAndTurnAround();
            }
        }

    }

    //this method allows Karol move to the next row
    private void moveNextAndTurnAround() throws Exception {
        turnLeft();
        move();
        turnLeft();
    }

    //if our Karel facing West, he turns around and move to the east wall
    private void goToEast() throws Exception {
        if (facingWest()) {
            turnAround();
            while (frontIsClear()) {
                move();
            }
        }
    }
}
