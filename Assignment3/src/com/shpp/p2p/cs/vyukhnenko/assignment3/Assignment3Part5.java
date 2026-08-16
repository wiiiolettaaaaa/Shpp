package com.shpp.p2p.cs.vyukhnenko.assignment3;

import acm.util.RandomGenerator;
import com.shpp.cs.a.console.TextProgram;

public class Assignment3Part5 extends TextProgram {
    /**
     * Console program where:
     * Two people are playing: the Lucky One and the Sweaty One.
     * The Lucky One leaves the casino once they have won $20 or more.
     * The Sweaty One places $1 on the table, and the Lucky One starts flipping a coin.
     * If it lands on heads, the Sweaty One adds an amount equal to what is already on the table to the pot.
     * If it lands on tails, everything on the table goes to the Lucky One.
     * If the Lucky One has less than $20 at the end, the game repeats.
     */
    public void run() {
        casinoBernoulli();
    }

    private void casinoBernoulli() {
        //Variable that contains quantity of earned money
        int suchGame = 1;
        //Variable for win
        int win = 0;
        // Variable that contains quantity of games
        int quontityOfGames = 0;


        //Cycle will go until win wouldn't be 20 and more
        while (win <= 20) {
            RandomGenerator rgen = RandomGenerator.getInstance();
            //Random number which means 0 is heads and 1 is tails
            int headsOrTails = rgen.nextInt(0, 1);

            //If 0, the Sweaty One adds an amount equal to what is already on the table to the pot.
            if (headsOrTails == 0) {
                win += suchGame;
                println(STR."This game, you earned $\{suchGame}\nYour total is $\{win}");
                quontityOfGames += 1;
            }
            //If 1, everything on the table goes to the Lucky One.
            if (headsOrTails == 1) {
                suchGame += suchGame;
            }

        }
        println(STR."It took \{quontityOfGames} games to earn $20");

    }


}
