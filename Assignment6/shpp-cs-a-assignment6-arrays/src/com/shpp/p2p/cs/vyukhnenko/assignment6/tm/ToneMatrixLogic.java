package com.shpp.p2p.cs.vyukhnenko.assignment6.tm;

public class ToneMatrixLogic {
    /**
     * Given the contents of the tone matrix, returns a string of notes that should be played
     * to represent that matrix.
     *
     * @param toneMatrix The contents of the tone matrix.
     * @param column     The column number that is currently being played.
     * @param samples    The sound samples associated with each row.
     * @return A sound sample corresponding to all notes currently being played.
     */
    public static double[] matrixToMusic(boolean[][] toneMatrix, int column, double[][] samples) {
        double[] result = new double[ToneMatrixConstants.sampleSize()];

        //Determine which cells are included in the current column and
        //combine all sounds
        for (int row = 0; row < toneMatrix.length; row++) {
            if (toneMatrix[row][column]) {
                for (int i = 0; i < samples.length; i++)
                    result[i] += samples[i][column];
            }
        }

        //Find the biggest value of result array
        double maxVal = 0;
        for (double val : result) {
            if (Math.abs(val) > Math.abs(maxVal)) {
                maxVal = val;
            }
        }

        //Normalize the sound wave to the range [-1.0; 1.0]
        if (Math.abs(maxVal) > 1) {
            for (int i = 0; i < result.length; i++) {
                result[i] /= maxVal;
            }
        }

        return result;
    }
}
