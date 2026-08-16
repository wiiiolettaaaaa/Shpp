package com.shpp.p2p.cs.vyukhnenko.assignment1;

public class Assignment1Part2 extends SuperCarol {
    public void run() throws Exception{
        FillRow();
        while(frontIsClear()){
            MoveNext();
            FillRow();
        }


    }

    private void MoveNext() throws Exception {

        for(int i = 0; i < 4; i++){
            move();
        }
    }

    private void FillRow() throws Exception {
        turnLeft();
        while(frontIsClear()){
            if(beepersPresent()){
                move();
            }else{
                putBeeper();
                move();
            }
            if(noBeepersPresent()){
                putBeeper();
            }
        }
        turnAround();
        while(frontIsClear()){
            move();
        }
        turnLeft();
    }


//    //This method allows Karel fill Poles in the buildings, and it's not depend on size of it
//    public void run() throws Exception {
//        //fill first line
//        fillPoles();
//        //if there is next lines fill them too
//        while (leftIsClear()) {
//            turnLeft();
//            move();
//            fillPoles();
//        }
//
//    }
//
//    //This method fill holes in the pillar of the Building
//    private void fillPoles() throws Exception {
//        turnLeft();
//        findPoleAndFill();
//    }
//
//    //This method find hole in the pillar and fill it
//    private void findPoleAndFill() throws Exception {
//        //go straight and fill the top od pillar
//        findPoleAndFillHalf();
//        turnAround();
//        //go back and fill those holes that remains
//        findPoleAndFillHalf();
//
//    }
//
//    //This method look in such line, if it found part of pillar then it goes straight and fill holes if it present
//    private void findPoleAndFillHalf() throws Exception {
//        while (frontIsClear()) {
//            move();
//            // if in such line present beeper,then we understand that it is the pillar and we put beepers in holes
//            if (beepersPresent()) {
//                putBeepers();
//
//            }
//        }
//    }
//
//    //This method put Beepers if it isn't present
//    private void putBeepers() throws Exception {
//        while (frontIsClear()) {
//            move();
//            if (noBeepersPresent()) {
//                putBeeper();
//            }
//        }
//    }

}
