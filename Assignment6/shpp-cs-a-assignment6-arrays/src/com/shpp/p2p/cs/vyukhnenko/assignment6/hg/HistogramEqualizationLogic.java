package com.shpp.p2p.cs.vyukhnenko.assignment6.hg;

public class HistogramEqualizationLogic {
    private static final int MAX_LUMINANCE = 255;

    /**
     * Given the luminances of the pixels in an image, returns a histogram of the frequencies of
     * those luminances.
     * <p/>
     * You can assume that pixel luminances range from 0 to MAX_LUMINANCE, inclusive.
     *
     * @param luminances The luminances in the picture.
     * @return A histogram of those luminances.
     */
    public static int[] histogramFor(int[][] luminances) {
        int height = luminances.length;
        int length = luminances[0].length;
        int[] histogramOfLuminaces = new int[MAX_LUMINANCE+1];

        //Iterate elements of array liminances and
        //record the number of pixels with the current brightness
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                int luminancesValue = luminances[i][j];
                histogramOfLuminaces[luminancesValue]++;
            }
        }

        return histogramOfLuminaces;
    }

    /**
     * Given a histogram of the luminances in an image, returns an array of the cumulative
     * frequencies of that image.  Each entry of this array should be equal to the sum of all
     * the array entries up to and including its index in the input histogram array.
     * <p/>
     * For example, given the array [1, 2, 3, 4, 5], the result should be [1, 3, 6, 10, 15].
     *
     * @param histogram The input histogram.
     * @return The cumulative frequency array.
     */
    public static int[] cumulativeSumFor(int[] histogram) {
        int arrayLength = histogram.length;
        int[] cumulativeFrequencies = new int[arrayLength];

        //Write the sum of the preceding elements into each cell of the array.
        for (int i = 0; i < arrayLength; i++) {
            int sum = 0;

            for (int j = 0; j <= i; j++) {
                sum += histogram[j];
            }
            cumulativeFrequencies[i] = sum;
        }

        return cumulativeFrequencies;
    }


    /**
     * Returns the total number of pixels in the given image.
     *
     * @param luminances A matrix of the luminances within an image.
     * @return The total number of pixels in that image.
     */
    public static int totalPixelsIn(int[][] luminances) {
        if (luminances.length == 0 || luminances[0].length == 0) {
            return 0;
        }

        return luminances.length * luminances[0].length;
    }

    /**
     * Applies the histogram equalization algorithm to the given image, represented by a matrix
     * of its luminances.
     * <p/>
     * You are strongly encouraged to use the three methods you have implemented above in order to
     * implement this method.
     *
     * @param luminances The luminances of the input image.
     * @return The luminances of the image formed by applying histogram equalization.
     */
    public static int[][] equalize(int[][] luminances) {
        int height = luminances.length;
        int length = luminances[0].length;
        //Array of luminances of the image formed by applying histogram equalization
        int[][] newLuminances = new int[height][length];

        int[] histogramOfImage = histogramFor(luminances);
        int[] cumulativeHistogram = cumulativeSumFor(histogramOfImage);
        long totalPixels = (long) totalPixelsIn(luminances);

        //Replace each brightness value in the original image using the formula
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                //Index of cumulative histogram from luminances of the input image
                int indexOfCH = luminances[i][j];
                double fractionSmaller = (double) cumulativeHistogram[indexOfCH] / totalPixels;
                int currentLuminance = (int) (MAX_LUMINANCE * fractionSmaller);

                newLuminances[i][j] = currentLuminance;
            }
        }

        return newLuminances;
    }
}
