package com.epam;

public class GameEngineImpl implements GameEngine {

    @Override
    public boolean[][] compute(boolean[][] initialState, int numberIterations) {
        MatrixIterator iterator = new MatrixIterator();

        byte[][] startState = parse(initialState);
        byte[][] resultState = iterator.iterateMatrix(startState, numberIterations);

        return parse(resultState);
    }

    private boolean[][] parse(byte[][] byteArray) {
        boolean[][] array = new boolean[byteArray.length][byteArray[0].length];
        for (int x = 0; x < array.length; x++) {
            for (int y = 0; y < array[x].length; y++) {
                if(byteArray[x][y] >= 100){
                    array[x][y] = true;
                }
            }
        }
        return array;
    }
    
    private byte[][] parse(boolean[][] array) {

        int height = array.length;
        int weight = array[0].length;

        byte[][] byteArray = new byte[height][weight];

        for (int x = 0; x < array.length; x++) {
            for (int y = 0; y < array[x].length; y++) {
                if (array[x][y]) {
                    byteArray[x][y] += 100;
                    incrementNeighbor(byteArray, x - 1, y - 1, height, weight);
                    incrementNeighbor(byteArray, x, y - 1, height, weight);
                    incrementNeighbor(byteArray, x + 1, y - 1, height, weight);
                    incrementNeighbor(byteArray, x - 1, y, height, weight);
                    incrementNeighbor(byteArray, x + 1, y, height, weight);
                    incrementNeighbor(byteArray, x - 1, y + 1, height, weight);
                    incrementNeighbor(byteArray, x, y + 1, height, weight);
                    incrementNeighbor(byteArray, x + 1, y + 1, height, weight);
                }
            }
        }

        return byteArray;
    }

    private void incrementNeighbor(byte[][] arr, int currentX, int currentY, int height, int weight) {
        int neighborX = (currentX < 0 ? height - 1 : currentX == height ? 0 : currentX);
        int neighborY = (currentY < 0 ? weight - 1 : currentY == weight ? 0 : currentY);
        arr[neighborX][neighborY]++;
    }

}
