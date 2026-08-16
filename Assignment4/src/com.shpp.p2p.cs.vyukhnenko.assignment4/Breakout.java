package com.shpp.p2p.cs.vyukhnenko.assignment4;

import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.util.RandomGenerator;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

import java.awt.event.MouseEvent;

public class Breakout extends WindowProgram {
    /**
     * Width and height of application window in pixels
     */
    public static final int APPLICATION_WIDTH = 400;
    public static final int APPLICATION_HEIGHT = 600;

    /**
     * Dimensions of the paddle
     */
    private static final int PADDLE_WIDTH = 60;
    private static final int PADDLE_HEIGHT = 10;

    /**
     * Offset of the paddle up from the bottom
     */
    private static final int PADDLE_Y_OFFSET = 30;
    private static final int PADDLE_X = APPLICATION_WIDTH / 2 - PADDLE_WIDTH / 2;


    /**
     * Number of bricks per row
     */
    private static final int NBRICKS_PER_ROW = 10;

    /**
     * Number of rows of bricks
     */
    private static final int NBRICK_ROWS = 10;

    /**
     * Separation between bricks
     */
    private static final int BRICK_SEP = 4;

    /**
     * It's a bad idea to calculate brick width from APPLICATION_WIDTH
     */
    private static final int BRICK_WIDTH =
            (APPLICATION_WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

    /**
     * Height of a brick
     */
    private static final int BRICK_HEIGHT = 8;

    /**
     * Radius of the ball in pixels
     */
    private static final int BALL_RADIUS = 10;

    private static final int BALL_DIAMETER = BALL_RADIUS * 2;

    /**
     * Offset of the top brick row from the top
     */
    private static final int BRICK_Y_OFFSET = 70;

    /**
     * Number of turns
     */
    private static final int NTURNS = 3;
    /**
     * Pause
     */
    private static final int DELAY = 10;
    GRect paddle;
    GOval ball;
    //array which will consist bricks
    GRect[][] brick = new GRect[NBRICK_ROWS][NBRICKS_PER_ROW];

    //Coordinates for ball moving
    private double vx, vy;


    /**
     * The colored rectangles at the top of the screen are bricks,
     * and the black rectangle at the bottom is the paddle.
     * The paddle is fixed on the vertical axis but can move freely horizontally,
     * following the mouse pointer—back and forth—without leaving the screen boundaries.
     * At the start of each attempt, the ball is launched downwards from the center of the screen
     * at a random angle and must be deflected by the paddle.
     * The ball bounces off the screen edges and the paddle according to the laws of physics:
     * the angle of incidence equals the angle of reflection.
     */
    public void run() {

        //Set size of the window
        setSize(APPLICATION_WIDTH, APPLICATION_HEIGHT);
        //Creating brick wall
        createBricks();

        //Creating paddle and makes it move (depends on mouse move)
        createPaddle();

        //Creating ball and makes it move
        createBall();


    }

    private void createBricks() {
        //Length of one row of bricks
        double bricksLength = BRICK_WIDTH * NBRICKS_PER_ROW + (NBRICKS_PER_ROW - 1) * BRICK_SEP;
        //Coordinate X for row in the center of window
        double x = (getWidth() - bricksLength) / 2;
        //Coordinate Y for the first row
        double y = BRICK_Y_OFFSET;

        //Cycle which create bricks wall
        for (int row = 0; row < NBRICK_ROWS; row++) {
            Color brickColor;

            //Changing color for every two row
            if (row < 2) {
                brickColor = Color.RED;
            } else if (row < 4) {
                brickColor = Color.ORANGE;
            } else if (row < 6) {
                brickColor = Color.YELLOW;
            } else if (row < 8) {
                brickColor = Color.GREEN;
            } else {
                brickColor = Color.CYAN;
            }

            //Creating brick and put it in array
            for (int col = 0; col < NBRICKS_PER_ROW; col++) {
                brick[row][col] = createRect(x, y, BRICK_WIDTH, BRICK_HEIGHT, brickColor);

                //Move every next brick in x coordinate
                x += BRICK_WIDTH + BRICK_SEP;
            }
            //Move row to the next line and make x to central coordinate for row
            x = (getWidth() - bricksLength) / 2;
            y += BRICK_HEIGHT + BRICK_SEP;
        }
    }


    //Creating paddle that listens to the mouse
    private void createPaddle() {
        paddle = createRect(PADDLE_X, getHeight() - PADDLE_Y_OFFSET, PADDLE_WIDTH, PADDLE_HEIGHT, Color.BLACK);
        //method for mouse listener
        addMouseListeners();
    }

    /**
     * Repositions paddle to the mouse's location when the mouse
     * is moved.
     */
    @Override
    public void mouseMoved(MouseEvent e) {
        double paddleLeftEdge = getWidth() - (double) PADDLE_WIDTH / 2;
        double paddleRightEdge = (double) PADDLE_WIDTH / 2;
        /* If there is something to drag at all, go move it. */
        if (e.getX() < paddleLeftEdge && paddleRightEdge < e.getX()) {
            double newX = e.getX() - (double) PADDLE_WIDTH / 2;
            paddle.setLocation(newX, getHeight() - PADDLE_Y_OFFSET);
        }
    }

    //Creating ball and make it move
    private GOval createBall() {
        //Quantity of deleted by vall bricks
        int bricks_quantity = 0;
        //Quantity of games
        int counter = 0;
        //Quantity of tries after each game
        int triesQuantity = 2;
        GLabel tries = null;


        //Central coordinate for ball
        double x = (double) getWidth() / 2 - BALL_RADIUS;
        double y = (double) getHeight() / 2 - BALL_RADIUS;

        //Cycle runs while nit more the 3 games
        while (counter < NTURNS) {
            ball = new GOval(x, y, BALL_DIAMETER, BALL_DIAMETER);

            ball.setFilled(true);
            ball.setColor(Color.BLACK);
            add(ball);

            RandomGenerator rgen = RandomGenerator.getInstance();

            //Coordinate that change while ball move
            vx = rgen.nextDouble(1.0, 3.0);

            if (rgen.nextBoolean(0.5))
                vx = -vx;

            //Coordinate that change while ball move
            vy = 3;

            //Wait for click before starting the program
            waitForClick();

            //Remove label about quantity of tries
            if (tries != null) {
                remove(tries);
            }

            while (true) {
                //move ball
                ball.move(vx, vy);

                //Object that contains object which ball touches
                GObject collider = getCollidingObject();

                if (collider != null) {
                    // If collider is paddle< then change y coordinate, like push away from paddle
                    if (collider == paddle) {
                        vy = -Math.abs(vy);
                    }
                    //Cycle that looks every array index
                    for (int i = 0; i < NBRICK_ROWS; i++) {
                        for (int j = 0; j < NBRICKS_PER_ROW; j++) {
                            if (collider == brick[i][j]) {
                                /*If it's brick, then its brick,
                                 *then delete it and change coordinate
                                 */
                                if (vy < 0) {
                                    vy = Math.abs(vy);
                                } else {
                                    vy = -Math.abs(vy);
                                }
                                remove(brick[i][j]);
                                //Add qauntity od deleting bricks
                                bricks_quantity++;
                            }
                        }
                    }
                }

                //Push away from wall
                if (ball.getX() <= 0 || ball.getX() + ball.getWidth() >= getWidth()) {
                    vx = -vx;
                }

                //Push away from top
                if (ball.getY() <= 0) {
                    vy = -vy;
                }

                //If its bottom you left 1 try
                if (ball.getY() + ball.getHeight() >= getHeight()) {
                    remove(ball);
                    counter++;
                    break;
                }

                //If you delete every brick - you win
                if (bricks_quantity == NBRICK_ROWS * NBRICKS_PER_ROW) {
                    removeAll();
                    GLabel win = makeLabel("You win", Color.GREEN);
                    break;
                }

                pause(DELAY);


            }
            //If you try low then 3, then program show your num of tries or stop program
            if (bricks_quantity < NBRICK_ROWS * NBRICKS_PER_ROW && counter < NTURNS) {
                tries = makeLabel("You have left " + (triesQuantity) + (triesQuantity > 1 ? "tries" : "try"), Color.BLACK);
                triesQuantity--;
            } else {
                break;
            }

        }

        //If there aren't any tries - you lose
        if (bricks_quantity < NBRICK_ROWS * NBRICKS_PER_ROW) {
            GLabel lose = makeLabel("You lose", Color.RED);
        }
        return null;
    }

    //Method that creates label
    private GLabel makeLabel(String labelText, Color color) {
        GLabel label = new GLabel(labelText);
        label.setLocation(((double) getWidth() / 2) - (label.getWidth() / 2), ((double) getHeight() / 2) - ball.getHeight() * 2);
        label.setColor(color);

        add(label);
        return label;
    }

    //Method that found object which ball touches by its y and x
    private GObject getCollidingObject() {
        double x = ball.getX();
        double y = ball.getY();

        //Looking for every edge of ball which its can touch object and get its coordinate
        if (getElementAt(x, y) != null) {
            return getElementAt(x, y);
        } else if (getElementAt(x + BALL_DIAMETER, y) != null) {
            return getElementAt(x + BALL_DIAMETER, y);
        } else if (getElementAt(x, y + BALL_DIAMETER) != null) {
            return getElementAt(x, y + BALL_DIAMETER);
        } else if (getElementAt(x + BALL_DIAMETER, y + BALL_DIAMETER) != null) {
            return getElementAt(x + BALL_DIAMETER, y + BALL_DIAMETER);
        }

        //If nothing found then return 0
        return null;
    }


    //Method that creates rectangle
    private GRect createRect(double x, double y, int width, int height, Color color) {
        GRect rectangle = new GRect(x, y, width, height);
        rectangle.setFilled(true);
        rectangle.setColor(color);

        add(rectangle);
        return rectangle;
    }
}
