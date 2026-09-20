package com.shpp.p2p.cs.vyukhnenko.assignment6.sg;

import acm.graphics.*;

public class SteganographyLogic {
    /**
     * Given a GImage containing a hidden message, finds the hidden message
     * contained within it and returns a boolean array containing that message.
     * <p/>
     * A message has been hidden in the input image as follows.  For each pixel
     * in the image, if that pixel has a red component that is an even number,
     * the message value at that pixel is false.  If the red component is an odd
     * number, the message value at that pixel is true.
     *
     * @param source The image containing the hidden message.
     * @return The hidden message, expressed as a boolean array.
     */
    public static boolean[][] findMessage(GImage source) {
        int[][] image = source.getPixelArray();

        int length = image.length;
        int height = image[0].length;

        boolean[][] message = new boolean[length][height];

        //Checks whether the value is even or odd
        //and write it to a new array: if it is even,
        //we record "false" (representing white), and vice versa for black.
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
                int currentPixel = image[i][j];

                int r = GImage.getRed(currentPixel);

                if (r % 2 == 0) {
                    message[i][j] = false;
                } else {
                    message[i][j] = true;
                }
            }
        }

        return message;
    }

    /**
     * Hides the given message inside the specified image.
     * <p/>
     * The image will be given to you as a GImage of some size, and the message will
     * be specified as a boolean array of pixels, where each white pixel is denoted
     * false and each black pixel is denoted true.
     * <p/>
     * The message should be hidden in the image by adjusting the red channel of all
     * the pixels in the original image.  For each pixel in the original image, you
     * should make the red channel an even number if the message color is white at
     * that position, and odd otherwise.
     * <p/>
     * You can assume that the dimensions of the message and the image are the same.
     * <p/>
     *
     * @param message The message to hide.
     * @param source  The source image.
     * @return A GImage whose pixels have the message hidden within it.
     */
    public static GImage hideMessage(boolean[][] message, GImage source) {
        int[][] image = source.getPixelArray();

        int length = image.length;
        int height = image[0].length;

        //Iterate through each cell of the array and retrieve the RGB value.
        //If the current value is "false," we make the R component even, and vice versa.
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
                int currentPixel = image[i][j];

                int r = GImage.getRed(currentPixel);
                int g = GImage.getGreen(currentPixel);
                int b = GImage.getBlue(currentPixel);

                if (!message[i][j]) {
                    if (r % 2 != 0) {
                        r--;
                    }
                } else {
                    if (r % 2 == 0) {
                        r++;
                    }
                }
                //Write the RGB values into a new array.
                image[i][j] = GImage.createRGBPixel(r, g, b);
            }
        }

        source = new GImage(image);
        return source;
    }
}
