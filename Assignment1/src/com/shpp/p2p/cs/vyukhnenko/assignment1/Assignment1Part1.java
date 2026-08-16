package com.shpp.p2p.cs.vyukhnenko.assignment1;

public class Assignment1Part1 extends SuperCarol {
    //Its method allows Karol move to the magazine bypass the obstacles then pick it up and go back bypass the obstacles to the start point
    public void run() throws Exception {
        goToMagazine();
        takeMagazine();
        comeToTheBeginning();
    }

    //this method allows Karel to go to the magazine bypass the obstacles
    private void goToMagazine() throws Exception {
        moveUntilWall();
        turnRight();
        move();
        turnLeft();
        move();
        move();

    }

    //this method allows Karol to pick up Magazine
    private void takeMagazine() throws Exception {
        pickBeeper();
    }

    //Karol can go to the start bypass the obstacles
    private void comeToTheBeginning() throws Exception {
        turnAround();
        moveUntilWall();
        turnRight();
        move();
    }

    //This method allows Karol to turn right
    private void turnRight() throws Exception {
        for (int i = 0; i < 3; i++) {
            turnLeft();
        }
    }

    //This method allows Karol until wall
    private void moveUntilWall() throws Exception {
        while (frontIsClear()) {
            move();
        }
    }
}
