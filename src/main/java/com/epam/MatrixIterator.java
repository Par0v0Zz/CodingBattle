package com.epam;

public class MatrixIterator {

    byte[][] resultState;

    public byte[][] iterateMatrix(byte[][] startState, int iterations) {

        resultState = startState.clone();

        for (int i = 0; i < iterations; i++) {
            iterate(startState);
            startState = resultState.clone();
        }

        return null;
    }

    private void iterate(byte[][] startState) {
        for (int i = 0; i < startState.length; i++) {
            for (int j = 0; j < startState[0].length; j++) {
                if (startState[i][j] == 3) {
                    resultState[i][j] += 100;
                    incrementNeighbours(i, j);
                } else if (startState[i][j] > 103) {
                    resultState[i][j] -= 100;
                    decrementNeighbours(i, j);
                } else if (startState[i][j] > 100 && startState[i][j] < 102) {
                    resultState[i][j] -= 100;
                    decrementNeighbours(i, j);
                }
            }
        }
    }

    private void decrementNeighbours(int i, int j) {
        resultState[i + 1][j] -= 1;
        resultState[i - 1][j] -= 1;
        resultState[i][j + 1] -= 1;
        resultState[i][j - 1] -= 1;
        resultState[i + 1][j + 1] -= 1;
        resultState[i + 1][j - 1] -= 1;
        resultState[i - 1][j + 1] -= 1;
        resultState[i - 1][j - 1] -= 1;
    }

    private void incrementNeighbours(int i, int j) {
        resultState[i + 1][j] += 1;
        resultState[i - 1][j] += 1;
        resultState[i][j + 1] += 1;
        resultState[i][j - 1] += 1;
        resultState[i + 1][j + 1] += 1;
        resultState[i + 1][j - 1] += 1;
        resultState[i - 1][j + 1] += 1;
        resultState[i - 1][j - 1] += 1;
    }
}
