package com.epam;

import java.util.Arrays;

public class MatrixIterator {

    private static byte[][] resultState;

    public static byte[][] iterateMatrix(byte[][] startState, int iterations) {

        resultState = deepCopy(startState);

        for (int i = 0; i < iterations; i++) {
            iterate(startState);
            startState = deepCopy(resultState);
        }

        return resultState;
    }

    private static void iterate(byte[][] startState) {
        for (int i = 0; i < startState.length; i++) {
            for (int j = 0; j < startState[0].length; j++) {
                if (startState[i][j] == 3) {
                    resultState[i][j] += 100;
                    incrementNeighbor(i, j - 1);
                    incrementNeighbor(i, j + 1);
                    incrementNeighbor(i + 1, j);
                    incrementNeighbor(i + 1, j - 1);
                    incrementNeighbor(i + 1, j + 1);
                    incrementNeighbor(i - 1, j);
                    incrementNeighbor(i - 1, j - 1);
                    incrementNeighbor(i - 1, j + 1);
                } else if ((startState[i][j] > 103) || (startState[i][j] > 100 && startState[i][j] < 102)) {
                    resultState[i][j] -= 100;
                    decrementNeighbor(i, j - 1);
                    decrementNeighbor(i, j + 1);
                    decrementNeighbor(i + 1, j);
                    decrementNeighbor(i + 1, j - 1);
                    decrementNeighbor(i + 1, j + 1);
                    decrementNeighbor(i - 1, j);
                    decrementNeighbor(i - 1, j - 1);
                    decrementNeighbor(i - 1, j + 1);
                }
            }
        }
    }

    private static void decrementNeighbor(int currentX, int currentY) {
        int length = resultState.length;
        int heigth = resultState[0].length;
        int neighborX = (currentX < 0 ? length - 1 : currentX == length ? 0 : currentX);
        int neighborY = (currentY < 0 ? heigth - 1 : currentY == heigth ? 0 : currentY);
        resultState[neighborX][neighborY]--;
    }

    private static void incrementNeighbor(int currentX, int currentY) {
        int length = resultState.length;
        int heigth = resultState[0].length;
        int neighborX = (currentX < 0 ? length - 1 : currentX == length ? 0 : currentX);
        int neighborY = (currentY < 0 ? heigth - 1 : currentY == heigth ? 0 : currentY);
        resultState[neighborX][neighborY]++;
    }

    public static byte[][] deepCopy(byte[][] original) {
        if (original == null) {
            return null;
        }

        final byte[][] result = new byte[original.length][];
        for (int i = 0; i < original.length; i++) {
            System.arraycopy(original[i], 0, result[i], 0, original[i].length);
        }
        return result;
    }
}
